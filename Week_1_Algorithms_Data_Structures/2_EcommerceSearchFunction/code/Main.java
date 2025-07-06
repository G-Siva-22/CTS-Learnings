public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Mobile", "Electronics"),
            new Product(104, "T-shirt", "Clothing"),
            new Product(105, "Watch", "Accessories")
        };

        System.out.println("Linear Search for 'Mobile':");
        Product result1 = SearchService.linearSearch(products, "Mobile");
        System.out.println(result1 != null ? result1 : "Product not found.");

        System.out.println("\nBinary Search for 'Mobile':");
        Product result2 = SearchService.binarySearch(products, "Mobile");
        System.out.println(result2 != null ? result2 : "Product not found.");

        System.out.println("\nBinary Search for 'Tablet':");
        Product result3 = SearchService.binarySearch(products, "Tablet");
        System.out.println(result3 != null ? result3 : "Product not found.");
    }
}
