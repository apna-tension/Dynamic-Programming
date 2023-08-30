// return true if any subset sum is equal to the given target sum else reurn false;
import java.util.*;
public class subsetSum_recursive {
    public static void main(String[] args) {
        int[] arr = {2,4,6,7,4,8,9};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Sum : ");
        int sum = sc.nextInt();
        System.out.println(isExist(arr, sum, arr.length));
    }
    private static boolean isExist(int[] arr, int sum, int n) {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (arr[n-1] <= sum) return isExist(arr, sum-arr[n-1], n-1) || isExist(arr, sum, n-1);
        else return isExist(arr, sum, n-1);
    }
}