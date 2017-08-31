import com.sun.istack.internal.NotNull;
import sun.rmi.runtime.Log;

public class Solution43_MultiplyStrings {

    public static void main(String[] args) {
        Solution43_MultiplyStrings s = new Solution43_MultiplyStrings();
        String res = s.multiply("999", "999");
        System.out.println(res);
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;

        if (!isValid(num1) || !isValid(num2))
            return null;

        int row = num1.length();
        int col = num2.length();
        int[][] s = new int[col][row + col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row+col; j++)
                s[i][j] = 0;
        }

        // 构造每一位相乘的数组
        int up;
        for (int i = col-1; i >= 0; i--) {
            up = 0;
            int j;
            int a = Integer.valueOf(String.valueOf(num2.charAt(i)));
            for (j = row + col -1; j >= col; j--) {
                int b = Integer.valueOf(String.valueOf(num1.charAt(j - col)));
//                System.out.println("b: " + b + " s[i][j-(col-1-i)]:" + (j-(col-1-i)));
                s[i][j - (col-1-i)] = (a * b  + up) % 10;
                up = (a * b + up) / 10;
            }
//            System.out.println(String.format("s[%d][%d]", i, j-(col-1-i)));
            s[i][j-(col-1-i)] = up;
        }

        int[] result = new int[s[0].length];
        int sum, m;
        up = 0;
        for (m = col + row - 1; m >= 0; m--) {
            sum = 0;
            for (int n = 0; n < col; n++) {
                sum += s[n][m];
            }

            result[m] = (sum+up) % 10;
            up = (sum+up) / 10; // 当运行到最后一位时为 0
        }

        StringBuilder builder = new StringBuilder();
        boolean removed = false;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0 && !removed && i < result.length-1) {
                System.out.println("continue i = " + i);
                continue;
            }
            builder.append(result[i]);
            removed = true;
        }

        return builder.toString();
    }

    /**
     *  str NotNull
     * @param str
     * @return
     */
    private boolean isValid(@NotNull String str) {
        if (str.length() == 0)
            return false;

        if (str.length() > 1 && str.charAt(0) == '0')
            return false;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return false;
        }

        return true;
    }

    private void printArray(int[][] s) {
        if (s.length == 0 || s[0].length == 0)
            return;
        int col = s.length;
        int row = s[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(s[i][j]);
                if (j < row-1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}
