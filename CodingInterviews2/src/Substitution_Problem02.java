/**
 * 题目描述
 * 将一个字符串中的空格替换成 "%20"。
 * <p>
 * Input:
 * "A B"
 * <p>
 * Output:
 * "A%20B"
 */
public class Substitution_Problem02 {
    public String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
