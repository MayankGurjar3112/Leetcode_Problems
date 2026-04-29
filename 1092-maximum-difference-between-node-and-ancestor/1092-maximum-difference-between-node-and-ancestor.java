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
    int max = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return max;    
    }

    private int[] dfs(TreeNode root) {
        if (root == null) 
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int[] c = { Math.min(root.val, Math.min(l[0], r[0])), Math.max(root.val, Math.max(l[1], r[1])) };

        if (root.left != null || root.right != null) {
            max = Math.max(Math.abs(root.val - Math.min(l[0], r[0])), max);
            max = Math.max(Math.abs(root.val - Math.max(l[1], r[1])), max);
        }

        return c;
    }
}