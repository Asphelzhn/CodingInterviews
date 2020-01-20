import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 分析
 * 先排序，然后左右夹逼，复杂度 O(n^2)
 * 这个方法可以推广到k-sum，先排序，然后做k-2次循环，在最内层循环左右夹逼
 */

public class Threesum_Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        final int target = 0;
        if (nums.length < 3) return arrayLists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                    while (nums[j] == nums[j - 1] && j < k) j++;
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                    while (nums[k] == nums[k + 1] && j < k) k--;
                } else {
                    arrayLists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (nums[j] == nums[j - 1] && j < k) j++;
                    while (nums[k] == nums[k + 1] && j < k) k--;

                }
            }
        }
        return arrayLists;
    }
}
