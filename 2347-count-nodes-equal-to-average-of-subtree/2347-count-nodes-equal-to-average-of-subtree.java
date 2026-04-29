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
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int nodes = left[1] + right[1] + 1;
        int[] cur = { (left[0] + right[0] + root.val), nodes };

        if (cur[0] / nodes == root.val)
            count++;

        return cur;
    }
}