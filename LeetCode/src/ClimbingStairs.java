/**
 * /本质为斐波拉契数列
 * //1.假设当有n个台阶时假设有f(n)种走法。
 * //2.青蛙最后一步要么跨1个台阶要么跨2个台阶。
 * //3.当最后一步跨1个台阶时即之前有n-1个台阶，根据1的假设即n-1个台阶有f(n-1)种走法。
 * //4. 当最后一步跨2个台阶时即之前有n-2个台阶，根据1的假设即n-2个台阶有f(n-2 )种走法。
 * //5.显然n个台阶的走法等于前两种情况的走法之和即f(n)=f(n-1)+f(n-2)。
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 0) return -1;
        else if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        int pre = 0 , cur = 1;
        for (int i = 1; i <= n; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;

        }
        return cur;
    }

    public static void main(String[] args) {
        int i = new ClimbingStairs().climbStairs(5);
        System.out.println(i);
    }
}
