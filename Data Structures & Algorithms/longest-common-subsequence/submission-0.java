class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[1001][1001];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(t1, t2, 0, 0, dp);
    }
    private int solve(String t1, String t2, int i,int j, int[][] dp){
        if(i >= t1.length() || j >= t2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = 1 + solve(t1, t2, i+1, j+1, dp);
        }
        return dp[i][j] = Math.max(solve(t1, t2, i+1, j, dp), 
        solve(t1, t2, i, j+1, dp)); 
    }
}
