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

    Boolean balanced = true;
    public int height(TreeNode node) {
        if(node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if(Math.abs(leftHeight-rightHeight) > 1) {
            balanced = false;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;   
    }
}
