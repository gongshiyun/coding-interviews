package com.gsy.codinginterview.question13;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author gongshiyun
 * @date 2020/2/2
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static void reOrderArray(int [] array) {
        int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        int index = 0;
        for (int i : result) {
            if ((i & 1) == 1) {
                array[index++] = i;
            }
        }
        for (int i : result) {
            if ((i & 1) == 0) {
                array[index++] = i;
            }
        }
    }
}
