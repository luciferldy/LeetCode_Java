public class Solution26_RemoveDuplicates {

    public static void main(String[] args) {
        Solution26_RemoveDuplicates s = new Solution26_RemoveDuplicates();
        int[] o = new int[]{1, 1, 1, 2, 2};
        int res = s.removeDuplicates(o);
        System.out.println(res);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < o.length; i++) {
            builder.append(o[i]);
            if (i != o.length-1) {
                builder.append(", ");
            }
        }
        System.out.println(builder.toString());
    }


    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
