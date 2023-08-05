import java.util.*;
public class subsetSum_tabulation {
    public static void main(String[] args) {
        int[] arr = {2,4,6,7,4,8,9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Sum : ");
        int sum = sc.nextInt();
        System.out.println(isExist(arr, sum));
    }
    private static boolean isExist(int[] arr, int sum) {
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
        return dp[n][sum];
    }
}
