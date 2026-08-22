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
    public ListNode reverseLL(ListNode list) {
       
        ListNode temp1 = null;
        ListNode temp2 = list;

        while(temp2 != null) {
            ListNode temp = temp2.next;
            temp2.next = temp1;
            temp1=temp2;
            temp2=temp;
        }

        return temp1;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode start = head;
        ListNode end = head;
        ListNode res = new ListNode(0);
        ListNode node = res;

        while(end != null) {
            int count=1;
            while(count != k && end != null) {
                end = end.next;
                count++;
            }
            if(end != null) {
                ListNode temp = end.next;
                end.next = null;
                ListNode group = reverseLL(start);
                node.next = group;
                node = start;
                start = temp;
                end = temp;
            }
            else {
                node.next = start;
            }   
        }
        return res.next;
        
    }
}
