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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, 1);
        return sum;
    }

    private void dfs(TreeNode root, int side) {
        if (root == null)
            return;
        if (side == 0 && root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        dfs(root.left, 0);
        dfs(root.right, 1);
    }
}