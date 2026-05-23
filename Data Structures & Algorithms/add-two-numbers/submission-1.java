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
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int carry = 0;
        while(a != null || b != null){
            int aVal = a != null ? a.val:0;
            int bVal = b != null ? b.val:0;
            int sum = aVal + bVal + carry;
            int nodeVal = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(nodeVal);
            cur = cur.next;
            if(a != null)a = a.next;
            if(b != null)b = b.next;
        }
        if(carry > 0)cur.next = new ListNode(carry);
        return result.next;
        // if(a == null)return b;
        // if(b == null)return a;
        // int carry = 0;
        // ListNode head = null, cur = null;
        // while( a != null || b != null){

        //     int aVal = a == null ? 0 : a.val;
        //     int bVal = b == null ? 0 : b.val;
        //     int sum = aVal + bVal + carry;
        //     ListNode node = new ListNode(sum % 10);
        //     carry = sum / 10;
        //     if(head == null){
        //         head = node;
        //         cur = node;
        //     }else{
        //         cur.next = node;
        //         cur = cur.next;
        //     }
            

        //     if(a != null)a = a.next;
        //     if(b != null) b = b.next;
        // }
        // if(carry > 0){
        //     ListNode node = new ListNode(carry);
        //     cur.next = node;
        //     cur = cur.next;
        // }
        // return head;
        
    }
}
