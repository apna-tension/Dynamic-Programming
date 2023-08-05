import java.util.*;

public class subsetSum_memoize {
    // public static int[][] dp;
    public static void main(String[] args) {
        System.out.println("Enter the sum : ");
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] arr = {2,4,6,7,4,8,9};
        int n = arr.length;
        if (memoize(arr, sum, n) != 0) System.out.println("Yes");
        else System.out.println("NO");
    }
    public static int memoize(int[] arr, int sum, int n) {
        int[][] dp = new int[n+1][sum+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = -1;
            }
        }

        if (sum == 0) return 1;
        if (n <= 0) return 0;
        if (dp[n-1][sum] != -1) return dp[n-1][sum];
        if (arr[n-1] > sum) {
            return dp[n-1][sum] = memoize(arr, sum, n-1);
        }
        else {
            if (memoize(arr, sum - arr[n-1], n-1) != 0 || memoize(arr, sum, n-1) != 0) return dp[n-1][sum] = 1;
            else return dp[n-1][sum] = 0;
        }
        // return dp[n][sum];
    }
}