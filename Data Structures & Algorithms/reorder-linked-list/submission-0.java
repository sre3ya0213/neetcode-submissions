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
    public void reorderList(ListNode head) {

        if(head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode follow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null) {
            follow=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        follow.next = null;

        ListNode p = null;
        ListNode q = slow;

        while(q != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        ListNode l = head;
        int i=1;
        while( l != null && p!=null) {
            if(i%2 == 1) {
                ListNode node = l.next;
                l.next = p;
                l = node;
            }
            else {
                ListNode node = p.next;
                p.next = l;
                p = node;
            }
            i++;
        }
           
    }
}
