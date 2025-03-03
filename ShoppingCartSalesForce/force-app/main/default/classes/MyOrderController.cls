public with sharing class MyOrderController {

    // Declare interfaces for dependency injection
    private static IOrderSelector orderSelector = new OrderSelector();
    private static IPlaceOrderService placeOrderService = new PlaceOrderService();

    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getOrders(Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection) {
        return orderSelector.getOrders(pageNumber, pageSize, sortedBy, sortedDirection);
    }
    
    @AuraEnabled(cacheable=true)
    public static Map<String, Object> getProducts(String searchTerm, Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection) {
        return orderSelector.getProducts(searchTerm, pageNumber, pageSize, sortedBy, sortedDirection);
    }
    
    @AuraEnabled
    public static String placeOrder(List<Product2> orderItems) {
        return placeOrderService.placeOrder(orderItems);
    }

    @AuraEnabled
    public static void updateQuantity(Id recordId, Decimal newValue) {
        placeOrderService.updateQuantity(recordId, newValue);
    }
}
