import org.junit.Test;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * <p>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 分析
 * 首先你要知道什么是 字典排序
 * 其实理解一下就是全排列。举个例子。
 * 1,2,3,4 / 1,2,4,3 / 1,3,2,4 / 1,3,4,2 / 1,4,2,3 / 1,4,3,2
 * 上面就是所谓的字典排序的顺序。
 * 按照题目要求，返回下一个，就是按照上面的顺序到下一个排序。
 * <p>
 * 思路
 * 这个题，就是属于强行找规律的题目
 * <p>
 * [1,2,7,4,3,1] ====> [1,3,1,2,4,7]
 * 规律就是说 从后向前遍历，找到第一个降序的数字，2。
 * 然后继续从后向前遍历，找比这个数大的第一个数，3。
 * 之后交换两个数字，变成 [1,3,7,4,2,1]
 * 然后把后面的数字 反转，变成 [1,3,1,2,4,7] 即为最终答案。
 */
public class NextPermutation_Problem31 {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = -1, last_index = 0;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            reverse(0,nums);
            return;
        }
        for (int i = length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                last_index = i;
                break;
            }
        }
        swap(nums, index, last_index);
        reverse(index+1, nums);
    }

    private void reverse(int index, int[] nums) {
        int start = index;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int index, int last_index) {
        int temp = 0;
        temp = nums[index];
        nums[index] = nums[last_index];
        nums[last_index] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
