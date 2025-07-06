public class Main {
    public static void main(String[] args) {
        double presentValue = 1000.0;  // ₹1000
        double annualGrowthRate = 0.10; // 10%
        int years = 5;

        System.out.println("Recursive Forecast (Simple):");
        double futureValue = FinancialForecast.predictFutureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Future value after %d years = ₹%.2f\n", years, futureValue);

        System.out.println("\nRecursive Forecast (With Memoization):");
        double[] memo = new double[years + 1];
        double memoizedValue = FinancialForecast.predictFutureValueMemo(presentValue, annualGrowthRate, years, memo);
        System.out.printf("Future value after %d years = ₹%.2f\n", years, memoizedValue);
    }
}
