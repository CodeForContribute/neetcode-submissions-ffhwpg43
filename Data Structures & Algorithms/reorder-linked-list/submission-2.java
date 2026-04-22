class Solution {
    
    private ListNode temp;
    private boolean isStop;

    public void reorderList(ListNode head) {
        temp = head;
        isStop = false;
        reorder(head);
    }

    private void reorder(ListNode head) {
        if (head == null) return;
        reorder(head.next);

        if (!isStop) {
            ListNode next = temp.next;
            temp.next = head;
            head.next = next;
            temp = next;
        }

        if (temp != null && temp.next == head) {
            temp.next = null;
            isStop = true;
        }
    }
}