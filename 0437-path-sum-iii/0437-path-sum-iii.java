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
    private int count = 0;
    private int target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        dfs(root, 0, false);
        return count;
    }

    private void dfs(TreeNode root, long sum, boolean skipped) {
        if (root == null)
            return;
        if (sum + root.val == target)
            count++;

        if (root.left != null) {
            if (!skipped)
                dfs(root.left, 0, true);
            dfs(root.left, sum + root.val, skipped);
        }

        if (root.right != null) {
            if (!skipped)
                dfs(root.right, 0, true);
            dfs(root.right, sum + root.val, skipped);
        }
    }
}