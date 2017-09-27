import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution98_ValidBST {

    /**
     * 1. The left subtree of a node contains only nodes with keys less than the node's key.
     * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
     * 3. Both the left and right subtrees must also be binary search trees.
     * https://leetcode.com/problems/validate-binary-search-tree/discuss/
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (prev != null && root.val <= prev.val)
                return false;

            prev = root;
            root = root.right;
        }

        return true;
    }


    private boolean isValidBST(TreeNode root, List<Integer> less, List<Integer> more) {

        return false;
    }
}
