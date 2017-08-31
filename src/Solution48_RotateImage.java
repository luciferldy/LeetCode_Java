public class Solution48_RotateImage {

    public static void main(String[] args) {
        Solution48_RotateImage s = new Solution48_RotateImage();
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{5,1,9,11};
        matrix[1] = new int[]{2,4,8,10};
        matrix[2] = new int[]{13,3,6,7};
        matrix[3] = new int[]{15,14,12,16};

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                builder.append(matrix[i][j]);
                if (j < matrix[0].length - 1)
                    builder.append(", ");
            }
            System.out.println(builder.toString());
        }

        s.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                builder.append(matrix[i][j]);
                if (j < matrix[0].length - 1)
                    builder.append(", ");
            }
            System.out.println(builder.toString());
        }
    }

    public void rotate(int[][] matrix) {
        int t1, t2, t3;
        int width = matrix.length;
        // 第一圈
        for (int i = 0; i < width/2; i++) {

            // 第二圈
            for (int j = i; j < width-i-1; j++) {
                t1 = matrix[j][width-1-i];
                t2 = matrix[width-1-i][width-1-j];
                t3 = matrix[width-1-j][i];

                // assignment
                matrix[j][width-1-i] = matrix[i][j];
                matrix[width-1-i][width-1-j] = t1;
                matrix[width-1-j][i] = t2;
                matrix[i][j] = t3;
            }
        }
    }
}
