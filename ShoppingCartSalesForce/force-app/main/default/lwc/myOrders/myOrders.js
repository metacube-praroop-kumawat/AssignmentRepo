import { LightningElement, track, wire, api } from 'lwc';
import getOrders from '@salesforce/apex/MyOrderController.getOrders';

export default class MyOrders extends LightningElement {
    @track orders = [];
    @track currentPage = 1;
    @track totalPages = 1;
    @track sortedBy = 'Order_Total__c';
    @track sortedDirection = 'DESC';
    loading = false;
    pageSize = 5;

    columns = [
        {label: 'PO Id', fieldName: 'Id', sortable: true},
        {label: 'Order Date', fieldName: 'Order_Date__c', sortable: true},
        {label: 'Status', fieldName: 'Status__c', sortable: true},
        {label: 'Order Total', fieldName: 'Order_Total__c', sortable: true}
        
    ]

    connectedCallback(){
        this.fetchOrders();
    }

    fetchOrders(){
        this.loading = true;
        getOrders({
            pageNumber: this.currentPage,
            pageSize: this.pageSize,
            sortedBy: this.sortedBy,
            sortedDirection: this.sortedDirection
        }).then(result => {
            this.orders = result.orders;
            this.totalPages = result.totalPages;
            this.loading = false;
        }).catch(error => {
            console.error('Error fetching orders: ', error);
            this.loading = false;
        });
    }

    handlePageChange(event){
        this.currentPage = event.detail;
        this.fetchOrders();
    }

    handleSort(event){
        this.sortedBy = event.detail.fieldName;
        this.sortedDirection = event.detail.sortDirection;
        this.fetchOrders();
    }

    handleAddNewPurchaseOrder(){
        console.log("Purchase button event launched");
        this.dispatchEvent(new CustomEvent('switchview', { detail : 'purchaseNewOrder'}));
    }
}