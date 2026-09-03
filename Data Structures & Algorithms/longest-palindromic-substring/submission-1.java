class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
         if (n <= 1) return s;
        int maxLen = 0;
        int sp = 0;
        Boolean[][] dp = new Boolean[n][n];
    
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                if(solve(s, i, j, dp)){
                    if((j-i+1) > maxLen){
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp + maxLen);
    }
    private boolean solve(String s, int i, int j, Boolean[][] dp){

        if(i >= j) return true;

        if(dp[i][j] != null) {
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = solve(s, i+1, j-1, dp);
        }else{
            dp[i][j] = false;
        }
        return dp[i][j];
    }
}
