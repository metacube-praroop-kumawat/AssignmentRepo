public with sharing class MyOrderController {

    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getOrders(Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection){
        Integer offsetSize = (pageNumber - 1) * pageSize;
        String query = 'SELECT Id, Status__c, Order_Total__c FROM purchaseOrder__c ORDER BY ' + 
                       sortedBy + ' ' + sortedDirection + ' LIMIT ' + pageSize + ' OFFSET ' + offsetSize;
        List<purchaseOrder__c> orders = Database.query(query);
        Integer totalOrders = [SELECT COUNT() FROM purchaseOrder__c];
        Decimal totalPages = Math.ceil((Decimal)totalOrders / pageSize);
        return new Map<String, Object>{
            'orders' => orders,
                'totalPages' => totalPages
        	};
    }
    
    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getProducts(String searchTerm, Integer pageNumber,Integer pageSize, String sortedBy, String sortedDirection){
        Integer offsetSize = (pageNumber - 1) * pageSize;
        System.debug('searchTerm : ' + searchTerm + ' pageNumber : ' + pageNumber + ' pageSize : ' + pageSize);
        System.debug('sorted By : ' + sortedBy + ' sortedDirection : ' + sortedDirection);
        String query = 'SELECT Id, Name, ProductCode, Quantity__c, Product_Price__c FROM Product2 WHERE ' +
            		   'Quantity__c > 0 AND Name LIKE \'' + '%' + searchTerm + '%' + '\' ORDER BY ' + 
                        sortedBy + ' ' + sortedDirection + ' LIMIT ' + pageSize + ' OFFSET ' + offsetSize;
        List<Product2> products = Database.query(query);
        System.debug('Products : ' + products);
        Integer totalProducts = [SELECT COUNT() FROM Product2 WHERE Quantity__c > 0 AND Name LIKE :('%' + searchTerm + '%')];
        System.debug('total Products : ' + totalProducts);
        Decimal totalPages = Math.ceil((Decimal)totalProducts / pageSize);
        return new Map<String, Object>{
            'products' => products,
                'totalPages' => totalPages
        	};
    }
    
    @AuraEnabled
    public static String placeOrder(List<Product2> orderItems){
        try{
            System.debug('Items received: ' + orderItems);
            
            //create new purchaseOrder record
            PurchaseOrder__c newOrder = new PurchaseOrder__c();
            insert newOrder;
            
            //create list for purchase order items
            List<PurchaseOrderLineItem__c> lineItems = new List<PurchaseOrderLineItem__c>();
            
            for(Product2 orderItem: orderItems){
                PurchaseOrderLineItem__c item = new PurchaseOrderLineItem__c();
                item.Product__c = orderItem.Id;
                item.PurchaseOrder__c = newOrder.Id;
                item.Quantity__c = orderItem.Quantity__c;
                item.UnitPrice__c= orderItem.Product_Price__c;
                lineItems.add(item);
            }
            
            insert lineItems;
            System.debug('order placed: ' + newOrder);
            return 'order successfully placed';
        }catch(Exception e){
            System.debug('Error placing order : ' + e.getMessage());
            throw new AuraHandledException('Error processing order : ' + e.getMessage());
        }
        
    }
    @AuraEnabled
    public static void updateSalesColumn(Id recordId, Decimal newValue) {
        PurchaseOrderLineItem__c salesRecord = [SELECT Id, Quantity__c,unitPrice__c FROM PurchaseOrderLineItem__c WHERE Id = :recordId LIMIT 1];
        salesRecord.Quantity__c = newValue;
        update salesRecord;
    }
}   