/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node dfs(Node node,Map<Node,Node> copyMap) {
        if(node == null) {
            return null;
        }
        if(copyMap.containsKey(node)) {
            return copyMap.get(node);
        }
        Node clone = new Node(node.val);
        copyMap.put(node,clone);
        for(int i=0;i<node.neighbors.size();i++) {
            clone.neighbors.add(dfs(node.neighbors.get(i),copyMap));
        }
        return clone;
    }
    public Node cloneGraph(Node node) {
        Map<Node,Node> copyMap = new HashMap<>();        
        return dfs(node,copyMap);
    }
}