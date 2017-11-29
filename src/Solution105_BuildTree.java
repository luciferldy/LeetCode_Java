import utils.TreeNode;

public class Solution105_BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int v1, int v2, int u1, int u2) {
        if (v1 > v2)
            return null;
        TreeNode root = new TreeNode(preorder[v1]);
        for (int k = u1; k <= u2; k++) {
            if (preorder[v1] == inorder[k]) {
                root.left = build(preorder, inorder, v1+1, v1 + (k-u1), u1, k-1);
                root.right = build(preorder, inorder, v1+(k-u1)+1, v2, k+1, u2);
            }
        }
        return root;
    }
}
