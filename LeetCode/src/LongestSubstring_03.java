import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring_03 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<>();
        int max_length = 0;
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (characters.contains(s.charAt(j))) {
                characters.remove(s.charAt(i));
                i++;
            } else {
                characters.add(s.charAt(j++));
                max_length = Math.max(j - i, max_length);
            }

        }
        return max_length;
    }
}
