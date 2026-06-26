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
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next !=null){
            slow = slow.next ;
            fast = fast.next.next;
        }// we will get the middle element from this and 
        //slow will be the middle element

        ListNode second = slow.next ; // 1->2->3->4->5  secondHalf = 4
        slow.next = null ;// 1->2->3->null
        ListNode prev = slow.next ; //prev = null // cut the linked list into two separate halves.
        while(second != null){
            ListNode temp = second.next;
            second.next = prev ; 
            prev = second ;
            second = temp ;
        }// we reversed the ll

        ListNode first = head ;
        second = prev;
        while(second != null){
            ListNode temp1 = first.next ;
            ListNode temp2 = second.next;
            first.next = second ;
            second.next = temp1 ;
            first = temp1;
            second = temp2;
        }// alternating the ll to get final ll
    }
}
