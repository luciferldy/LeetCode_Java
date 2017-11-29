import utils.TreeNode
import java.util.*

class Solution111_MinDepthOfBinaryTree {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

        }
    }

    fun minDepth(root: TreeNode?): Int {
        root?.let {
            // 判断一个节点是否是叶子节点
            if (root.left == null && root.right == null) {
                return 1
            }
            if (root.left == null) {
                return minDepth(root.right) + 1
            }
            if (root.right == null) {
                return minDepth(root.left) + 1
            }
            return minOf(minDepth(root.left), minDepth(root.right)) + 1
        }
        return 0
    }
 }