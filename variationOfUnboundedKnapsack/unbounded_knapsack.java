public class unbounded_knapsack {
    public static void main(String[] args) {
        int wt[] = { 1, 3, 4, 5, 2, 7 };
        int[] profit = { 6, 2, 3, 6, 18, 8 };
        int W = 15;
        System.out.println("Maximum Profit is : " + knapsack_unbound(wt, profit, W, wt.length));
    }

    private static int knapsack_unbound(int[] wt, int[] value, int W, int N) {
        int[][] dp = new int[N + 1][W + 1];

        // initialize the firts row and column of the dp with 0
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {

                    // Here if we include an element in our dp then we can't move from this index
                    // because in future may be we need this index again but if not include then we
                    // moved from next index;

                    dp[i][j] = Math.max(value[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }
}