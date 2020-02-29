/**
 * 46. 把数字翻译成字符串
 * <p>
 * 题目描述
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class NumDecoding {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s == "0"){
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                int temp = Integer.parseInt(s.substring(i - 2, i));
                if (temp >= 10 && temp <= 26) {
                    dp[i] += dp[i - 2];
                }
            }

        }
        return dp[s.length()];

    }


}
