/**
 * 27. Remove Element
 * <p>
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveElement_Problem27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            else nums[index++] = nums[i];
        }
        return index;
    }
}
