package com.xfc.basealgorithm.string;

/**
 * 反转字符串
 *
 * @author xf.chen
 * @date 2021/9/3 14:09
 * @since 1.0.0
 */
public class ReverseWord {


    public String reverseWord(String sentence) {

        final String[] strings = sentence.split(" ");
        // 反转单个单词
        String reverse = "";
        for (String string : strings) {
            final char[] chars = string.toCharArray();
            String reverseWord = "";
            for (int i = chars.length - 1; i >= 0; i--) {
                reverseWord += chars[i];
            }
            reverse += reverseWord + " ";
        }
        final char[] chars = reverse.trim().toCharArray();
        String reverseWord = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseWord += chars[i];
        }
        return reverseWord;
    }
}
