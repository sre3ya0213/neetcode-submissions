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
    // StringBuilder res = new StringBuilder();
    public String serialize(TreeNode root) {
        if(root == null) {
            return "N";
        }
        return root.val + "," + serialize(root.left) +  "," + serialize(root.right);  
    }

    // Decodes your encoded data to tree.
    int idx=0;
    public TreeNode insert(String[] values) {
        if(values[idx].equals("N")) {
            idx++;
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(values[idx]));
        idx++;
        cur.left = insert(values);
        cur.right = insert(values);
        return cur;
    }
    public TreeNode deserialize(String data) {
        if(data.equals("N")) {
            return null;
        }
        String[] values = data.split(",");
        return insert(values); 
    }
}
