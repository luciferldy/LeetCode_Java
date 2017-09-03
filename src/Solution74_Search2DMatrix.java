public class Solution74_Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = 0, n = 0;
        while (m < matrix.length && n < matrix[0].length) {

            if (matrix[m][n] == target)
                return true;

            if (matrix[m][n] < target) {

                if (m+1 < matrix.length) {
                    if (matrix[m+1][n] > target) {
                        n++;
                    } else {
                        // matrix[m+1][n] <= target
                        m++;
                    }
                    continue;
                }

                if (n+1 < matrix[0].length) {
                    if (matrix[m][n+1] > target) {
                        break;
                    } else {
                        // matrix[m][n+1] <= target
                        n++;
                    }
                    continue;
                }

                if (m == matrix.length-1 && n == matrix[0].length-1) {
                    break;
                }

            } else {
                break;
            }
        }

        return false;
    }
}
