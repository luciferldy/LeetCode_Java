import java.util.Scanner;

public class Solution62_UniquePaths {

    public static void main(String[] args) {
        Solution62_UniquePaths s = new Solution62_UniquePaths();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] ll = line.split(",");
            int m = Integer.valueOf(ll[0].trim());
            int n = Integer.valueOf(ll[1].trim());
            int result = s.uniquePaths(m, n);
            System.out.println(result);
        }
    }

    public int uniquePaths(int m, int n) {

        if (m < 1 || n < 1)
            return 0;

        if (m == 1 || n == 1)
            return 1;

        return uniquePaths(m, n-1) + uniquePaths(m-1, n);
    }

    public int uniquePaths2(int m, int n) {

        if (m < 1 || n < 1)
            return 0;

        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    path[i][j] = 1;
                } else {
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }

        return path[m-1][n-1];
    }


}
