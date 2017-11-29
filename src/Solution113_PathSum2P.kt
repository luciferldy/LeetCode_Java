import utils.TreeNode

import java.util.ArrayList

class Solution113_PathSum2P {

    internal var result: MutableList<List<Int>> = ArrayList()

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        if (result.size > 0)
            result.clear()
        if (root != null)
            recursive(root, sum, ArrayList())
        return result
    }

    private fun recursive(root: TreeNode?, sum: Int, current: MutableList<Int>) {
        if (root == null)
            return
        if (root.`val` == sum && root.left == null && root.right == null) {
            current.add(root.`val`)
            result.add(ArrayList(current))
            current.removeAt(current.size - 1)
            return
        }

        current.add(root.`val`)
        recursive(root.left, sum - root.`val`, current)
        recursive(root.right, sum - root.`val`, current)
        current.removeAt(current.size - 1)
    }
}
