package com.gsy.codinginterview.question20;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author gongshiyun
 * @date 2020/9/20
 */
public class Solution {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        data.push(node);
        if (min.empty()) {
            min.push(node);
        } else {
            if (node < min.peek()) {
                min.push(node);
            } else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
