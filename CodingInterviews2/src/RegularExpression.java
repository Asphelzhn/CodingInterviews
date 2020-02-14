/**
 *19. 正则表达式匹配
 * NowCoder
 *
 * 题目描述
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*' 表示它前面的字符可以出现任意次（包含 0 次）。
 *
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 */
public class RegularExpression {

    public boolean match(char[] str, char[] pattern) {
        int sindex = 0, pindex = 0;
        return matchCore(str, sindex, pindex, pattern);
    }

    public boolean matchCore(char[] str, int sindex, int pindex, char[] pattern) {
        if (sindex >= str.length && pindex == pattern.length)
            return true;
        if (pindex >= pattern.length && sindex < str.length)
            return false;
        if (pindex + 1 < pattern.length && pattern[pindex + 1] == '*') {
            if (sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.')) {
                return matchCore(str, sindex, pindex + 2, pattern) ||
                        matchCore(str, sindex + 1, pindex + 2, pattern) ||
                        matchCore(str, sindex + 1, pindex, pattern);
            } else {
                return matchCore(str, sindex, pindex + 2, pattern);
            }
        }
        if (sindex < str.length && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
            return matchCore(str, sindex + 1, pindex + 1, pattern);
        return false;
    }

}
