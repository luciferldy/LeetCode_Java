public class Solution53_MaximumSubArray {

    public static void main(String[] args) {
        Solution53_MaximumSubArray s = new Solution53_MaximumSubArray();
        int result = s.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.print(result);
    }

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
