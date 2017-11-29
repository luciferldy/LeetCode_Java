import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution109_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }

        return generate(list, 0, list.size()-1);
    }

    public TreeNode generate(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = generate(list, start, mid-1);
        root.right = generate(list, mid+1, end);
        return root;
    }
}
