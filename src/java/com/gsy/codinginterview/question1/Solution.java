package com.gsy.codinginterview.question1;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 *
 * @author gongshiyun
 * @date 2020/1/26
 */
public class Solution {

    public static void main(String[] args) {
        int[][] array = {
                {1,2,8,9},
                {2,4,9,2},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(Find(1, array));
    }

    public static boolean Find(int target, int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;

        for (int i = rowCount - 1, j = 0; i >= 0 && j < colCount;) {
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] < target) {
                j++;
                continue;
            }
            if (array[i][j] > target) {
                i--;
            }
        }
        return false;
    }
}
