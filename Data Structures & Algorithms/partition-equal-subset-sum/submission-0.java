class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;

        int s = 0;

        for(int num : arr) s += num;

        if(s % 2 != 0) return false;

        int sum = s/2;

        Boolean[][] dp = new Boolean[n][sum + 1];

        return solve(arr, sum, 0, dp);
    }

    private static boolean solve(int arr[], int sum, int i, Boolean[][] dp) {

        // Base case
        if (sum == 0) return true;

        if (i >= arr.length) return false;

        // Already calculated
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        // TAKE
        boolean take = false;

        if (arr[i] <= sum) {
            take = solve(arr, sum - arr[i], i + 1, dp);
        }

        // SKIP
        boolean skip = solve(arr, sum, i + 1, dp);

        return dp[i][sum] = take || skip;
    }
}