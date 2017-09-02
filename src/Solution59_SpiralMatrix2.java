import java.util.Scanner;

public class Solution59_SpiralMatrix2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution59_SpiralMatrix2 s = new Solution59_SpiralMatrix2();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] res = s.generateMatrix(n);
            s.printArray(res);
        }
    }

    private void printArray(int[][] n) {
        for (int i = 0; i < n.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n[0].length; j++) {
                builder.append(n[i][j]);
                if (j < n[0].length-1)
                    builder.append(", ");
            }
            System.out.println(builder.toString());
        }
    }

    public int[][] generateMatrix(int n) {
        if (n < 1)
            return new int[0][0]; // 还有这种操作
        int i = 0;
        int c = 1;
        int k;
        int[][] res = new int[n][n];
        while (2 * i < n) {

            // 正好是中间的
            if (2*i+1 == n) {
                res[i][i] = c;
                break;
            }

            // top
            for (k = i; k < n - 1 - i; k++) {
                res[i][k] = c++;
            }
            // right
            for (k = i; k < n - 1 - i; k++) {
                res[k][n-1-i] = c++;
            }
            // bottom
            for (k = n - 1 - i; k > i; k--) {
                res[n-1-i][k] = c++;
            }
            // left
            for (k = n - 1 - i; k > i; k--) {
                res[k][i] = c++;
            }
            i++;
        }

        return res;
    }
}
