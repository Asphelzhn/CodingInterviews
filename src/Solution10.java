/*题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

思路
把2*8的覆盖方法记为F(8),用一个2*1矩形去覆盖大矩形时，可以竖放也可以横放。
当竖着放时，还剩下2*7大矩形，记为F(7)。当横着放时，下方需要对应放一个横着的矩形，还剩下
2*6个大矩形，记为F(6)。所以F（8）= F(7) + F(6)。对应斐波那契数列
当target = 0时，返回0；
当target = 1时，返回1；
当target = 2时，返回2；
* */

public class Solution10 {
    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return RectCover(target-1)+RectCover(target-2);
    }
}
