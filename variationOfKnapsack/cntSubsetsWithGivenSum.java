import java.util.*;
public class cntSubsetsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Sum : ");
        int sum = sc.nextInt();
        System.out.println(isPossible(arr, sum));
        sc.close();
    }
    private static int isPossible(int[] arr, int sum) {
        int[][] dp = new int[arr.length+1][sum+1];
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0) dp[i][j] = 0;
                if (j == 0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j ) dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        for (int[] bl : dp) {
            System.out.println(Arrays.toString(bl));
        }
        System.out.println();
        return dp[arr.length][sum];
    }
}