/*
【剑指offer】
* 在一个二维数组中（每个一维数组的长度相同），
* 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*
*   1.在数组中选取一个数右上角的数去array[i][j]和target比较大小   
      a）如果array[i][j] > target 则向左走 即 j--
      b) 如果array[i][j] < target 则向下走 即 i++

*   注意：
*   1.我们在选取第一个数来与target比较大小时，选取数组中每行每列最后一个数。
*   因为这样在比较大小时，在选取第二个数比较时不会出现冲突。
    2.在比较前可以判断数组是否为空，查找的这个数是否在数组中。
* */

public class Solution01 {
    public static void main(String[] args) {
        int array[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new Solution01().Find(2,array));
    }
    public boolean Find(int target, int [][] array) {
        int cols = array[0].length;
        int rows = array.length;
        //数组为空
        if(cols==0 || rows ==0){
            return false;
        }
        //超出范围边界
        if(target<array[0][0] || target>array[rows-1][cols-1]){
            return false;
        }
        else {
                int i = 0;
                int j = array[i].length-1;
                while (i<rows && j>=0 ){
                    if(target > array[i][j]){
                        i++;
                    }
                    else if (target < array[i][j]){
                        j--;
                    }
                    else return true;
                }

        }
        return false;
    }
}