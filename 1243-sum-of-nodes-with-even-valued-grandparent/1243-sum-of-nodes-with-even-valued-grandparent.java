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

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;

        if (root.val % 2 == 0)
            sumGrandKids(root);

        dfs(root.left);
        dfs(root.right);
    }

    private void sumGrandKids(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left != null) {
            sum += left.left == null ? 0 : left.left.val; 
            sum += left.right == null ? 0 : left.right.val; 
        }

        if (right != null) {
            sum += right.left == null ? 0 : right.left.val; 
            sum += right.right == null ? 0 : right.right.val; 
        }
    }
}