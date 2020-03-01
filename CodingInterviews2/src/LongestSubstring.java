import org.junit.Test;

/**
 * 48. 最长不含重复字符的子字符串
 * 题目描述
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */

public class LongestSubstring {
    @Test
    public void test(){
        System.out.println(" ".length());
    }
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()== 0 ){
            return 0;
        }
        int [] position = new int[26];
        for (int i = 0; i < position.length ; i++) {
            position[i] = -1;
        }
        int maxLength = Integer.MIN_VALUE;
        int curLength = 0;
        for (int i = 1; i < s.length(); i++) {
            int pre = position[s.charAt(i) - 'a'];
            int distance = i-pre;
            if (pre < 0 || distance > curLength){
                curLength += 1;
            }else {
                if (maxLength < curLength){
                    maxLength = curLength;
                }
                curLength = distance;
            }
            position[s.charAt(i) - 'a'] = i;
        }
        if(maxLength < curLength){
            maxLength = curLength;
        }
        return maxLength;
    }
}
