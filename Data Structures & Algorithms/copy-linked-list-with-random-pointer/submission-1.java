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

        Node dummy = new Node(0);
        Node temp = head;
        Node copy = dummy;
        Map<Node,Node> mp = new HashMap<>();
        while(temp != null) {
            Node node = new Node(temp.val);
            mp.put(temp,node);
            temp = temp.next;
        }

        temp = head;

        while(temp != null) {
            Node node = mp.get(temp);
            if(temp.next != null) {
                node.next = mp.get(temp.next);
            }
            if(temp.random != null) {
                node.random = mp.get(temp.random);
            }
            copy.next = node;
            copy = copy.next;
            temp = temp.next;    
        }

        return dummy.next;
        
    }
}
