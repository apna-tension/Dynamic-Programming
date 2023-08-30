import java.util.Arrays;

public class cntNoSubsetWithGivenDiff {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int sum = 7;
        int diff = 1;
        sum = (diff+sum) / 2;
        System.out.println(tabulation(arr, sum));
    }
    public static int tabulation(int[] arr, int sum) {
        int[][] dp = new int[arr.length+1][sum+1];
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[arr.length][sum];
    }
}