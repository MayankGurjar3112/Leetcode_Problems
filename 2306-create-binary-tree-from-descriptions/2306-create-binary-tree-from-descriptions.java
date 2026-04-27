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
    int[] arr = new int[100001];
    TreeNode[] nodes = new TreeNode[100001];

    public TreeNode createBinaryTree(int[][] descriptions) {
        for (int[] i : descriptions) {
            if (nodes[i[0]] == null) {
                nodes[i[0]] = new TreeNode(i[0]);
                arr[i[0]] = -1;
            }
            if (nodes[i[1]] == null) {
                nodes[i[1]] = new TreeNode(i[1]);
            }
            if (i[2] == 1) 
                nodes[i[0]].left = nodes[i[1]];
            else
                nodes[i[0]].right = nodes[i[1]];

            arr[i[1]] = i[0];
        }

        for (int i = 0; i < 100001; i++) 
            if (arr[i] == -1)
                return nodes[i];
        
        return null;
    }
}