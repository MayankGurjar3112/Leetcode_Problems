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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        int n = arr.size();

        for (int i : queries) {
            int index = Collections.binarySearch(arr, i);
            List<Integer> l = new ArrayList<>();

            if (index >= 0) {
                l.add(i);
                l.add(i);
            } else {
                index = (-index - 1);
                if (index == 0) {
                    l.add(-1);
                    l.add(arr.get(index));
                } else if (index == n) {
                    l.add(arr.get(index - 1));
                    l.add(-1);
                } else {
                    l.add(arr.get(index - 1));
                    l.add(arr.get(index));
                }
            }

            list.add(l);
        }

        return list;
    }

    private void inorder(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
}