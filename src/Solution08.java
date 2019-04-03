/*题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

思路
采用数学归纳法
台阶      跳法
1           1
2           2
3           3
4           5
5           8
    ...
 可以看到满足斐波那契数列，采用循环实现，保证效率
* */

public class Solution08 {

    public static void main(String[] args) {
        int result = new Solution08().JumpFloor(4);
        System.out.println(result);
    }
    public int JumpFloor(int target) {
        int result = 0;
        int preNum = 1;
        int prepreNum = 1;
        if(target == 0)
        {
            return 0;
        }
        if (target == 1){
            return 1;
        }
        for (int i = 2; i <= target ; i++) {
            result = preNum + prepreNum;
            prepreNum = preNum;
            preNum = result;
        }
        return result;
    }

}
