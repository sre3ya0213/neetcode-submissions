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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       
        Queue<TreeNode> nodes = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        if(root == null) {
            return res.toString();
        }
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if(node != null) {
                res=res.append(node.val).append(",");
                nodes.offer(node.left);
                nodes.offer(node.right);
            }
            else {
                res = res.append("N,");
            }
        }
        return res.toString();             
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<TreeNode> nodes = new LinkedList<>();
        if(data.isEmpty()){
            return null;
        }
        String[] nodeValues = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[0]));
        nodes.offer(root);
        int i=1;
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if(!nodeValues[i].equals("N")) { 
                node.left = new TreeNode(Integer.parseInt(nodeValues[i]));
                nodes.offer(node.left);
            }
            if(!nodeValues[i+1].equals("N")){
                node.right = new TreeNode(Integer.parseInt(nodeValues[i+1]));
                nodes.offer(node.right);
            }
            i = i + 2;        
        }
            return root;
        } 

}
