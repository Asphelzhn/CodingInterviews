/**
 * 题目：
 * 数字以0123456789101112131415……的格式序列化到一个字符序列中。在这个序列中，第5位（从0开始计数）是5，第19位是4。请写一个函数，求任意第n为对应的数字。
 */
public class PrintSpecificPosition {

    public static void getDigitalOfN(int n) {
        int index = 1;// 当前走到哪一位了，1：个位，2：十位，3：百位……
        int numbers = index * countOfInteger(index);
        while (n >= numbers) {// 每次跳过index * countOfInteger(index)个
            n -= numbers;
            index++;
            numbers = index * countOfInteger(index);
        }
        int number;// n被卡在了具体哪个数字上
        if (index == 1) {
            number = 0;
        } else {
            number = (int) Math.pow(10, index - 1);
        }
        number += n / index;
        int indexFromRight = index - n % index;// 第n个位置在数字number上的下标，这个下标是从右侧开始计的
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        System.out.println("第" + n + "位数字是：" + number % 10);
    }

    /**
     * n=1：0~9：10个
     * n=2：10~99：90个
     * n=3：100~999：900个
     * n=4：1000~9999:9000个
     */
    public static int countOfInteger(int n) {
        if (n == 1) {
            return 10;
        }
        return (int) (9 * Math.pow(10, n - 1));
    }

}
