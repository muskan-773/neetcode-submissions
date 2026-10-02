class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public void solve(int idx, int[] nums,List<List<Integer>> ans, List<Integer> curr){

        if (idx == nums.length) {
            for (int num : nums) {
                curr.add(num);
            }

            ans.add(new ArrayList<>(curr));
            curr.clear();
        }
           
        for(int i = idx;i < nums.length;i++){

            //swap i -> idx
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            solve(idx + 1, nums, ans, curr);

            //backtrack
            temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
    }
}