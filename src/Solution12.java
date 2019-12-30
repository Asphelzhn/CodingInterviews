/*题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不需要考虑大数问题，不能用库函数。


* */
public class Solution12 {
    public static void main(String[] args) {
        double base = 0;
        int exponent = -32;
        double result = new Solution12().Power(base,exponent);
        System.out.println(result);
    }
    //比较浮点数是否为0
    public boolean equal0(double base){
        if((base - 0 > -1e-6) && (base - 0 < 1e-6)){
            return true;
        }
        return false;
    }
    public double Power(double base, int exponent) {
        //任何数0次方都为1
        if(exponent == 0){
            return 1;
        }
        //0没有负数次方
        if(equal0(base) && exponent<0){
            throw new RuntimeException("0没有负次方");
        }
        //负数次方时转换底数
        if(exponent < 0){
            base = 1.0 / base;
            exponent = -exponent;
        }
        double result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;

    }
}
