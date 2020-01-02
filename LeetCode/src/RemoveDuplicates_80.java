/**
 * 80. Remove Duplicates from Sorted Array II
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicates_80 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && i + 1 < nums.length && nums[i] == nums[i - 1] && nums[i] == nums[i + 1] ) {
                continue;
            }
            nums[index] = nums[i];
            index++;
        }
        return index;
    }
}
