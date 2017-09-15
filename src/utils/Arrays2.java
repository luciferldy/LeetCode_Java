package utils;

import java.util.List;

public class Arrays2 {

    public static void printArray(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            builder.append(nums[i]);
            if (i != nums.length-1) {
                builder.append(", ");
            }
        }

        System.out.println(builder.toString());
    }

    public static void printArray(List<List<Integer>> list) {
        StringBuilder b;
        for (int i = 0; i < list.size(); i++) {
            b = new StringBuilder();
            List<Integer> t = list.get(i);
            for (int j = 0; j < t.size(); j++) {
                b.append(t.get(j));
                if (j != t.size()-1)
                    b.append(", ");
            }
            System.out.println(b.toString());
        }
    }
}
