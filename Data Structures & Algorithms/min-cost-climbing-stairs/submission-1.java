class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(solve(n-1, cost, dp), solve(n-2, cost, dp));
    }
    private int solve(int i, int[] cost, int[] dp){
        if(i < 0) return 0;
        if(dp[i] != -1) return dp[i];
        int a = cost[i] + solve(i-1,cost, dp);
        int b = cost[i] + solve(i-2,cost, dp);
        dp[i] = Math.min(a, b);
        return dp[i];
    }
}
