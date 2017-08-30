public class Solution41_FirstMissingPositive {

    public static void main(String[] args) {
        Solution41_FirstMissingPositive s = new Solution41_FirstMissingPositive();
        int res = s.firstMissingPositive(new int[]{2, 1});
        System.out.println(res);
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
//            System.out.println("i=" + i);
            if (nums[i] != (i+1)
                    && nums[i] >= 1
                    && nums[i] <= nums.length
                    && nums[nums[i]-1] != nums[i]) {
//                swap(nums, i, nums[i]-1);
                /**
                 * tmp = num[0] = 2
                 * num[0] = num[2-1] = num[1] = 1
                 * num[1-1] = tmp
                 */
                int j = nums[i]-1;
                int tmp = nums[i];//3
                nums[i] = nums[j];
                nums[j] = tmp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
