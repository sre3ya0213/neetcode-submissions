/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        Set<ListNode> nodes = new HashSet<>();
        ListNode temp = head;

        while(temp!= null && temp.next != null) {
            if(nodes.contains(temp.next)) {
                return true;
            }
            nodes.add(temp);
            temp = temp.next;
        }
        return false;
        
    }
}
