public class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(String id) {
        // Simulate fetching from database
        return new Customer(id, "John Doe");
    }
}
