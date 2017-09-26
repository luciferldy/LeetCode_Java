import java.util.Stack;

public class Solution84_LargestRectangleArea {

    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        int res = largestRectangleArea(height);
        System.out.println(res);
    }

    public static int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<>();

        int max = 0;
        int len = height.length;

        for (int i = 0; i <= len; i++) {

            int h = (i == len ? 0 : height[i]);
            if (s.empty() || height[s.peek()] < h) {
                s.push(i);
            } else {
                while (!s.empty() && h <= height[s.peek()]) {
                    int t = height[s.peek()];
                    s.pop();
                    int w = s.empty() ? i : i - 1 - s.peek();
                    max = Math.max(max, t*w);
                }
                s.push(i);
            }
        }

        return max;
    }
}
