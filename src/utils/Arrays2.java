package utils;

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
}
