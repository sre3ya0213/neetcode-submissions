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
     
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) 
        {
            return res;
        }
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            int levelSize = nodes.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<levelSize;i++) {
                TreeNode node = nodes.poll();
                if(node.left != null) {
                    nodes.offer(node.left);
                }
                if(node.right != null) {
                    nodes.offer(node.right);
                }
                level.add(node.val);
            }
            res.add(level);
        }
        return res;
    }
}
