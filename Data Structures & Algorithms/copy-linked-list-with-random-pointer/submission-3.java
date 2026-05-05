/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    private static final Map<Node,Node>mp = new HashMap();
    private Node getNode(Node node){
        return node == null ? null : mp.computeIfAbsent(node, k->new Node(node.val));
    }
    public Node copyRandomList(Node head) {
        // one pass
        if(head == null)return head;
        Node cur = head;
        while(cur != null){
            // check if cur is created 
            Node copy = getNode(cur);
            copy.next = getNode(cur.next);
            copy.random = getNode(cur.random);
            cur = cur.next;
        }
        return getNode(head);
    }
}
