import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39_CombinationSum {

    public static void main(String[] args) {
        Solution39_CombinationSum c = new Solution39_CombinationSum();
        c.combinationSum(new int[]{10,1,2,7,6,1,5}, 8);
    }

    /**
     * 现在的版本可以运行 Solution 40
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null)
            return result;

        Arrays.sort(candidates);
        backtracking(candidates, 0, target, result, new ArrayList<>());
         printArray(result);
        return result;
    }

    private void backtracking(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> current) {
        if (target < 0)
            return;

        if (target == 0) {
            res.add(current);
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            // 也可以去重
            if (i > start && candidates[i] == candidates[i-1])
                continue;
            current.add(candidates[i]);
            backtracking(candidates, i+1, target - candidates[i], res, new ArrayList<>(current));
            current.remove(current.size() - 1);
            // 有效去重
//            while (i+1 < candidates.length && candidates[i] == candidates[i+1]) {
//                i++;
//            }
        }
    }

    private void printArray(List<List<Integer>> list) {
        if (list == null)
            return;

        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            List<Integer> l = list.get(i);
            if (l == null || l.size() == 0) {
                break;
            }
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < l.size(); j++) {
                builder.append(l.get(j));
                if (j < l.size()-1) {
                    builder.append(", ");
                }
            }
            System.out.println(builder.toString());
        }
    }
}
