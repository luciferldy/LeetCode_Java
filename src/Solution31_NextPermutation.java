import utils.Arrays2;

import java.util.Arrays;

public class Solution31_NextPermutation {

    public static void main(String[] args) {
        Solution31_NextPermutation s = new Solution31_NextPermutation();
        int[] num = new int[]{16,27,25,23,25,16,12,9,1,2,7,20,19,23,16,0,6,22,16,11,8,27,9,2,20,2,13,7,25,29,12,12,18,29,27,13,16,1,22,9,3,21,29,14,7,8,14,5,0,23,16,1,20};
        Arrays2.printArray(num);
        s.nextPermutation(num);
        Arrays2.printArray(num);
    }

    public void nextPermutation(int[] nums) {
        int i, j;
        int prev = -1;

        // 从 i 位置开始，如果 i 位置后 j 有比 i 位置的数字更大的值，则 num[i] 与 num[j] 可换
        // 但是需要找到一个最优的解，所以需要 i 尽可能的小
        for (i = 0; i < nums.length; i++) {
            for (j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    prev = i;
                    break;
                }
            }
        }

        // 说明数组是一个降序排列
        if (prev == -1) {
            Arrays.sort(nums);
            return;
        }

        // 寻找 prev 后大于 num[prev] 的最小数
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int k = prev+1; k < nums.length; k++) {
            if (nums[k] > nums[prev] && nums[k] <= min) {
                min = nums[k];
                minIndex = k;
            }
        }

        // 可以交换 minIndex 和 prev 的位置的数字

        int tmp = nums[minIndex];
        nums[minIndex] = nums[prev];
        nums[prev] = tmp;

        // 对 prev+1 开始的数字进行排序
        for (int m = prev+1; m < nums.length; m++) {
            for (int n = m+1; n < nums.length; n++) {
                if (nums[n] < nums[m]) {
                    tmp = nums[n];
                    nums[n] = nums[m];
                    nums[m] = tmp;
                }
            }
        }

    }
}
