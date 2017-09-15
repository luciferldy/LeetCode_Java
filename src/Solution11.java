
public class Solution11 {
    public static void main(String[] args) {
        Solution11 m = new Solution11();
        int r = m.maxArea(new int[]{8,10,14,0,13,10,9,9,11,11});
        System.out.print(r);
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length-1;
        if (j <= 0 ) {
            return 0;
        }
        while (i < j) {
            int area = (j-i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return maxArea;
    }
}
