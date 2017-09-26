import utils.Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90_Subsets2 {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Solution90_Subsets2 s = new Solution90_Subsets2();
        s.subsetsWithDup(new int[]{1, 2, 2});
        Arrays2.printArray(s.result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.clear();
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            current.clear();
            current.add(nums[i]);
            backTracing(nums, i+1, current);
        }
        result.add(new ArrayList<>());
        return result;
    }

    private void backTracing(int[] nums, int i, List<Integer> current) {
        if (!result.contains(current)) {
            result.add(new ArrayList<>(current));
        }

        for (int j = i; j < nums.length; j++) {
            current.add(nums[j]);
            backTracing(nums, j+1, current);
            current.remove(current.size()-1);
        }
    }
}
