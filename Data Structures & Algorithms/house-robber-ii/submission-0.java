class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int case1 = rob1(Arrays.copyOfRange(nums, 0, n - 1));
        int case2 = rob1(Arrays.copyOfRange(nums, 1, n));

        return Math.max(case1, case2);
    }
    public int rob1(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);

        for(int i = 2;i < n;i++){
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
        }
        return nums[n-1];
    }
}
