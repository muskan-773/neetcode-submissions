class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public void solve(int i, int[] nums, List<List<Integer>> ans, List<Integer> curr){

        ans.add(new ArrayList<>(curr));
        for(int j = i;j < nums.length;j++){
            if((j > i) && (nums[j] == nums[j-1])) continue;
            curr.add(nums[j]);
            solve(j+1,nums,ans, curr);
            curr.remove(curr.size()-1);
        } 
    }
}
