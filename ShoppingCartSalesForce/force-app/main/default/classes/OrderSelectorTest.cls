@isTest
public class OrderSelectorTest {
    
    @isTest
    static void testGetOrders() {
        // Create a mock for IOrderSelector
        fflib_Mock mockOrderSelector = new fflib_Mock(IOrderSelector.class);
        mockOrderSelector.setup('getOrders', new Map<String, Object>{
            'orders' => new List<PurchaseOrder__c>{
                new PurchaseOrder__c(Status__c = 'New', Order_Total__c = 100.00, Order_Date__c = Date.today())
            },
            'totalPages' => 1
        });

        // Inject the mock into the OrderSelector
        OrderSelector orderSelector = (OrderSelector) mockOrderSelector;

        // Test method
        Test.startTest();
        Map<String, Object> result = orderSelector.getOrders(1, 10, 'Order_Date__c', 'ASC');
        Test.stopTest();

        // Verify results
        System.assertNotEquals(null, result);
        System.assertEquals(1, result.get('totalPages'));
        System.assertEquals(1, ((List<PurchaseOrder__c>)result.get('orders')).size());
    }

    @isTest
    static void testGetProducts() {
        // Create a mock for IOrderSelector
        fflib_Mock mockOrderSelector = new fflib_Mock(IOrderSelector.class);
        mockOrderSelector.setup('getProducts', new Map<String, Object>{
            'products' => new List<Product2>{
                new Product2(Name = 'Test Product', Quantity__c = 10, Product_Price__c = 20.00)
            },
            'totalPages' => 1
        });

        // Inject the mock into the OrderSelector
        OrderSelector orderSelector = (OrderSelector) mockOrderSelector;

        // Test method
        Test.startTest();
        Map<String, Object> result = orderSelector.getProducts('Test', 1, 10, 'Name', 'ASC');
        Test.stopTest();

        // Verify results
        System.assertNotEquals(null, result);
        System.assertEquals(1, result.get('totalPages'));
        System.assertEquals(1, ((List<Product2>)result.get('products')).size());
    }
}
