import utils.Arrays2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution78_Subsets {

    List<List<Integer>> sets = new ArrayList<>();

    public static void main(String[] args) {
        Solution78_Subsets set = new Solution78_Subsets();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++)
                num[i] = scanner.nextInt();
            set.subsets(num);

            Arrays2.printArray(set.sets);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        sets.clear();
        sets.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(nums[i]);
            recursive(nums, i+1, a);
        }

        return sets;
    }

    private void recursive(int[] nums, int i, ArrayList<Integer> current) {
        sets.add(new ArrayList<>(current));
        for (int k = i; k < nums.length; k++) {
            current.add(nums[k]);
            recursive(nums, k+1, current);
            current.remove(current.size()-1);
        }
    }
}
