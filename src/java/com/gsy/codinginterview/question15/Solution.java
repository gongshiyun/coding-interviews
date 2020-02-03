package com.gsy.codinginterview.question15;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author gongshiyun
 * @date 2020/2/3
 */
public class Solution {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode r = ReverseList(a);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        ListNode temp;
        ListNode before = null;
        while (true) {
            temp = p.next;
            p.next = before;
            before = p;
            if (temp == null) {
                break;
            }
            p = temp;
        }
        return p;
    }
}
