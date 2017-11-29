import utils.TreeNode

class Solution112_PathSum {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        //
        return backtracking(root, sum)
    }

    fun backtracking(root: TreeNode?, sum: Int): Boolean {
        if (root == null)
            return false
        if (root.`val` == sum && root.left == null && root.right == null)
            return true
        // 这里没有条件判断，防止出现负数的情况
        return backtracking(root.left, sum - root.`val`) || backtracking(root.right, sum - root.`val`)
    }
}