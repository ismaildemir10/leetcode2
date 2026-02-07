package leetcode2;

public class ReverseLinkedList2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode next = null;
        ListNode prevSub = null;

        for (int i = 0; i <= right - left; i++) {
            next = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = next;
        }
        prev.next.next = curr;
        prev.next = prevSub;
        return dummy.next;
    }
}
