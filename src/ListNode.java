public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode t = this;
        do {
            builder.append(t.val);
            t = t.next;
            if (t != null) {
                builder.append(", ");
            }
        } while (t != null);

        return builder.toString();
    }
}