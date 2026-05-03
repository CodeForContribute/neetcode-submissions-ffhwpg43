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
        // 1. merge all the linked lists to ignore the list structure.
        // collect every value sort them and then rebuild a single linked list.
        if(lists == null)return null;
        List<Integer>nodes = new ArrayList();
        for(ListNode list: lists){
            while(list != null){
                nodes.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(nodes);
        ListNode result = new ListNode(0);
        ListNode cur = result;
        for(int node: nodes){
            cur.next = new ListNode(node);
            cur = cur.next;
        }
        return result.next;
    }
}
