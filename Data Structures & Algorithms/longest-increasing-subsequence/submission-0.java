class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, -1, nums, dp);
    }
    private int solve(int i, int p, int[] nums, int[][] dp){
        if(i == nums.length) return 0;
        if(dp[i][p+1] != -1) return dp[i][p+1];

        int take = 0;
        int skip = 0;
        if(p == -1 || nums[p] < nums[i]){
            take = 1 + solve(i+1, i, nums, dp);
        }
        skip = solve(i+1, p, nums, dp);
        return dp[i][p+1] = Math.max(take, skip);
    }
}
