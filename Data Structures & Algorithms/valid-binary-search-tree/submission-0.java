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
    public void dfs(TreeNode node, List<Integer> ls) {
        if(node == null) {
            return;
        }
        dfs(node.left,ls);
        ls.add(node.val);
        dfs(node.right,ls);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        List<Integer> validTree = new ArrayList<>();
        dfs(root,validTree);
        for(int i=0;i<validTree.size()-1;i++) {
            if(validTree.get(i) >= validTree.get(i+1)) {
                return false;
            }
        }
        return true;    
    }
}
