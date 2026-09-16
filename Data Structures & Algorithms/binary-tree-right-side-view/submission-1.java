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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        dfs(root,res,0);
        return res;
    }


    public void dfs(TreeNode node , List<Integer> res, int depth) {

        if(node == null) {
            return;
        }
        if(depth == res.size()) {
            res.add(node.val);
        }
        dfs(node.right,res,depth+1);
        dfs(node.left,res,depth+1);

    }
}
