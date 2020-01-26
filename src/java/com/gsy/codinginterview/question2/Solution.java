package com.gsy.codinginterview.question2;

import java.util.Objects;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author gongshiyun
 * @date 2020/1/26
 */
public class Solution {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy.");
        System.out.println(replaceString(str));
    }

    public static String replaceString(StringBuffer str) {
        if (str == null) {
            throw new NullPointerException();
        }
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
                i += 3;
            } else {
                i++;
            }
        }

        return str.toString();
    }
}
