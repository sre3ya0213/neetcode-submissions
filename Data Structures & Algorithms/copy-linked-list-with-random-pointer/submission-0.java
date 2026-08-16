/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node,Node> map = new HashMap<>();

        Node temp = head;
        Node copy = new Node(0);
        Node cur = copy;

        while(temp != null) {
            Node p = new Node(temp.val);
            map.put(temp,p);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            Node p = map.get(temp);
            Node q = temp.next == null ? null : map.get(temp.next);
            Node r = temp.random == null ? null : map.get(temp.random);
            cur.next = p;
            p.next = q;
            p.random = r;
            cur = cur.next;  
            temp = temp.next; 
        }
        return copy.next;    
    }
}
