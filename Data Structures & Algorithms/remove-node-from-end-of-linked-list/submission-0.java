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

        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        int size = 0;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        if(fast == null) {
            size = count*2;
        }
        else {
            size = count*2 + 1;
        }
        if(size == n) {
            return head.next;
        }
        count=0;
        ListNode temp = head;
        while(count < size-n-1) {
            temp=temp.next;
            count++;
        }
        temp.next = temp.next.next;
        return head;
    }
}
