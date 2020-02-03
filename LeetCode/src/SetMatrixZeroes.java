import java.util.Arrays;

/**
 * Set Matrix Zeroes
 * 描述
 * Given a m × n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up: Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 分析
 * O(m+n)空间的方法很简单，设置两个bool数组，记录每行和每列是否存在0。
 * 想要常数空间，可以复用第一行和第一列。
 */
public class SetMatrixZeroes {
    // Set Matrix Zeroes
// 时间复杂度O(m*n)，空间复杂度O(m+n)
    public class Solution {
        public void setZeroes(int[][] matrix) {
            final int m = matrix.length;
            final int n = matrix[0].length;
            boolean[] row = new boolean[m]; // 标记该行是否存在0
            boolean[] col = new boolean[n]; // 标记该列是否存在0

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }

            for (int i = 0; i < m; ++i) {
                if (row[i]) Arrays.fill(matrix[i], 0);
            }
            for (int j = 0; j < n; ++j) {
                if (col[j]) {
                    for (int i = 0; i < m; ++i) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
