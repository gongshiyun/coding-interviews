package com.gsy.codinginterview.question12;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * @author gongshiyun
 * @date 2020/2/2
 */
public class Solution {
    public double Power(double base, int exponent) {
        if (base == 0 && exponent == 0) {
            throw new RuntimeException();
        }
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == -1) {
            return 1 / base;
        }
        return Power(base, exponent / 2) * Power(base, exponent / 2)
                * Power(base, exponent % 2);
    }
}
