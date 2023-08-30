public class LCS_Memoization {
    static int[][] dp;
    public static void main(String[] args) {
        String str1 = "abcdefghi";
        String str2 = "abddkfhki";
        int m = str2.length();
        int n = str1.length();
        dp = new int[n+1][m+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        System.out.println("Maximum Subsequence = " + memoize(str1, str2, n, m));

    }
    private static int memoize(String x, String y, int n, int m) {
        if (m == 0 || n == 0) return 0;
        if (dp[n][m] != 0) return dp[n][m];
        if (x.charAt(n-1) == y.charAt(m-1)) 
            dp[n][m] = 1 + memoize(x, y, n-1, m-1);
        else 
            dp[n][m] = Math.max(memoize(x, y, n-1, m), memoize(x, y, n, m-1));
        return dp[n][m];
    }
}