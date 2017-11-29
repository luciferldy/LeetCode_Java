import utils.TreeNode

class Solution110_BalancedBinaryTree {

    fun depth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return maxOf(depth(root.left), depth(root.right)) + 1
    }

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null)
            return true
        val left = depth(root.left)
        val right = depth(root.right)

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }

    
}
