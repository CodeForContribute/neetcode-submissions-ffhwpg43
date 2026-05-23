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
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        if(a == null)return b;
        if(b == null)return a;
        ListNode result = new ListNode(0),cur = result;
        int carry = 0;
        while(a != null || b != null){
            int aVal = a != null ? a.val:0;
            int bVal = b != null ? b.val:0;
            int sum = aVal + bVal + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(a != null)a = a.next;
            if(b != null)b = b.next;
        }
        if(carry > 0)cur.next = new ListNode(carry);
        return result.next;
        
    }
}
