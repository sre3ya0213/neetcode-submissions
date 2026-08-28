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
    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        if(root == null) {
            return root;
        }
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            swap(node);
            if(node.left != null) {
                nodes.offer(node.left);
            }
            if(node.right != null) {
                nodes.offer(node.right);
            }
        }

        return root;
        
    }
}
