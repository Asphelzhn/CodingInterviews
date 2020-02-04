/**
 * Increasing Triplet Subsequence
 * 描述
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * More specifically, if there exists i, j, k such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 return true else return false.
 * Your function should run in O(n) time complexity and O(1) space complexity.
 * Examples:
 * Given [1, 2, 3, 4, 5], return true.
 * Given [5, 4, 3, 2, 1], return false.
 * 分析
 * 扫描一遍数组，用变量x1保存当前最小的值，变量x2保存当前第二小的值。如果右面能碰到一个数大于x2，说明必然存在一个递增的三元组。
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x <= x1) x1 = x;
            else if (x <= x2) x2 = x;
            else return true;
        }
        return false;
    }
}
