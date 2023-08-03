// 0/1 knapsack problem usning just normal recursing 
public class knapsack_01_recursive {
    public static void main(String[] args) {
        int[] wt = {2,3,5,7,1,4,1};
        int[] profit = {10,5,15,7,6,18,3};
        int capacity = 15;
        System.out.println(knapSack(wt, profit, capacity, wt.length));
    } 
    
    private static int knapSack(int[] wt, int profit[], int capacity, int n) {
        if (n == 0 || capacity == 0) return 0;
        if (wt[n-1] <= capacity) {
            return Math.max(
                profit[n-1] + knapSack(wt, profit, capacity-wt[n-1], n-1),
                knapSack(wt, profit, capacity, n-1)
            );
        } else  {
            return knapSack(wt, profit, capacity, n-1);
        }
    }
}