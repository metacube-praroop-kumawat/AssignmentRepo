public interface IOrderSelector {
    Map<String, Object> getOrders(Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection);
    Map<String, Object> getProducts(String searchTerm, Integer pageNumber, Integer pageSize, String sortedBy, String sortedDirection);
}