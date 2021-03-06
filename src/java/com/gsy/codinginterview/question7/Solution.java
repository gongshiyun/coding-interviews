package com.gsy.codinginterview.question7;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * @author gongshiyun
 * @date 2020/1/29
 */
public class Solution {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int Fibonacci2(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 1;
        }
        int sum;
        int prev = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            sum = prev + cur;
            prev = cur;
            cur = sum;
        }
        return cur;
    }
}
