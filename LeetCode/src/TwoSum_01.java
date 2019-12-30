/*
* 1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

import java.util.HashMap;

public class TwoSum_01 {

    /**
     * 使用两层循环遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int nums[], int target) {
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 使用HashMap
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int nums[], int target) {
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);

        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,4};
        int target = 6;
        int[] result = twoSum2(nums, target);
        for (int temp : result) {
            System.out.println(temp);
        }

    }
}
