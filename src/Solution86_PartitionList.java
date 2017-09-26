public class Solution86_PartitionList {

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.generate(new int[]{1, 4, 3, 2, 5, 2});
        ListNodeUtils.printList(head);
        head = partition(head, 3);
        ListNodeUtils.printList(head);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode shead = null, snode = null, ghead = null, gnode = null;

        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                if (shead == null) {
                    shead = node;
                    snode = shead;
                } else {
                    snode.next = node;
                    snode = snode.next;
                }

            } else {
                if (ghead == null) {
                    ghead = node;
                    gnode = ghead;
                } else {
                    gnode.next = node;
                    gnode = gnode.next;
                }
            }
            node = node.next;
        }

        if (shead == null) {
            return ghead;
        }

        if (ghead != null) {
            snode.next = ghead;
            gnode.next = null;
        }

        return shead;
    }


}
