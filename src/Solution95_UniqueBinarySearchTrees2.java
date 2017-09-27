import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95_UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i-1);
            right = genTrees(i+1, end);

            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode parent = new TreeNode(i);
                    parent.left = l;
                    parent.right = r;
                    list.add(parent);
                }
            }
        }

        return list;
    }
}
