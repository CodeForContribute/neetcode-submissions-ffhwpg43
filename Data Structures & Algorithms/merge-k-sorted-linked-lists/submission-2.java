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
        if(lists == null)return null;
        PriorityQueue<ListNode>pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode head : lists){
            if(head != null){
                pq.offer(head);
            }
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            node = node.next;
            if(node != null)pq.add(node);
        }
        return result.next;
    }
}
