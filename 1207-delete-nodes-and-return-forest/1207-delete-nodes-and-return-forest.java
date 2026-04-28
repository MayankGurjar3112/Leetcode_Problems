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
    List<TreeNode> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        root = new TreeNode(0, root, null);
        root = new TreeNode(-1, root, null);
        for (int i : to_delete)
            set.add(i);
        set.add(0);
        dfs(root.left, root);
        return list;
    }

    private void dfs(TreeNode root, TreeNode par) {
        if (root == null)
            return;

        if (set.contains(root.val)) {
            if (par.left != null && par.left == root)
                par.left = null;
            else
                par.right = null;

            if (root.left != null && !set.contains(root.left.val))
                list.add(root.left);
            if (root.right != null && !set.contains(root.right.val))
                list.add(root.right);
        }

        dfs(root.left, root);
        dfs(root.right, root);
    }
}