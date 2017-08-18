public class Solution21_MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        Solution21_MergeTwoLists s = new Solution21_MergeTwoLists();
        ListNode head = s.mergeTwoLists(l1, l2);
        System.out.println(head);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tmp = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (head == null) {
                    head = l2;
                } else {
                    tmp.next = l2;
                }
                break;
            }

            if (l2 == null) {
                if (head == null) {
                    head = l1;
                } else {
                    tmp.next = l1;
                }
                break;
            }

            if (l1.val < l2.val) {
                if (head == null) {
                    head = new ListNode(l1.val);
                    tmp = head;
                    l1 = l1.next;
                    continue;
                }

                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = new ListNode(l2.val);
                    tmp = head;
                    l2 = l2.next;
                    continue;
                }

                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = l2.next;
            }
        }

        return head;
    }
}
