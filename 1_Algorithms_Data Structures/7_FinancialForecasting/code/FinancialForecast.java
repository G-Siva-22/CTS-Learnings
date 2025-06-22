public class FinancialForecast {

    // Recursive method to calculate future value
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return predictFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized version using memoization
    public static double predictFutureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) return presentValue;

        if (memo[years] != 0) return memo[years];

        memo[years] = predictFutureValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }
}
