class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, s, n, dp);
    }
    private int solve(int i, String s, int n, int[] dp){

        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;

        if (dp[i] != -1) {
            return dp[i];
        }


        int way1 = solve(i + 1, s, n, dp);
        int way2 = 0;
        if(i + 1 < n &&(s.charAt(i) == '1' || 
        (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))){
            way2 = solve(i+2, s, n, dp);
        }
        dp[i]= way1 + way2;
        return dp[i];
    }

}
