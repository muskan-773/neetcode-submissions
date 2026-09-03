class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        Boolean[][] dp = new Boolean[n][n];
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                if(solve(s, i, j, dp)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean solve(String s, int i, int j, Boolean[][] dp){
        if(i >= j) return true;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = solve(s, i+1, j-1, dp);
        }
        else dp[i][j] = false;

        return dp[i][j];
    }
}
