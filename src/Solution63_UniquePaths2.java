import java.util.Scanner;

public class Solution63_UniquePaths2 {

    public static void main(String[] args) {
        Solution63_UniquePaths2 s = new Solution63_UniquePaths2();
        int[][] src = new int[4][3];
        src[0] = new int[]{0, 0, 0};
        src[1] = new int[]{0, 1, 0};
        src[2] = new int[]{0, 0, 0};
        src[3] = new int[]{0, 0, 0};
        int result = s.uniquePAthsWithObstacles(src);
        System.out.println(result);
    }

    public int uniquePAthsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (obstacleGrid[i][j] == 1)
                        path[i][j] = 0;
                    else {
                        //
                        if (i == 0 && j == 0)
                            path[i][j] = 1;
                        else if (j > 0)
                            path[i][j] = path[i][j-1];
                        else
                            path[i][j] = path[i-1][j];
                    }
                    continue;
                }
                if (obstacleGrid[i][j] == 1)
                    path[i][j] = 0;
                else
                    path[i][j] = path[i][j-1] + path[i-1][j];
            }
        }

        return path[m-1][n-1];
    }
}
