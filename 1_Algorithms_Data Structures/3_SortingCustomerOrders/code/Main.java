public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Alice", 1500.00),
            new Order(102, "Bob", 950.00),
            new Order(103, "Charlie", 2500.00),
            new Order(104, "David", 500.00),
            new Order(105, "Eve", 1800.00)
        };

        System.out.println("Original Orders:");
        SortService.printOrders(orders);

        // Bubble Sort
        System.out.println("\nSorted by Bubble Sort (Ascending by Total Price):");
        SortService.bubbleSort(orders);
        SortService.printOrders(orders);

        // Reset data for Quick Sort
        Order[] ordersQuick = {
            new Order(101, "Alice", 1500.00),
            new Order(102, "Bob", 950.00),
            new Order(103, "Charlie", 2500.00),
            new Order(104, "David", 500.00),
            new Order(105, "Eve", 1800.00)
        };

        System.out.println("\nSorted by Quick Sort (Ascending by Total Price):");
        SortService.quickSort(ordersQuick, 0, ordersQuick.length - 1);
        SortService.printOrders(ordersQuick);
    }
}
