public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Add Products
        manager.addProduct(new Product("P101", "Laptop", 10, 55000));
        manager.addProduct(new Product("P102", "Mouse", 50, 500));
        manager.addProduct(new Product("P103", "Keyboard", 30, 800));

        // Update a product
        manager.updateProduct("P102", 45, 475);

        // Delete a product
        manager.deleteProduct("P103");

        // Show final inventory
        manager.showInventory();
    }
}
