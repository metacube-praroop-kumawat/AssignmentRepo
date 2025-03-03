@isTest
public class MyOrderControllerTest {
    
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

        // Inject the mock into the controller
        MyOrderController.orderSelector = (IOrderSelector) mockOrderSelector;

        // Test method
        Test.startTest();
        Map<String, Object> result = MyOrderController.getOrders(1, 10, 'Order_Date__c', 'ASC');
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

        // Inject the mock into the controller
        MyOrderController.orderSelector = (IOrderSelector) mockOrderSelector;

        // Test method
        Test.startTest();
        Map<String, Object> result = MyOrderController.getProducts('Test', 1, 10, 'Name', 'ASC');
        Test.stopTest();

        // Verify results
        System.assertNotEquals(null, result);
        System.assertEquals(1, result.get('totalPages'));
        System.assertEquals(1, ((List<Product2>)result.get('products')).size());
    }

    @isTest
    static void testPlaceOrder() {
        // Create a mock for IPlaceOrderService
        fflib_Mock mockPlaceOrderService = new fflib_Mock(IPlaceOrderService.class);
        mockPlaceOrderService.setup('placeOrder', 'Order successfully placed');

        // Inject the mock into the controller
        MyOrderController.placeOrderService = (IPlaceOrderService) mockPlaceOrderService;

        // Setup test data
        List<Product2> products = new List<Product2>{
            new Product2(Name = 'Test Product', Quantity__c = 10, Product_Price__c = 20.00)
        };

        // Test method
        Test.startTest();
        String result = MyOrderController.placeOrder(products);
        Test.stopTest();

        // Verify results
        System.assertEquals('Order successfully placed', result);
    }

    @isTest
    static void testUpdateQuantity() {
        // Create a mock for IPlaceOrderService
        fflib_Mock mockPlaceOrderService = new fflib_Mock(IPlaceOrderService.class);
        mockPlaceOrderService.setup('updateQuantity', null); // No return value needed

        // Inject the mock into the controller
        MyOrderController.placeOrderService = (IPlaceOrderService) mockPlaceOrderService;

        // Setup test data
        PurchaseOrderLineItem__c lineItem = new PurchaseOrderLineItem__c(Quantity__c = 5);
        insert lineItem;

        // Test method
        Test.startTest();
        MyOrderController.updateQuantity(lineItem.Id, 10);
        Test.stopTest();

        // Verify that the mock was called
        System.assert(mockPlaceOrderService.verify('updateQuantity', new List<Object>{lineItem.Id, 10}));
    }
}
