import java.util.ArrayList;
import java.util.List;

public class Solution54_SpiralMatrix {

    public static void main(String[] args) {
        Solution54_SpiralMatrix s = new Solution54_SpiralMatrix();
        int[][] matrix = new int[7][1];
        for (int i = 1; i <= 7; i++) {
            matrix[i-1][0] = i;
        }
        List<Integer> res = s.spiralOrder(matrix);
        s.printArray(res);
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix == null)
            return null;

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (2*i < n && 2*i < m) {

            // 只有一行&只有一个
            if (2*i+1 <= n && 2*i+1 == m) {
                for (int k = i; k < n-i; k++) {
                    res.add(matrix[i][k]);
                }
                break;
            }

            // 只有一列
            if (2*i+1 == n && 2*i+1 < m) {
                for (int k = i; k < m-i; k++) {
                    res.add(matrix[k][i]);
                }
                break;
            }

            // top
            for (int k = i; k < n - i - 1; k++) {
                res.add(matrix[i][k]);
            }
            // right
            for (int k = i; k < m - i - 1; k++) {
                res.add(matrix[k][n-1-i]);
            }
            // bottom
            for (int k = n - 1 - i; k > i; k--) {
                res.add(matrix[m-1-i][k]);
            }
            // left
            for (int k = m - 1 - i; k > i; k--) {
                res.add(matrix[k][i]);
            }

//            System.out.println("i: " + i);
            i++;
        }

        return res;
    }

    public void printArray(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i < list.size()-1)
                builder.append(", ");
        }
        System.out.println(builder.toString());
    }
}
