import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Solution46_Permutations {

    public static void main(String[] args) {

        Solution46_Permutations s = new Solution46_Permutations();
        s.permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        recursive(res, new ArrayList<>(), nums, 0);
        printList(res);
        return res;
    }

    private void recursive(List<List<Integer>> res, List<Integer> current, int[] nums, int start) {

        if (start >= nums.length-1) {
            for (int i = 0; i < current.size(); i++) {
                List<Integer> list = new ArrayList<>(current);
                list.add(i, nums[start]);
                res.add(list);
            }
            List<Integer> list = new ArrayList<>(current);
            list.add(nums[start]);
            res.add(list);
            return;
        }

        for (int i = 0; i < current.size(); i++) {
            List<Integer> list = new ArrayList<>(current);
            list.add(i, nums[start]);
            recursive(res, list, nums, start+1);
        }
        ArrayList<Integer> list = new ArrayList<>(current);
        list.add(nums[start]);
        recursive(res, list, nums, start+1);


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
