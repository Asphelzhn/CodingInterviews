/*题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
*
*
*思路
* 将整数转化为二进制补码表示，然后判断最右边的数是否是1，通过与1做与运算得到。1 & 1 = 1 ，0 & 1 = 0；
* 然后将补码右移一位，判断下一位。
* 也可以左移1，每次让左移后的1与n做与运算。
* */
public class Solution11 {
    public static void main(String[] args) {
        System.out.println(new Solution11().NumberOf1(9));
    }
    public int NumberOf1(int n) {
        int num = 0;
        while (n != 0 ){
            //判断低位是否为1；
            if((n & 1) == 1){
                num++;
            }
            //无符号右移，例如1001 >>> 2 = 0010
            n = n >>> 1;
        }
        return num;
    }
}
