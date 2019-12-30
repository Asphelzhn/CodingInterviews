import java.util.ArrayList;

/*题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*
* 思路（原书例题不需要考虑奇数，偶数之间的相对位置）
* 维护两个指针，第一个指针从头向后移动，越过奇数，指向偶数。
* 第二个指针从尾向前移动，越过偶数，指向奇数。
* 交换两个数字。
* 直到第一个指针移动到第二个指针后面
* 1 2 3 4 5
* 1 5 3 4 2
*
* 思路2（牛客的题增加了条件）
* 考虑使用O（n）的额外空间来存储，将数组中的奇数，偶数单独保存到一个ArrayList里，
* 然后再添加到数组中。
*
* */
public class Solution13 {
    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,7};
        new Solution13().reOrderArray2(array);
        for (int element:array) {
            System.out.println(element);
        }
    }
    public void reOrderArray(int[] array) {
        //不要忘了边界值判断
        if(array == null || array.length == 0){
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            while (array[start] % 2 == 1) {
                start++;
            }
            while (array[end] % 2 == 0) {
                end--;
            }
            if(start <= end){
                change(array,start,end);
            }
        }

    }

    public void reOrderArray2(int[] array) {
        if(array == null || array.length == 0){
            throw new RuntimeException("数组为空");
        }
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        for (int i = 0; i < array.length ; i++) {
            if((array[i] & 0x1) == 1){
                odd.add(array[i]);
            }else {
                even.add(array[i]);
            }
        }
        int count = 0;
        for (int i = 0; i < odd.size(); i++) {
            array[count] = odd.get(i);
            count++;
        }
        for (int i = 0; i < even.size(); i++) {
            array[count] = even.get(i);
            count++;
        }
    }
    public void change(int array[],int start,int end){
        int temp;
        temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
