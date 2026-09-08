/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] dm = new int[1];
        height(root, dm);
        return dm[0];
    }
    public int height(TreeNode root, int[] dm) {

        if (root == null) return 0;

        int lh = height(root.left, dm);
        int rh = height(root.right, dm);

        dm[0] = Math.max(dm[0], lh + rh);
        return 1 + Math.max(lh,rh);
    }
}
