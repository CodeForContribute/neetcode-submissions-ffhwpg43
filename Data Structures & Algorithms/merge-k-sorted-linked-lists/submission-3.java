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
    private ListNode divide(ListNode[]lists, int left, int right){
        // base case
        if(left > right)return null;
        if(left == right)return lists[left];
        int mid = left + (right - left)/2;
        ListNode leftSide = divide(lists,left,mid);
        ListNode rightSide = divide(lists,mid+1,right);
        return merge(leftSide, rightSide);
    }

    private ListNode merge(ListNode a, ListNode b){
        ListNode d = new ListNode(0);
        ListNode cur = d;
        while(a != null && b != null){
            if(a.val <= b.val){
                cur.next = a;
                a = a.next;
            }else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if(a != null)cur.next = a;
        if(b != null)cur.next = b;
        return d.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        return divide(lists, 0, lists.length-1);
    }
}
