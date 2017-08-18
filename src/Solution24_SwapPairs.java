public class Solution24_SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;

        while (p != null && p.next != null) {
            int t = p.val;
            p.val = p.next.val;
            p.next.val = t;

            p = p.next.next;
        }

        return head;
    }
}
