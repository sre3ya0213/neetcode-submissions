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

    public void dfs(TreeNode root, int k, int[] res) {

        if(root == null || res[0] == k) {
            return;
        }
        dfs(root.left,k,res);
        res[0]++;
        if(res[0] == k) {
            res[1] = root.val;
        }
        dfs(root.right,k,res);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];
        res[0] = 0;
        dfs(root,k,res);
        return res[1];
       
    }

}
