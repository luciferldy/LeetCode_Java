import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution13 {

    public static void main(String[] args) {
        int[] sum = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> l = new Solution13().threeSum(sum);
        System.out.print(l);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++ ) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int begin = i+1, end = nums.length-1;
            while (begin < end) {
                if (nums[begin] + nums[end] + nums[i] == 0) {
                    ArrayList<Integer> m = new ArrayList<>();
                    m.add(nums[i]);
                    m.add(nums[begin]);
                    m.add(nums[end]);
                    res.add(m);
                    while (begin < end && nums[begin] == nums[begin+1]) {
                        begin++;
                    }
                    while (begin < end && nums[end-1] == nums[end]) {
                        end--;
                    }
                    begin++;
                    end--;
                } else if (nums[begin] + nums[end] + nums[i] < 0) {
                    begin++;
                } else {
                    end--;
                }
            }
        }

        return res;

    }
}
