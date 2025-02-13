import { LightningElement, api, track } from 'lwc';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';


export default class MyCart extends LightningElement {
    @api cartItems = [];
    @track draftValues;
    checkout=true;

    columns = [
        { label: 'Product Code', fieldName: 'ProductCode', type: 'text' },
        { label: 'Product Name', fieldName: 'Name', type: 'text' },
        { label: 'Quantity', fieldName: 'Quantity__c', type: 'number' ,editable:true },
        { label: 'Unit Price', fieldName: 'Product_Price__c', type: 'currency' },
        {
            label: 'Remove',
            type: 'button',
            typeAttributes: {
                label: 'Remove',
                name: 'remove_from_cart',
                variant: 'destructive'
            }
        }
    ];

    //use to handle addToCart action 
    handleRowAction(event) {
        const actionName = event.detail.action.name;
        const selectedProduct = event.detail.row;
        if (actionName === 'remove_from_cart') {
            this.handleRemove(selectedProduct);
        }
    }

    handleRemove(product) {
        try{
            const productId = product.Id;
            console.log("product to be deleted : ", productId);
            this.dispatchEvent(new CustomEvent('removefromcart', { detail: productId }));
        }catch(error){
            console.error("Remove cart error : ", error);
        }
    }

    handleCheckout(){
        
        try {
            this.dispatchEvent(new CustomEvent('switchview', { detail:  {view: 'showInvoice', orderItems: this.cartItems}}));
        } catch (error) {
            console.log("Error Checkout : ", error);
        }
        }
       

        handleSave(event) {
            const updatedFields = event.detail.draftValues;
            let validUpdate = true; // Flag to check if all quantities are valid
            console.log(updatedFields);
            
            // Check if all updated quantities are greater than zero
            updatedFields.forEach(item => {
                console.log(item);
                
                if (item.Quantity__c<= 0 || item.Quantity__c>item.Available_Quantity__c) {
                    validUpdate = false; // Set flag to false if any quantity is invalid
                }
            });
        
            if (validUpdate) {
                // Proceed with the save operation
                console.log(updatedFields);
                this.dispatchEvent(new CustomEvent('updatequantity', { detail: updatedFields }));
                this.draftValues = []; // Clear draft values
            } else {
                // Handle the case where one or more quantities are invalid
                this.showErrorMessage('Quantity must be greater than zero.');
            }
        }
        
        showErrorMessage(message) {
            this.dispatchEvent(
                new ShowToastEvent({
                    title: 'Error',
                    message: message,
                    variant: 'error',
                })
            );
        }
}