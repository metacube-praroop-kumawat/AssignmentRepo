@isTest
public class MyOrderControllerMock {
    
    public static Map<String, Object> mockGetOrders(Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection) {
        // Create mock data
        List<PurchaseOrder__c> mockOrders = new List<PurchaseOrder__c>();
        for (Integer i = 0; i < pageSize; i++) {
            // Create a mock PurchaseOrder__c without setting Order_Total__c
            mockOrders.add(new PurchaseOrder__c(Id = 'mockId' + i, Status__c = 'New'));
        }
        
        // Create a mock response
        Map<String, Object> response = new Map<String, Object>();
        response.put('orders', mockOrders);
        response.put('totalPages', 2); // Assuming there are 10 total orders and pageSize is 5
        
        return response;
    }

    public static Map<String, Object> mockGetProducts(String searchTerm, Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection) {
        // Create mock data
        List<Product2> mockProducts = new List<Product2>();
        for (Integer i = 0; i < pageSize; i++) {
            mockProducts.add(new Product2(Id = 'mockProductId' + i, Name = 'Test Product ' + i, Quantity__c = 10, Product_Price__c = 20.0));
        }
        
        // Create a mock response
        Map<String, Object> response = new Map<String, Object>();
        response.put('products', mockProducts);
        response.put('totalPages', 2); // Assuming there are 10 total products and pageSize is 5
        
        return response;
    }

    public static String mockPlaceOrder(List<Product2> orderItems) {
        // Simulate placing an order
        if (orderItems.isEmpty()) {
            throw new AuraHandledException('No items to place an order.');
        }
        return 'order successfully placed';
    }

    public static void mockUpdateSalesColumn(Id recordId, Decimal newValue) {
        // Simulate updating a sales column
        // In a real scenario, you would perform a DML operation here
        // For the mock, we can just simulate success
        if (newValue <= 0) {
            throw new AuraHandledException('Quantity must be greater than zero.');
        }
    }
}
