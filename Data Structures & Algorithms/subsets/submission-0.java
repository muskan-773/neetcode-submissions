class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans, new ArrayList<>());
        return ans;
    }
    private void solve(int i, int[] nums, List<List<Integer>> ans, List<Integer> curr){

        if(i >= nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[i]);
        solve(i + 1, nums, ans, curr);
        curr.remove(curr.size()-1);
        solve(i + 1, nums, ans, curr);
    }
}