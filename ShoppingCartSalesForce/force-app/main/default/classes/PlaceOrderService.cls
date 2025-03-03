public class PlaceOrderService implements IPlaceOrderService {
    public String placeOrder(List<Product2> orderItems) {
        try {
            // Create new purchaseOrder record
            PurchaseOrder__c newOrder = new PurchaseOrder__c();
            insert newOrder;

            // Map of product2 object
            Map<Id, Product2> updatedProductsMap = new Map<Id, Product2>();
            for (Product2 orderItem : orderItems) {
                updatedProductsMap.put(orderItem.Id, orderItem);
            }

            // Create list for purchase order items
            List<PurchaseOrderLineItem__c> lineItems = new List<PurchaseOrderLineItem__c>();
            List<Product2> updatedProducts = [SELECT Id, Quantity__c FROM Product2 WHERE Id IN :updatedProductsMap.keySet()];

            // Update product quantities
            for (Product2 productToUpdate : updatedProducts) {
                Product2 updatedProduct = updatedProductsMap.get(productToUpdate.Id);
                productToUpdate.Quantity__c = productToUpdate.Quantity__c - updatedProduct.Quantity__c;
            }

            // Create line items for the order
            for (Product2 orderItem : orderItems) {
                PurchaseOrderLineItem__c item = new PurchaseOrderLineItem__c();
                item.Product__c = orderItem.Id;
                item.PurchaseOrder__c = newOrder.Id;
                item.Quantity__c = orderItem.Quantity__c;
                item.UnitPrice__c = orderItem.Product_Price__c;
                lineItems.add(item);
            }

            // Insert line items and update product quantities
            insert lineItems;
            update updatedProducts;

            return 'Order successfully placed';
        } catch (Exception e) {
            throw new AuraHandledException('Error processing order: ' + e.getMessage());
        }
    }

    public void updateQuantity(Id recordId, Decimal newValue) {
        PurchaseOrderLineItem__c salesRecord = [SELECT Id, Quantity__c, UnitPrice__c FROM PurchaseOrderLineItem__c WHERE Id = :recordId LIMIT 1];
        salesRecord.Quantity__c = newValue;
        update salesRecord;
    }
}