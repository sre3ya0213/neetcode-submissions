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

        Node temp = head;
        HashMap<Node,Node> copy = new HashMap<>();
        Node dummy = new Node(0);
        Node copyList = dummy;

        while(temp != null) {
            copy.put(temp , new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            Node cur = copy.get(temp);
            cur.next = temp.next != null ? copy.get(temp.next) : null;
            cur.random = temp.random != null ? copy.get(temp.random) : null;
            temp = temp.next;
            copyList.next = cur;
            copyList = copyList.next;
        }

        return dummy.next;


        
    }
}
