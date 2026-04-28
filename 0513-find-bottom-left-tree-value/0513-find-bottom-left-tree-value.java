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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode Null = new TreeNode();

        q.add(root);
        q.add(Null);

        int value = root.val;

        while (!q.isEmpty()) {
            TreeNode cur = q.remove();

            if (cur == Null) {
                if (q.isEmpty())
                    break;
                else 
                    value = q.peek().val;
                q.add(Null);
            } else {
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }

        return value;

    }
}