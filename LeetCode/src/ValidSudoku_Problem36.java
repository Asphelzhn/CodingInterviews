import java.util.Arrays;

/**
 * Valid Sudoku
 * 描述
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules http://sudoku.com.au/TheRules.aspx .
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku_Problem36 {
    public boolean isValidSudoku(char[][] board) {
        boolean element[] = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(element, false);
            //判断行
            for (int j = 0; j < 9; j++) {
                if (checkElement(board[i][j], element)) return false;
            }
            Arrays.fill(element, false);
            //判断列
            for (int j = 0; j < 9; j++) {
                if (checkElement(board[j][i], element)) return false;
            }
        }
        //判断9个格子
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(element, false);
                for (int k = i; k < 3 + i; k++) {
                    for (int l = j; l < 3 + j; l++) {
                        if (checkElement(board[k][l], element)) return false;
                    }
                }
            }

        }
        return true;

    }

    private boolean checkElement(char c, boolean[] element) {
        if (c == '.') return false;
        if (element[c - '1'] == true) return true;
        element[c - '1'] = true;
        return false;
    }
}
