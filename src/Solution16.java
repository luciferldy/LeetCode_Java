public class Solution16 {

    public static void main(String[] args) {
        Solution16 s = new Solution16();
        int[] S = new int[]{-1, 2, 1, -4};
        System.out.print(s.threeSumClosest(S, 1));
    }


    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    }
                    int l = Math.abs(sum - target);
                    if (l < Math.abs(target - closest)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }
}
