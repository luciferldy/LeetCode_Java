import utils.TreeNode

import java.util.Stack

class Solution104_MaxDepthOfBT {

    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) 0 else 1 + Math.max(maxDepth(root.left), maxDepth(root.right))
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}
