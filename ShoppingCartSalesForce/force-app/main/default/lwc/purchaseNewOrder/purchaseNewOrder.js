import { api, LightningElement, track } from 'lwc';
import getProducts from '@salesforce/apex/MyOrderController.getProducts';
import updateSalesColumn from '@salesforce/apex/MyOrderController.updateSalesColumn';
import Quantity from '@salesforce/schema/Asset.Quantity';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';

export default class PurchaseNewOrder extends LightningElement {
    @track products = [];
    @api cartItems = [];
    searchTerm = '';
    currentPage = 1;
    totalPages = 1;
    sortedBy = 'Name';
    sortedDirection = 'ASC';
    pageSize = 10;
    showCart = false;

    columns = [
        { label: 'Product Code', fieldName: 'ProductCode', sortable: true },
        { label: 'Product Name', fieldName: 'Name', sortable: true },
        { label: 'Available Quantity', fieldName: 'Available_Quantity', type: 'number', sortable: true },
        { label: 'Price', fieldName: 'Product_Price__c', type: 'currency', sortable: true },  
    ];

    // called when component is rendered on screen
    connectedCallback() {
        this.fetchProducts();
    }

    //fetch products from controller
    fetchProducts() {
        getProducts({
            searchTerm: this.searchTerm,
            pageNumber: this.currentPage,
            pageSize: this.pageSize,
            sortedBy: this.sortedBy,
            sortedDirection: this.sortedDirection
        }).then(result => {
            this.products = result.products.map(product => {
                return { ...product, Available_Quantity : product.Quantity__c };
            });
            console.log("Products retrieved : ", this.products);
            // this.updateProductQuantity();
            this.totalPages = result.totalPages;
        }).catch(error => {
            console.error('Error fetching products: ', error);
        });
    }

    //handle search event in products
    handleSearch(event) {
        this.searchTerm = event.target.value;
        this.currentPage = 1;
        this.fetchProducts();
    }

    updateProductQuantity(){
        if(this.cartItems.length>0){
            this.products.map(product =>{
                let existingCartItem = this.cartItems.find(item => item.Id === product.Id);
                product.Quantity__c -= existingCartItem.Quantity__c;
                return product;
            })
        }
    }

    //handle page change through pagination component
    handlePageChange(event) {
        this.currentPage = event.detail;
        this.fetchProducts();
    }

    //used to sort products
    handleSort(event) {
        this.sortedBy = event.detail.fieldName;
        this.sortedDirection = event.detail.sortDirection;
        this.fetchProducts();
    }

    //remove from cart handler
    
    handleRemoveFromCart(event) {
        try {
            const productId = event.detail;
            let removedCartItem = this.cartItems.find(item => item.Id ===productId);
            this.cartItems = this.cartItems.filter(item => item.Id !== productId);
            console.log("cart items left : ", this.cartItems);
            let productIndex = this.products.findIndex(p => p.Id === productId);
            if (productIndex !== -1) {
                this.products[productIndex].Quantity__c += removedCartItem.Quantity__c;
                this.products=[...this.products];
            }
        } catch (error) {
            console.log("Error in remove from cart handler : ", error);
        }
    }

    //go to cart handle
    handleGoToCart() {
        this.showCart = true;
    }

    // showToast(title, message, variant){
    //     const evt = new ShowToastEvent({
    //         title: title,
    //         message: message,
    //         variant: variant,
    //     })
    //     this.dispatchEvent(evt);
    // }

    handleSwitchView(event){
        const view = event.detail.view;
        const orderItems = event.detail.orderItems;
        try {
            this.dispatchEvent(new CustomEvent('switchview', { detail:  {view: view, orderItems: orderItems}}));
        } catch (error) {
            console.log("Error Checkout : ", error);
        }
    }

    getSelectedName(event) {
        // Display that fieldName of the selected rows
        try {
            this.cartItems = event.detail.selectedRows.map((prod)=>{
                return {...prod};
            });
            this.cartItems.forEach(item => {
                let updateProduct = this.products.find((prod)=> prod.Id === item.Id);
                item.Quantity__c = 1; // Set each quantity to 1
                updateProduct.Available_Quantity =updateProduct.Quantity__c - 1;
            });
            this.products = [...this.products];
        } catch (error) {
            console.error("Error is : ", error.body.message);
            // this.showToast('Error', error.body.message, 'error');
        }
    }

    handleQuantityUpdate(event){
        const updatedProduct = event.detail;
        console.log("Updated products : ", updatedProduct);
        console.log("products available : ", this.products);
        updatedProduct.map((productUpdate)=>{
            let productToUpdate = this.products.find((product)=> product.Id === productUpdate.Id);
            let cartItemToUpdate = this.cartItems.find((item)=> item.Id === productUpdate.Id);
            if (productToUpdate.Quantity__c-productUpdate.Quantity__c>=0){
            productToUpdate.Available_Quantity = productToUpdate.Quantity__c - productUpdate.Quantity__c;
            cartItemToUpdate.Quantity__c = productUpdate.Quantity__c;
            }
            else{
                this.dispatchEvent(
                    new ShowToastEvent({
                        title: 'Error',
                        message: "Quantity Requested is more than available quantity",
                        variant: 'error',
                    })
                );
            }

        })

        this.products = [...this.products];
        this.cartItems = [...this.cartItems];
    }
    
}