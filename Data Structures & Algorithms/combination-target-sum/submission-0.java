class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(0, arr, tar, ans, new ArrayList<>());

        return ans;
    }

    public void solve(int i, int[] arr, int tar,
                      List<List<Integer>> ans,
                      List<Integer> curr) {

        if (i == arr.length) {
            if (tar == 0) {
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if (arr[i] <= tar) {
            curr.add(arr[i]);
            solve(i, arr, tar - arr[i], ans, curr);
            curr.remove(curr.size() - 1);
        }
        solve(i + 1, arr, tar, ans, curr);
    }
}