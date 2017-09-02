public class Solution64_MinPathSum {

    public int minPathSum(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    res[i][j] = grid[0][0];
                else if (i == 0 && j > 0)
                    res[i][j] = grid[i][j] + res[i][j-1];
                else if (i > 0 && j == 0)
                    res[i][j] = grid[i][j] + res[i-1][j];
                else {
                    res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
                }
            }
        }

        return res[m-1][n-1];
    }
}
