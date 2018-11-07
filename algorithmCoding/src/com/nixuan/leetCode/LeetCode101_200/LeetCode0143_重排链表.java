package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-06 19:09
 **/
public class LeetCode0143_重排链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
       // head.next.next.next.next = new ListNode(5);
        reorderList(head);
        ListNode.printList(head);
    }

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        len = len>>1;
        ListNode back = head;
        while(len-- > 0){
            back = back.next;
        }
        ListNode tail = back.next;
        back.next = null;
        while(tail != null){
            ListNode temp = tail.next;
            tail.next = cur;
            cur = tail;
            tail = temp;
        }
        tail = head;
        while(tail != null && cur != null){
            back = tail.next;
            tail.next = cur;
            cur = cur.next;
            tail.next.next = back;
            tail = back;
        }
    }
}
