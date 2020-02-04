package com.gsy.codinginterview.question16;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author gongshiyun
 * @date 2020/2/4
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        // 比较两个链表的结点大小
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                p.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            p = p.next;
        }
        // 遍历完其中一个链表后，直接将没遍历完的链表的结点顺序放入新链表中
        while (list1 != null) {
            p.next = new ListNode(list1.val);
            p = p.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            p.next = new ListNode(list2.val);
            p = p.next;
            list2 = list2.next;
        }
        return head.next;
    }
}
