import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution103_BTZigzagLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if (root == null)
            return result;

        List<TreeNode> t = new LinkedList<>();
        int offset = 0;
        t.add(root);
        boolean toRight = true;
        while (offset < t.size()) {
            int n = t.size();
            List<Integer> c = new LinkedList<>();
            int p = offset;
            for (int i = p; i < n; i++) {
                if (toRight) {
                    c.add(t.get(i).val);
                } else {
                    c.add(t.get(n-1+p-i).val);
                }
                offset++;
                if (t.get(i).left != null) {
                    t.add(t.get(i).left);
                }
                if (t.get(i).right != null) {
                    t.add(t.get(i).right);
                }
            }

            toRight = !toRight;
            result.add(c);
        }

        return result;
    }
}
