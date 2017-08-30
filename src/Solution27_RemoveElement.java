public class Solution27_RemoveElement {

    public static void main(String[] args) {
        Solution27_RemoveElement s = new Solution27_RemoveElement();
        int[] num = new int[]{3, 2, 2, 3};
        int len = s.removeElement(num, 3);
        System.out.println(len);
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}
