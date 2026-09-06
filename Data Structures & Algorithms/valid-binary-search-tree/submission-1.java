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
    public boolean dfs(TreeNode node, long low , long up) {
        if(node == null) {
            return true;
        }
        if(node.val <= low || node.val >= up) {
            return false;
        }
        return dfs(node.left,low,node.val) && dfs(node.right,node.val,up);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);  
    }
}
