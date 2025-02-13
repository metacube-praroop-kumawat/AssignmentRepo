import { LightningElement, track, api } from 'lwc';

export default class ShoppingApp extends LightningElement {
    @track showMyOrders = true;
    @track showPurchaseNewOrder = false;
    @track showInvoice = false;
    @api cartItems = [];

    handleSwitchView(event){
        const view = event.detail;

        console.log("current view : " , view);
        
        this.showMyOrders = view === 'myOrders';
        this.showPurchaseNewOrder = view === 'purchaseNewOrder';
        if(event.detail?.view === 'showInvoice'){
            this.cartItems = event.detail.orderItems;
        }

        if(view === 'orderPlaced'){
            this.showMyOrders = true;
        }
        this.showInvoice = event.detail?.view === 'showInvoice';
    }
}