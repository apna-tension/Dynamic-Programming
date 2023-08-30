// import java.
public class equalSum_tabulation_recursive {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int sum = 0;
        for (int i : arr) sum += i;
        System.out.println("Sum is : " + sum);
        if (sum % 2 == 1) {System.out.println("Not possible");return;}
        System.out.println(isPossible(arr, sum/22));
        System.out.println(isPossible(arr, arr.length, sum/2));
    }
    private static boolean isPossible(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length+1][sum+1];
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
            }
        }

        for (int i = 1; i < arr.length+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j ) dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[arr.length][sum];
    }

    private static boolean isPossible(int[] arr, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (arr[n-1] <= sum) {
            return isPossible(arr, n-1, sum-arr[n-1]) || isPossible(arr, n-1, sum);
        } else {
            return isPossible(arr, n-1, sum);
        }
    }
    
}