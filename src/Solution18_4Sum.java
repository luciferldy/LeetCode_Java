import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18_4Sum {

    public static void main(String[] args) {
        Solution18_4Sum s = new Solution18_4Sum();
        List<List<Integer>> res = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(res);
    }

    // 4Sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> s = new ArrayList<>();
        Arrays.sort(nums);
        // 先固定两个数
        for (int i = 0; i < nums.length; i++) {

            // 如果 i 与 i-1 相同，保证 i-1 可以进行一次循环
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {

                // 如果 j 与 j-1 相同，保证 j-1 可以进行一次循环
                // j-1 且相等的部分pass
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int begin = j+1;
                int end = nums.length-1;
                while (begin < end) {
                    if (nums[i]+nums[j]+nums[begin]+nums[end] == target) {
                        List<Integer> item = new ArrayList<>();
                        item.addAll(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        s.add(item);

                        while (begin < end && nums[begin] == nums[begin+1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end-1]) {
                            end--;
                        }
                        begin++;
                        end--;
                    } else if (nums[i]+nums[j]+nums[begin]+nums[end] < target) {
                        begin++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return s;
    }
}
