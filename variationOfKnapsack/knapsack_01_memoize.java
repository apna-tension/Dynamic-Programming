import java.util.*;
public class knapsack_01_memoize {
    public static int[][] dp;
    public static void main(String[] args) {
        int[] profit = {10, 5, 15, 7, 6, 18, 3};
        int[] wt = {2, 3, 5, 7, 1, 4, 1};
        int capacity = 15;
        int n = wt.length;
        dp = new int[n+1][capacity+1];
        fill(dp, -1);
        // we can use the 'tabulation' and 'recursive' method in this class, and we dont need to create the object of other class because they all are static method 
        System.out.println("Maximum Profit using Recursion : " + knapsack_01_recursive.knapSack(wt, profit, capacity, n));
        System.out.println("Maximum Profit ustin DP Memoization : " + memoize(wt, profit, capacity, n));
        System.out.println("Maximum profit using DP Tabulation : " + knapsack_01_tabulation.knapsackTabulation(wt, profit, capacity, n));
    }

    private static void fill(int[][] dp, int n) {
        for (int[] arr : dp) {
            Arrays.fill(arr, n);
        }
    }
    private static int memoize(int[] wt, int[] profit, int capacity, int n) {
        if (n == 0 || capacity == 0) return 0;
        if (dp[n][capacity] != -1) return dp[n][capacity];
        if (wt[n-1] <= capacity) {
            dp[n][capacity] = Math.max(
                profit[n-1] + memoize(wt, profit, capacity-wt[n-1], n-1), 
                memoize(wt, profit, capacity, n-1)
            );
        } else if (wt[n-1] > capacity) {
            dp[n][capacity] = memoize(wt, profit, capacity, n-1);
        }
        return dp[n][capacity];

    }
}