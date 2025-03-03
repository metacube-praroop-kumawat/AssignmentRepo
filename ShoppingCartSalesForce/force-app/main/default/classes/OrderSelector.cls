public class OrderSelector implements IOrderSelector {
    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getOrders(Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection) {
        Integer offsetSize = (pageNumber - 1) * pageSize;
        String query = 'SELECT Id, Status__c, Order_Total__c, Order_Date__c FROM purchaseOrder__c ORDER BY ' + 
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
    public static Map<String, Object> getProducts(String searchTerm, Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection) {
        Integer offsetSize = (pageNumber - 1) * pageSize;
        String query = 'SELECT Id, Name, ProductCode, Quantity__c, Product_Price__c FROM Product2 WHERE ' +
                       'Quantity__c > 0 AND Name LIKE \'' + '%' + searchTerm + '%' + '\' ORDER BY ' + 
                       sortedBy + ' ' + sortedDirection + ' LIMIT ' + pageSize + ' OFFSET ' + offsetSize;
        List<Product2> products = Database.query(query);
        Integer totalProducts = [SELECT COUNT() FROM Product2 WHERE Quantity__c > 0 AND Name LIKE :('%' + searchTerm + '%')];
        Decimal totalPages = Math.ceil((Decimal)totalProducts / pageSize);
        return new Map<String, Object>{
            'products' => products,
            'totalPages' => totalPages
        };
    }
}
