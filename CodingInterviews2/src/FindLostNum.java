import org.junit.Test;

import java.util.Arrays;


//给定一个数组，找出不在数组中的最小的那个数字

/**
 * 41. 缺失的第一个正数
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class FindLostNum {
    //方法三：将数组视为哈希表
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test(){
        int num[] = {3,3,4,4,5,1};
        int result = FindLostNum.findNum(num);
        System.out.println(result);
    }
    //先排序再查找
    public static int findNum(int num[]){
        Arrays.sort(num);
        int count = 1;
        for (int i = 0; i < num.length; i++) {
            if (count != num[i]){
                return count;
            }
            else {
                if(num[i+1] != count){
                    count++;
                }
            }

        }
        return -1;
    }
}
