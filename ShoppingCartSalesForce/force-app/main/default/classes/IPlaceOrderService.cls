public interface IPlaceOrderService {
    String placeOrder(List<Product2> orderItems);
    void updateQuantity(Id recordId, Decimal newValue);
}

