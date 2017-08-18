public class Solution25_ReverseKGroup {

    public static void main(String[] args) {

        Solution25_ReverseKGroup s = new Solution25_ReverseKGroup();
        ListNode head = new ListNode(0);
        ListNode t = head;
        for (int i = 1; i < 10; i++) {
            t.next = new ListNode(i);
            t = t.next;
        }
        ListNode res = s.reverseKGroup(head, 4);
        System.out.println(res);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 1) {
            return head;
        }
        ListNode p = head, prev = head;
        int c1 = 0;
        int[] c2 = new int[k];
        while (p != null) {
            c2[c1++] = p.val;
            if (c1 == k) {
                // 如果走过 k 步，那么 reverse
                for (int i = k-1; i >= 0; i--) {
                    prev.val = c2[i];
                    prev = prev.next;
                }

                c1 = 0;
                p = p.next;
                prev = p;
                continue;
            }
            p = p.next;
        }

        return head;
    }
}
