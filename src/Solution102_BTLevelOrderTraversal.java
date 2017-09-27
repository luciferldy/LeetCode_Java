import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution102_BTLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList();

        List<TreeNode> nodes = new ArrayList();
        nodes.add(root);
        List<List<Integer>> result = new LinkedList();
        int offset = 0;
        while (true) {
            int len = nodes.size();
            List<Integer> t = new LinkedList();
            for (int i = offset; i < len; i++) {
                t.add(nodes.get(i).val);
                offset++;
                if (nodes.get(i).left != null) {
                    nodes.add(nodes.get(i).left);
                }
                if (nodes.get(i).right != null) {
                    nodes.add(nodes.get(i).right);
                }
            }

            result.add(t);

            if (offset == nodes.size())
                break;

        }

        return result;
    }
}
