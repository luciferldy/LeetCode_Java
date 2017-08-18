import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution23_MergeKLists {


    public static void main(String[] args) {
        Solution23_MergeKLists s = new Solution23_MergeKLists();
        ListNode[] list = new ListNode[100];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ListNode(i);
        }

        long time = System.currentTimeMillis();
        ListNode res1 = s.mergeKLists(list);
        System.out.println("time: " + (System.currentTimeMillis()-time));
        System.out.println(res1);

        time = System.currentTimeMillis();
        ListNode res2 = s.mergeKLists2(list);
        System.out.println("time: " + (System.currentTimeMillis()-time));
        System.out.println(res2);
    }

    // fuck the time limited!!!
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 || isEmpty(lists)) {
            return null;
        }

        ArrayList<ListNode> tmp = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                tmp.add(lists[i]);
            }
        }
        int min;
        int minNode = 0;
        ListNode head = null, c = null;
        boolean stop;
        while (true) {
            stop = true;
            min = Integer.MAX_VALUE;
            // 筛选出数字
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i) != null && tmp.get(i).val <= min) {
                    min = tmp.get(i).val;
                    minNode = i;
                    stop = false;
                }
            }

            if (stop) {
                break;
            }

            // 进行赋值操作
            if (head == null) {
                head = new ListNode(min);
                c = head;
            } else {
                // 拼接 ListNode
                c.next = new ListNode(min);
                c = c.next;
            }

            if (tmp.get(minNode).next == null) {
                tmp.remove(minNode);
            } else {
                tmp.set(minNode, tmp.get(minNode).next);
            }

        }
        return head;
    }

    // another easy solution
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0 || isEmpty(lists)) {
            return null;
        }

        int count = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node!=null) {
                count++;
                node = node.next;
            }
        }

        int[] number = new int[count];
        int c = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node!=null) {
                number[c++] = node.val;
                node = node.next;
            }
        }

        Arrays.sort(number);

        ListNode head = null;
        ListNode n = null;
        for (int i = 0; i < number.length; i++) {
            if (head == null) {
                head = new ListNode(number[i]);
                n = head;
            } else {
                n.next = new ListNode(number[i]);
                n= n.next;
            }
        }
        return head;

    }

    private boolean isEmpty(ListNode[] list) {
        for (ListNode node : list) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }


}
