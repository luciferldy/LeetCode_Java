import utils.TreeNode;

public class Solution108_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }

        return generate(nums, 0, nums.length-1);
    }

    public TreeNode generate(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = generate(nums, start, mid-1);
            root.right = generate(nums, mid+1, end);
            return root;
        }

        return null;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 9;
        int mid = a + ((b - a) >> 1);
        System.out.println(mid);
    }
}
