/**
 * 13. 机器人的运动范围
 * <p>
 * 题目描述
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * <p>
 * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */


public class RobotMove {
    private int count = 0;
    private int direction[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;


    public int movingCount(int threshold, int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        dfs(threshold, 0, 0, marked);
        return count;


    }

    // 深度优先遍历
    private void dfs(int threshold, int start_row, int start_col, boolean[][] marked) {
        if (start_row < 0 || start_row >= rows || start_col < 0 || start_col >= cols || marked[start_row][start_col]) {
            return;
        }
        int sumNum = sumDigits(start_row, start_col);
        if (sumNum > threshold) {
            return;
        }
        marked[start_row][start_col] = true;
        count++;
        for (int direct[] : direction) {
            dfs(threshold, start_row + direct[0], start_col + direct[1], marked);
        }

    }

    private int sumDigits(int start_row, int start_col) {
        int sum = 0;
        while (start_row != 0) {
            sum += start_row % 10;
            start_row /= 10;
        }
        while (start_col != 0) {
            sum += start_col % 10;
            start_col /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int count = new RobotMove().movingCount(5, 10, 10);
        System.out.println(count);
    }
}
