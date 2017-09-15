import java.util.List;
import java.util.Stack;

public class Solution79_WordSearch {

    public static void main(String[] args) {}

    public boolean exist(char[][] board, String word) {

        if (board.length < 1 || board[0].length < 1)
            return false;

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < used.length; i++)
            for (int j = 0; j < used[0].length; j++)
                used[i][j] = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean found = backTracking(board, i, j, word, 0, used);
                    if (found)
                        return true;
                }
            }
        }

        return false;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private boolean backTracking(char[][] board, int startX, int startY, String word, int p, boolean[][] used) {
        if (p == word.length())
            return true;

        if (startX < 0 || startY < 0 || startX == board.length || startY == board[0].length || used[startX][startY])
            return false;

        if (word.charAt(p) != board[startX][startY])
            return false;

        used[startX][startY] = true;

        for (int k = 0; k < 4; k++) {
            if (backTracking(board, startX+dx[k],
                    startY+dy[k], word, p+1, used))
                return true;
        }

        used[startX][startY] = false;
        return false;
    }
}
