public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        // Add employees
        manager.addEmployee(new Employee(1, "Alice", "Developer", 60000));
        manager.addEmployee(new Employee(2, "Bob", "Manager", 75000));
        manager.addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        // Display all
        manager.displayEmployees();

        // Search
        System.out.println("\nSearching for employee with ID 2:");
        Employee found = manager.searchEmployee(2);
        System.out.println(found != null ? found : "Employee not found");

        // Delete
        manager.deleteEmployee(2);

        // Display after deletion
        manager.displayEmployees();
    }
}
