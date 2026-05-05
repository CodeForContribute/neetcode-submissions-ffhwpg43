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
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Node original = head;

        // setup the next nodes for new list.
        while(original != null){
            Node cloned = new Node(original.val);
            cloned.next = original.next;
            original.next = cloned;
            original = cloned.next;
        }

        Node newHead = head.next;
        // setup the random nodes for new list
        original = head;
        while(original != null){
            if(original.random != null){
                original.next.random = original.random.next;
            }
            original = original.next.next;
        }
        // untangling
        original = head;
        while(original != null){
            Node cloned = original.next;
            original.next = cloned.next;
            if(cloned.next != null){
                cloned.next = cloned.next.next;
            }
            original = original.next;
        }
        return newHead;
    }
}
