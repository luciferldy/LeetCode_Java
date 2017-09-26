public class ListNodeUtils {

    public static ListNode generate(int[] num) {
        ListNode head = null, node = null;
        for (int i = 0; i < num.length; i++) {
            if (i == 0) {
                head = node = new ListNode(num[i]);
            }
            else {
                node.next = new ListNode(num[i]);
                node = node.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode node = head;
        StringBuilder b = new StringBuilder();
        while (node != null) {
            b.append(node.val);
            node = node.next;
            if (node != null) {
                b.append("->");
            }
        }

        System.out.println(b.toString());
    }
}
