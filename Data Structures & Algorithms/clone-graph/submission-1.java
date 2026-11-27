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
    public Node cloneGraph(Node node) {
        Map<Node,Node> copyMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        if(node == null) {
            return null;
        }
        Node clone = new Node(node.val);
        queue.offer(node);
        copyMap.put(node,clone);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            Node copy = copyMap.get(temp);
            for(int i=0;i<temp.neighbors.size();i++) {
                Node neighbor = temp.neighbors.get(i);
                if(copyMap.containsKey(neighbor)) {
                    copy.neighbors.add(copyMap.get(neighbor));
                }
                else {
                    Node copyNeighbor = new Node(neighbor.val);
                    copyMap.put(neighbor,copyNeighbor);
                    copy.neighbors.add(copyNeighbor);
                    queue.offer(neighbor);
                } 
            }
        }
        return clone;
        
    }
}