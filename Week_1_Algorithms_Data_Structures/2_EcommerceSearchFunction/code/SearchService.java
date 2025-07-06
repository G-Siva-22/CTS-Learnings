import java.util.Arrays;
import java.util.Comparator;

public class SearchService {

    // Linear Search by product name
    public static Product linearSearch(Product[] products, String productName) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search by product name
    public static Product binarySearch(Product[] products, String productName) {
        // Sort array before binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = productName.compareToIgnoreCase(products[mid].getProductName());

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return null;
    }
}
