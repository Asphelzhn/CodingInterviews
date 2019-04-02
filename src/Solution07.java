/*
* 题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
递归实现思路清晰，但是占用内存
* */

public class Solution07 {
    public static void main(String[] args) {
        int result = new Solution07().Fibonacci2(5);
        System.out.println(result);
    }
    public int Fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        else if(n == 1 || n == 2){
            return 1;
        }
        else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }

    }

    public int Fibonacci2(int n) {
        if(n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        int result = 0;
        int preNum = 1;
        int prepreNum = 0;
        for (int i = 2; i <= n ; i++) {
            result = preNum + prepreNum;
            prepreNum = preNum;
            preNum = result;
        }
        return result;
    }

}
