import java.util.ArrayList;
import java.util.List;

public class Solution47_Permutations2 {

    public static void main(String[] args) {
        Solution47_Permutations2 s = new Solution47_Permutations2();
        List<List<Integer>> res = s.permuteUnique(new int[]{3, 3, 0, 3});
        s.printList(res);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int len = res.size();
            tmp.clear();
            for (int j = 0; j < len; j++) {
                List<Integer> l = res.get(j);
                for (int k = 0; k < l.size(); k++) {
                    List<Integer> m = new ArrayList<>(l);
                    m.add(k, nums[i]);
                    if (!tmp.contains(m)) {
                        tmp.add(m);
                    }
                }
                l.add(nums[i]);
                if (!tmp.contains(l)) {
                    tmp.add(l);
                }
            }
            res.clear();
            res.addAll(tmp);
            System.out.println(String.format("res.size() = %d", res.size()));
            if (i == 0) {
                List<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                res.add(t);
            }
        }

        return res;
    }

    private void printList(List<List<Integer>> lists) {

        if (lists == null) {
            System.out.println("PrintList lists is null.");
            return;
        }

        for (int i = 0; i < lists.size(); i++) {
            StringBuilder builder = new StringBuilder();
            List<Integer> l = lists.get(i);
            for (int j = 0; j < l.size(); j++) {
                builder.append(l.get(j));
                if (j < l.size()-1)
                    builder.append(", ");
            }
            System.out.println(builder.toString());
        }
    }
}
