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
    
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) {
            return null;
        }

        ListNode res = new ListNode(0);
        ListNode temp = res;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1,n2) -> Integer.compare(n1.val,n2.val));
        for(int i=0;i<lists.length;i++) {
            if(lists[i] != null) {
                heap.offer(lists[i]);
            }
        }
        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
                temp.next = node;
                temp = temp.next;
                if(node.next != null) {
                    heap.offer(node.next);        
                }
        }

        return res.next;


    }
}
