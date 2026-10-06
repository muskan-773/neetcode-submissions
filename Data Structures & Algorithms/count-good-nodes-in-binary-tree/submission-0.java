class Solution {
    class Pair {
        TreeNode node;
        int max;

        Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }

    public int goodNodes(TreeNode root) {

        if (root == null) return 0;

        int count = 1;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, root.val));

        while (!q.isEmpty()) {

            Pair p = q.poll();

            TreeNode curr = p.node;
            int max = p.max;

            if (curr.left != null) {

                if (curr.left.val >= max) {
                    count++;
                }

                q.add(new Pair(
                    curr.left,
                    Math.max(max, curr.left.val)
                ));
            }

            if (curr.right != null) {

                if (curr.right.val >= max) {
                    count++;
                }

                q.add(new Pair(
                    curr.right,
                    Math.max(max, curr.right.val)
                ));
            }
        }

        return count;
    }
}