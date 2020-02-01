package com.gsy.codinginterview.question11;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author gongshiyun
 * @date 2020/2/1
 */
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
}
