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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        List<Integer> arr3 = new ArrayList<>();

        inorder(root1, arr1);
        inorder(root2, arr2);

        int i = 0, j = 0;
        for (i = 0, j = 0; i < arr1.size() && j < arr2.size();) {
            int a = arr1.get(i);
            int b = arr2.get(j);
            
            if (a <= b) {
                arr3.add(a);
                i++;
            } else {
                arr3.add(b);
                j++;
            }
        }

        while (i < arr1.size()) 
            arr3.add(arr1.get(i++));
        
        while (j < arr2.size()) 
            arr3.add(arr2.get(j++));

        return arr3;
    }

    private void inorder(TreeNode root, List<Integer> arr) {
        if (root == null)
            return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
}