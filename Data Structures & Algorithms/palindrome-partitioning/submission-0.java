class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        solve(0, s);
        return res;
    }

    public void solve(int idx, String s) {

        if(idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = idx; i < s.length(); i++) {

            if(isPal(s, idx, i)) {

                path.add(s.substring(idx, i + 1));

                solve(i + 1, s);

                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPal(String s, int st, int end) {

        while(st <= end) {
            if(s.charAt(st) != s.charAt(end)) {
                return false;
            }
            st++;
            end--;
        }

        return true;
    }
}