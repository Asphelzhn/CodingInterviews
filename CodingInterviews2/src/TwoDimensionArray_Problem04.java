/**
 * 题目描述
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * <p>
 * 解题思路
 * 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
 * <p>
 * 该二维数组中的一个数，小于它的数一定在其左边，大于它的数一定在其下边。因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间，当前元素的查找区间为左下角的所有元素。
 */

public class TwoDimensionArray_Problem04 {
    public boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int start_row = 0, start_col = col - 1;
        while (start_col >= 0 && start_row < row) {
            if (target > array[start_row][start_col]) {
                start_row += 1;
            } else if (target < array[start_row][start_col]) {
                start_col -= 1;
            } else return true;
        }
        return false;
    }
}
