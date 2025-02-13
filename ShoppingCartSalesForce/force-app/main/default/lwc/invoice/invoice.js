import { LightningElement, api, wire } from 'lwc';
import placeOrder from '@salesforce/apex/MyOrderController.placeOrder';
import { ShowToastEvent } from 'lightning/platformShowToastEvent';


export default class Invoice extends LightningElement {
    @api items = [];
    orderResponse;

    columns = [
        { label: 'Product Code', fieldName: 'ProductCode', type: 'text' },
        { label: 'Product Name', fieldName: 'Name', type: 'text' },
        { label: 'Quantity', fieldName: 'Quantity__c', type: 'number' },
        { label: 'Unit Price', fieldName: 'Product_Price__c', type: 'currency' },  
    ];

    

    async handlePlaceOrder(){
        console.log("working");
        try {
            await placeOrder({ orderItems: this.items }).then(response =>{
                this.orderResponse = response;
                console.log("Request send : ", response);
                this.showToast('Success', this.orderResponse, 'success');
                this.dispatchEvent(new CustomEvent('switchview', {detail: 'orderPlaced'}));
            }).catch(error => {
                console.error("error placing order : ", error);
                this.showToast('Error', error.body.message, 'order');
            })
        } catch (error) {
            console.log("Error calling placeOrder function : ", error);
        }
    }

    showToast(title, message, variant){
        const evt = new ShowToastEvent({
            title: title,
            message: message,
            variant: variant,
        })
        this.dispatchEvent(evt);
    }
}