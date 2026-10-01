class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int tar) {

        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, arr, tar, ans, new ArrayList<>());

        return ans;
    }

    public void solve(int i, int[] arr, int tar,
                      List<List<Integer>> ans,
                      List<Integer> curr) {

        if (tar == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (i == arr.length || tar < 0) {
            return;
        }

        for (int j = i; j < arr.length; j++) {

            // Skip duplicate choices at the same level
            if (j > i && arr[j] == arr[j - 1]) {
                continue;
            }

            // Array is sorted
            if (arr[j] > tar) {
                break;
            }

            curr.add(arr[j]);

            // Move to j + 1 because every element can be used only once
            solve(j + 1, arr, tar - arr[j], ans, curr);

            curr.remove(curr.size() - 1);
        }
    }
}