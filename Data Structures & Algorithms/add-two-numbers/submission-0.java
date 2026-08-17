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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sum = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        ListNode temp = sum;

        while(temp1 != null || temp2 != null) {
            int add = (temp1 != null ? temp1.val : 0) + (temp2 != null ? temp2.val : 0) + carry;
            if( add >= 10) {
                temp.next = new ListNode(add-10);
                carry = 1;
            }
            else {
                temp.next = new ListNode(add);
                carry = 0;
            }
            temp = temp.next;
            if(temp1 != null) {
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                temp2 = temp2.next;
            }
        }

        if(carry == 1) {
            temp.next = new ListNode(1);
        }

        return sum.next;
        
        
    }
}
