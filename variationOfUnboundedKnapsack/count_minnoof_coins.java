public class count_minnoof_coins {
    public static void main(String args[]) {
        int coins[] = {1,3,2};
        int sum = 5;
        System.out.println("ans is " + tabulation(coins, sum));
    }
    private static int tabulation(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0) dp[i][j] = 0;
                if (i == 0) dp[i][j] = Integer.MAX_VALUE - 1;
                if (i == 1 && j != 0) {
                    if (j % coins[0] == 0) dp[i][j] = j/coins[0];
                    else if (j % coins[0] != 0) dp[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coins[i-1]]+1, dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}