/**
 * Majority Element
 * 描述
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 分析
 * 这题最简单的解法，先把数组排序，O(nlogn)，然后从头到尾扫描一遍，找出最长的连续子串。
 * 由于超过⌊ n/2 ⌋次，可以对上面的方法改进一下，排序后，不需要扫描，直接返回中间那个元素，nums[n/2]，肯定就是答案。
 * 上述两个方法都是 O(nlogn)的，本题有一个线性解法。由于超过⌊ n/2 ⌋，可以用相抵消的思想，凡是和最多元素不相等的，就抵消，最后剩下的一定就是最多的那个元素。
 */
public class MajorityElement {
    // Majority Element
// Time Complexity: O(n), Space Complexity: O(1)

    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;

        for (int x : nums) {
            if (count == 0) {
                result = x;
                count = 1;
            } else if (result == x) {
                ++count;
            } else {
                --count;
            }
        }
        return result;
    }

}
