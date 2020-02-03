package com.gsy.codinginterview.question14;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author gongshiyun
 * @date 2020/2/3
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 0;
        for (; p1 != null; i++) {
            if (i >= k) {
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return i < k ? null : p2;
    }
}
