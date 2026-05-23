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
        ListNode result = new ListNode(0),cur = result;
        while(a!= null && b != null){
            if(a.val <= b.val){
                cur.next = new ListNode(a.val);
                a = a.next;
            }else{
                cur.next = new ListNode(b.val);
                b = b.next;
            }
            cur = cur.next;
        }
        if(a != null)cur.next = a;
        if(b != null)cur.next = b;
        return result.next;
    }
}