public class Solution55_JumpGame {

    public static void main(String[] args) {
        Solution55_JumpGame s = new Solution55_JumpGame();
        boolean r1 = s.canJump(new int[]{2, 3, 1, 1, 4});
        boolean r2 = s.canJump(new int[]{3, 2, 1, 0, 4});

        System.out.print("r1: " + r1 + ", r2: " + r2);
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1)
            return false;
        if (nums.length == 1)
            return true;

        int right = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (right < i)
                break;
            right = Math.max(right, i+nums[i]);
        }

        return right>=nums.length-1;
    }
}
