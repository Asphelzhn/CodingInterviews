/*
* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*
* 思路，从前往后扫描，判断是否为空格，如果是空格则添加%20，不是则添加charAt(i)，如果字符为空返回null
* */

public class Solution03 {
    public static void main(String[] args) {

        StringBuffer str = new StringBuffer(" A B C   ");
        System.out.println(new Solution03().replaceSpace(str));
    }

    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)== ' '){
                newString.append("%20");
            }
            else newString.append(str.charAt(i));
        }
        return newString.toString();
    }

    public String replaceSpace2(StringBuffer str) {
        String temp = str.toString();
        String lists[] = temp.split(" ");
        String newString ="";
        int i = 0;
        int j = temp.length()-1;

        //处理开头空格
        while (temp.charAt(i) == ' '){
            newString +="%20";
            ++i;
        }
        //处理中间空格
        for (int x = 0 ; x<lists.length; x++) {
            if(lists[x].equals("")){
                continue;
            }
            //单独处理最后一个字符
            if(x==(lists.length-1)){
                newString+=lists[x];
            }
            else newString +=(lists[x]+"%20");
        }
        //处理结尾空格
        while (temp.charAt(j) == ' '){
            newString +="%20";
            --j;
        }
        return newString;
    }
}
