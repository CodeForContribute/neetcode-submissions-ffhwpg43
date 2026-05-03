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
    private ListNode merge(ListNode a, ListNode b){
        // if(a == null)return b;
        // if(b == null)return a;
        // ListNode node = null;
        // if(a.val <= b.val){
        //     cur = merge(a.next,b);
        //     cur = cur.next;
        // }else{
        //     cur = merge(a,b.next);
        //     cur = cur.next;
        // }
        // return cur;
        ListNode d = new ListNode(0);
        ListNode prev = d;
        while(a != null && b != null){
            if(a.val <= b.val){
                prev.next = a;
                a = a.next;
            }else{
                prev.next = b;
                b = b.next;
            }
            prev = prev.next;
        }
        if(a != null)prev.next = a;
        if(b != null)prev.next = b;
        return d.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        int n = lists.length;
        for(int i = 1; i < n; i++){
            lists[i] = merge(lists[i], lists[i-1]);
        }
        return lists[n-1];
    }
}
