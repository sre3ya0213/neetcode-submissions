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
    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        int depth = 0;
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            int levelSize = nodes.size();
            for(int i=0;i<levelSize;i++) {
                TreeNode node = nodes.poll();
                if(node.left != null) {
                    nodes.offer(node.left);
                }
                if(node.right != null) {
                    nodes.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
