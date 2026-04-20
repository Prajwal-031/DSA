public class Knapsack {
    /**
     * 0/1 Knapsack Problem - Classic NP-Complete Problem
     * Given weights[], values[] and capacity W, find maximum value subset of items
     * where sum(weights) <= W.
     * 
     * Uses DP with O(nW) time/space (pseudo-polynomial).
     * Exact solution for NP-hard problem.
     */

    // DP table: dp[i][w] = max value using first i items with capacity w
    private int[][] dp;

    public int knapsack(int W, int[] wt, int[] val, int n) {
        dp = new int[n + 1][W + 1];
        
        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                // Don't take ith item
                dp[i][w] = dp[i - 1][w];
                
                // Take ith item if possible
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i][w],
                        dp[i - 1][w - wt[i - 1]] + val[i - 1]
                    );
                }
            }
        }
        
        return dp[n][W];
    }

    // Utility to print DP table (for visualization)
    public void printTable() {
        int n = dp.length - 1;
        int W = dp[0].length - 1;
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.printf("%4d", dp[i][w]);
            }
            System.out.println();
        }
    }

    // Example usage
    public static void main(String[] args) {
        Knapsack k = new Knapsack();
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;
        
        int maxValue = k.knapsack(W, wt, val, n);
        System.out.println("Maximum value: " + maxValue);
        k.printTable();
    }
}
