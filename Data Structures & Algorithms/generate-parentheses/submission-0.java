class Solution {

    public void solve(String op, int open, int close, List<String> ans) {

        if (open == 0 && close == 0) {
            ans.add(op);
            return;
        }

        // when count of open and close brackets are same
        // then we have only one choice to put open bracket
        if (open == close) {

            String op1 = op;
            op1 = op1 + "(";

            solve(op1, open - 1, close, ans);
        }

        else if (open == 0) {

            // only choice is to put close brackets
            String op1 = op;
            op1 = op1 + ")";

            solve(op1, open, close - 1, ans);
        }

        else if (close == 0) {

            // only choice is to use open bracket
            String op1 = op;
            op1 = op1 + "(";

            solve(op1, open - 1, close, ans);
        }

        else {

            String op1 = op;
            String op2 = op;

            op1 = op1 + "(";
            op2 = op2 + ")";

            solve(op1, open - 1, close, ans);
            solve(op2, open, close - 1, ans);
        }
    }

    public List<String> generateParenthesis(int n) {

        int open = n;
        int close = n;

        List<String> ans = new ArrayList<>();

        String op = "";

        solve(op, open, close, ans);

        return ans;
    }
}