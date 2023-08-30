public class knapsack_01_tabulation {
    // we don't write the main function for this
    // this class is fetched by knapsack_01_memoization by using the instence of this class.
    // no need to create an object of this class because we define the method using static keyword;
    public static int knapsackTabulation(int[] wt, int[] profit, int w, int n) {
        int[][] dp = new int[n+1][w+1];
        // Initialization of tabulation method with base condition of memoization method
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }

        // fill the table by calculating all types of subproblem 
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if (wt[i-1] <= j) {
                    dp[i][j] = Math.max(profit[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else if (wt[i-1] > w) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // return the maximum profit which is store in the bottom-right corneer of the table
        return dp[n][w];
    }
}