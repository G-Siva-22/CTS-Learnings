public class Main {
    public static void main(String[] args) {
        // Step 1: Create repository instance
        CustomerRepository repo = new CustomerRepositoryImpl();

        // Step 2: Inject it into service using constructor
        CustomerService service = new CustomerService(repo);

        // Step 3: Use the service
        service.printCustomerDetails("C102");
    }
}
