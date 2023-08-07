import java.util.*;
public class minSubsetSumDiff {
    public static void main(String[] args) {
        int[] arr = {1,6,11,5};
        int sum = 0;
        for (int i : arr) sum += i;
        boolean[][] dp = subsetSum(arr, sum); // call the subsetSum method;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum/2; i++) {
            if (dp[arr.length][i]) {
                diff = Math.min(diff, Math.abs((sum - (2*i))));
            }
        }
        System.out.println(diff);
    }
    private static boolean[][] subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i = 1; i < sum+1; i++) dp[0][i] = false;
        for (int i = 0; i < n+1; i++) dp[i][0] = true;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                } else if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp;
    }
}