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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null)return b;
        if(b == null)return a;
        ListNode result = null;
        if(a.val <= b.val){
            result = a;
            result.next =  mergeTwoLists(a.next, b);
        }else {
            result = b;
            result.next = mergeTwoLists(a,b.next);
        }
        return result;
    }
}