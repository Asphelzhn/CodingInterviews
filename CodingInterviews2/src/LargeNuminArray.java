/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

public class LargeNuminArray {
    public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            count = array[i] == pre ? count+1:count-1;
            if (count == 0){
                pre = array[i];
                count = 1;
            }
        }
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == pre){
                num++;
            }
        }
        return  num > (array.length / 2) ? num: 0;

    }
    public int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }
}
