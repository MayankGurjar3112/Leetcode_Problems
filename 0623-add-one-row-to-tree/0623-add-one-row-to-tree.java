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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        depth--;
        depth--;

        if (depth == -1)
            return root = new TreeNode(val, root, null);

        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode Null = new TreeNode(1000);

        q.add(root);
        q.add(Null);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();

            if (cur == Null) {
                depth--;
                if (depth == -1)
                    break;
                q.add(Null);
            } else {
                if (depth == 0) {
                    cur.left = new TreeNode(val, cur.left, null);
                    cur.right = new TreeNode(val, null, cur.right);
                }
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }

        return root;
    }
}