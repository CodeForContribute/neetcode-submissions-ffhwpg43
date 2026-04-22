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
        // reverse and merge
        if(head == null)return;
        // find middle and break into 2 
        // reverse the second part
        // merge 2 lists - first half and reversed second half.
        // 1. finding the middle.
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse the second part
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while(second != null){
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        // 3. merge the 2 parts 
        ListNode first = head;
        second = prev;
        while(second != null){
            ListNode a = first.next;
            ListNode b = second.next;
            first.next = second;
            second.next = a;
            first = a;
            second = b;
        }
    }
}
