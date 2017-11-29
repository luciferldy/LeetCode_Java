import utils.TreeNode;

/**
 * 通过中序遍历和后续遍历确定一棵树
 */
public class Solution106_BuildTree {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int v1, int v2, int u1, int u2) {
        if (v1 > v2 || u1 > u2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[u2]);
        for (int k = v1; k <= v2; k++) {
            if (inorder[k] == postorder[u2]) {
                root.left = build(inorder, postorder, v1, k-1, u1, u1+(k-v1)-1);
                root.right = build(inorder, postorder, k+1, v2, u1+(k-v1), u2-1);
            }
        }
        return root;
    }
}
