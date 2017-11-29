import org.jetbrains.annotations.NotNull;
import sun.rmi.runtime.Log;
import utils.TreeNode;

import java.lang.ref.SoftReference;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Solution114_Flatten {

    TreeNode result, walk;

    /**
     * 这种解法现在存在问题
     */

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        result = null;
        traversal(root);
        root = result;
    }

    private void traversal(TreeNode root) {
        if (root == null)
            return;

        if (result == null) {
            result = new TreeNode(root.val);
            walk = result;
        } else {
            walk.right = new TreeNode(root.val);
            walk = walk.right;
        }
        traversal(root.left);
        traversal(root.right);

    }

    public static void main(String[] args) {
//        TreeNode r1 = new TreeNode(1);
//        r1.left = new TreeNode(2);
//        r1.right = new TreeNode(5);
//        TreeNode r2 = r1.left;
//        r2.left = new TreeNode(3);
//        r2.right = new TreeNode(4);
//        TreeNode r5 = r1.right;
//        r5.right = new TreeNode(6);
//
//        printTree(r1);
//        Solution114_Flatten s = new Solution114_Flatten();
//        s.flatten(r1);
//        printTree(r1);
        TreeNode root = new TreeNode(1);
        System.out.println(root.val);
        Solution114_Flatten s = new Solution114_Flatten();
        System.out.println(root.val);
    }

    private static void printTree(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        int start = 0;
        TreeNode tmp;
        queue.add(root);
        StringBuilder oout = new StringBuilder();
        while (true) {
            int tmpSize = queue.size();
            for (int i = start; i < tmpSize; i++) {
                tmp = queue.get(i);
                oout.append(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                } else {
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                } else {
                }
            }
            if (queue.size() == tmpSize)
                break;
            start = tmpSize;
        }

//        StringBuilder out = new StringBuilder();
//        for (int i = 0; i < queue.size(); i++) {
//            out.append(queue.get(i).val);
//            if (i < queue.size()) {
//                out.append(", ");
//            }
//        }
//        System.out.println(out.toString());
        System.out.println(oout.toString());
    }
}
