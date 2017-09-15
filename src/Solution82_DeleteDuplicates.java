import java.util.List;

public class Solution82_DeleteDuplicates {

    public static void main(String[] args) {
        ListNode head = generate(new int[]{1, 2, 2});
        printListNode(head);
        ListNode h1 = deleteDuplicates(head);
        printListNode(h1);

    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode h1 = null;
        ListNode n1 = head;
        ListNode n2 = null;
        int count;
        while (n1 != null) {

            count = 1;
            while (n1.next != null
                    && n1.next.val == n1.val) {
                count++;
                n1 = n1.next;
            }

            if (count == 1) {
                if (h1 == null) {
                    h1 = n1;
                    n2 = n1;
                } else {
                    n2.next = n1;
                    n2 = n2.next;
                }

            }
            n1 = n1.next;
        }
        if (n2 != null)
            n2.next = null;
        return h1;
    }

    private static ListNode generate(int[] num) {
        ListNode h = new ListNode(num[0]);
        ListNode n = h;
        for (int i = 1; i < num.length; i++) {
            n.next = new ListNode(num[i]);
            n = n.next;
        }
        return h;
    }

    private static void printListNode(ListNode head) {
        ListNode n = head;
        StringBuilder b = new StringBuilder();
        while (n != null) {
            b.append(n.val);
            n = n.next;
            if (n != null)
                b.append("->");
        }
        System.out.println(b.toString());
    }

}
