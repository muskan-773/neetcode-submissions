class Solution {
    public int maxProduct(int[] nums) {

        int currMax = nums[0];
        int currMin = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int a = nums[i];
            int b = currMax * nums[i];
            int c = currMin * nums[i];

            int newMax = Math.max(a, Math.max(b, c));
            int newMin = Math.min(a, Math.min(b, c));

            currMax = newMax;
            currMin = newMin;

            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}