public class Solution36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }

        int i, j, m, n;
        int[] map;
        // 查看每一行是否负责要求
        for (i = 0; i < 9; i++) {
            map = new int[9];
            for (j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (board[i][j] < '0' || board[i][j] > '9')
                    return false;
                int num = board[i][j] - '0';
                if (map[num] == 1)
                    return false;
                map[num] = 1;
            }
        }

        // 查看一列是否符合要求
        for (j = 0; j < 9; j++) {
            map = new int[9];
            for (i = 0; i < 9; i++) {
                if (board[i][j] == '.')
                    continue;
                if (board[i][j] < '0' || board[i][j] > '9')
                    return false;
                int num = board[i][j] - '0';
                if (map[num] == 1)
                    return false;
                map[num] = 1;
            }
        }

        //
        for (i = 0; i < 9; i+=3) {
            for (j = 0; j < 9; j+=3) {
                map = new int[9];
                for (m = i; m < i+3; m++) {
                    for (n = j; n < j+3; n++) {
                        if (board[m][n] == '.')
                            continue;
                        int num = board[m][n] - '0';
                        if (map[num] == 1)
                            return false;
                        map[num] = 1;
                    }
                }
            }
        }

        return true;
    }
}
