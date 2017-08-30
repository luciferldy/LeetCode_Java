import java.util.Arrays;

public class Solution33_RotatedSortedArray {

    public static void main(String[] args) {
        Solution33_RotatedSortedArray s = new Solution33_RotatedSortedArray();
        int[] num = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result = s.search(num, 4);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int a = -1;
//        int c = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                a = i;
            }
//            if (i > 0 && nums[i] < nums[i-1]) {
//                c = i-1;
//            }
        }
        return a;
    }
}
