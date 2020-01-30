package com.gsy.codinginterview.question9;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author gongshiyun
 * @date 2020/1/30
 */
public class Solution {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            throw new IllegalArgumentException();
        }
        return 1 << (target - 1);
    }
}
