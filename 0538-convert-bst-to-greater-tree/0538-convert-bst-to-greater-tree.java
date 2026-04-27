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
    public TreeNode convertBST(TreeNode root) {
        traverse(root, 0);
        return root;
    }

    private int traverse(TreeNode root, int n) {
        if (root == null)
            return 0;
        root.val += traverse(root.right, n) + n;
        return root.val + traverse(root.left, root.val) - n;
    }
}