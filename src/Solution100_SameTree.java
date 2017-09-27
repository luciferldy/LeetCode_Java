import utils.TreeNode;

public class Solution100_SameTree {

    public static void main(String[] args) {
        String p = null, q = null;
        System.out.println(p == q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p == null)
            return false;
        if (q == null)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
