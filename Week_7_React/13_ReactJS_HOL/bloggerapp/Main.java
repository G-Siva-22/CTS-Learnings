import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of rows (must be even)
        System.out.print("Enter number of rows (even): ");
        int rows = sc.nextInt();

        // Input number of columns (must be even)
        System.out.print("Enter number of columns (even): ");
        int cols = sc.nextInt();

        if(rows % 2 != 0 || cols % 2 != 0) {
            System.out.println("Please enter EVEN numbers for both rows and columns.");
            return;
        }

        // Print the matrix
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
