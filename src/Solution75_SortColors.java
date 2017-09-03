public class Solution75_SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int head = 0, end = nums.length-1, i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                nums[i++] = nums[head];
                nums[head++] = 0;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end--] = 2;
            } else {
                i++;
            }
        }
    }

}
