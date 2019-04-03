/*题目描述
一只青蛙一次可以跳上1级台阶，
也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

思路
采用数学归纳法
台阶      方法
1           1
2           2
3           4
4           8
    。。。
满足2^(n-1)
* */
public class Solution09 {
    public static void main(String[] args) {
        int result = new Solution09().JumpFloorII(5);
        System.out.println(result);
    }
    public int JumpFloorII(int target) {
        int result = 1;
        if(target == 0){
            return 0;
        }
        for (int i = 1; i < target ; i++) {
            result *= 2;
        }
        return result;

    }
}
