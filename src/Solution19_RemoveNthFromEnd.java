
public class Solution19_RemoveNthFromEnd {

    public static void main(String[] args) {

        Solution19_RemoveNthFromEnd s = new Solution19_RemoveNthFromEnd();
        ListNode head = s.generate(new int[]{1, 2});
        ListNode res = s.removeNthFromEnd(head, 1);
        System.out.println(res);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            System.out.println("null");
            return head;
        }

        // 两个指针a，b，相距 n，当 a 走到最后一位时，b 走到倒数第 n 位，只是想想
        int a = 0;
        ListNode tmp = head;
        while (tmp != null) {
            a++;
            tmp = tmp.next;
        }
        // 获得了 list 的长度

        System.out.println("a=" + a);

        if (a-n < 0) {
            return head;
        }
        // 删除第一个节点
        if (a-n == 0) {
            head = head.next;
            return head;
        }

        // 找到待删除节点的前一个节点
        tmp = head;
        for (int i = 0; i < a-n-1; i++) {
            tmp = tmp.next;
        }

        System.out.println("tmp.value=" + tmp.val);

        ListNode delete = tmp.next;
        tmp.next = delete.next;
        return head;

    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }

        ListNode tmp = head;
        ListNode prev = head;
        int c = 0;
        while (tmp != null) {
            tmp = tmp.next;
            c++;
            if (c>n+1) {
                prev = prev.next;
            }
        }

        if (n > c) {
            return head;
        }
        // 否则节点可以被删掉
        if (n == c) {
            head = head.next;
            return head;
        }
        //
        ListNode delete = prev.next;
        prev.next = delete.next;
        return head;
    }

    public ListNode generate(int[] arg) {
        ListNode head = new ListNode(arg[0]);
        ListNode tmp = head;
        for (int i = 1; i < arg.length; i++) {
            tmp.next = new ListNode(arg[i]);
            tmp = tmp.next;
        }
        return head;
    }
}
