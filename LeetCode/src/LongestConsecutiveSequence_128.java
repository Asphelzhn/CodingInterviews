import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * 分析
 * 由于序列里的元素是无序的，又要求O(n)，首先要想到用哈希表。
 * 用一个哈希表存储所有出现过的元素，对每个元素，以该元素为中心，往左右扩张，直到不连续为止，记录下最长的长度。
 */

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 0;
        for (int i : nums) {
            int length = 1;
            for (int j = i - 1; set.contains(j); --j) {
                set.remove(j);
                ++length;
            }
            for (int j = i + 1; set.contains(j); ++j) {
                set.remove(j);
                ++length;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
