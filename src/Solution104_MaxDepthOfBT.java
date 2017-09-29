import utils.TreeNode;

import java.util.Stack;

public class Solution104_MaxDepthOfBT {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
