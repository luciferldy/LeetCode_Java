public class Solution42 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int[] d = new int[n];
        int mx = 0;
        // 第一轮循环先计算出 height[i] 左侧最大的值
        for (int i = 0; i < n; i++) {
            d[i] = mx;
            if (height[i] > mx) {
                mx = height[i];
            }
        }
        // 第二轮循环计算出 height[i] 右侧最大的值，并于左侧最大值进行比较， 取其最小者 min
        // 再与 height[i] 比较，如果 height[i] < min 则 i 处可积水，积水的深度为 min-height[i]
        mx = 0;
        for (int i = n-1; i > -1; i--) {
            d[i] = Math.min(mx, d[i]);
            mx = Math.max(mx, height[i]);
            if (d[i] > height[i])
                res += d[i] - height[i];
        }

        return res;
    }
}
