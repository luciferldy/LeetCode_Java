public class Solution73_SetMatrixZeros {

    public static void main(String[] args) {
        Solution73_SetMatrixZeros s = new Solution73_SetMatrixZeros();
        s.setZeros(null);
    }

    public void setZeros(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] a = new boolean[m];
        for (int i = 0; i < m; i++) {
            a[i] = false;
        }
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            b[i] = false;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    a[i] = true;
                    b[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] || b[j])
                    matrix[i][j] = 0;
            }
        }
    }


}
