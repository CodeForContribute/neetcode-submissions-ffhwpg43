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
    private int n;
    private ListNode rec(ListNode head){
        if(head == null)return null;
        head.next = rec(head.next);
        this.n--;
        if(this.n == 0){
            return head.next;
        }
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return null;
        this.n = n;
        return rec(head);
    }
}
