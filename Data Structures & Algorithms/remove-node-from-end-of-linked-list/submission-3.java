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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = null;
        ListNode fast = head;
        for(int i=0;i<n-1;i++) {
            fast = fast.next;
        }
        while(fast != null && fast.next != null) {
            if(slow == null) {
                slow = head;
            }
            else {
                 slow = slow.next;
            }
            fast = fast.next;
        }
        if(slow == null) {
            return head.next;
        }
        slow.next = slow.next.next;
        
        return head;
    }
}
