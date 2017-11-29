import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution107_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<TreeNode> t = new ArrayList<>();
        List<List<Integer>> r = new ArrayList<>();
        int count = 0;
        t.add(root);
        while (count < t.size()) {
            List<Integer> k = new ArrayList<>();
            int len = t.size();
            for (int i = count; i < len; i++) {
                TreeNode n = t.get(i);
                k.add(n.val);
                count++;
                if (n.left != null) {
                    t.add(n.left);
                }
                if (n.right != null) {
                    t.add(n.right);
                }
            }
            r.add(0, k);
        }

        return r;
    }
}
