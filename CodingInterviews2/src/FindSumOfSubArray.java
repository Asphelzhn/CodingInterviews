/**
 * 42. 连续子数组的最大和
 * NowCoder
 * <p>
 * 题目描述
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class FindSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int result_sum = Integer.MIN_VALUE;
        for (int num : array) {
            sum = sum < 0 ? num : sum + num;
            result_sum = Math.max(result_sum, sum);
        }
        return result_sum;
    }
}
