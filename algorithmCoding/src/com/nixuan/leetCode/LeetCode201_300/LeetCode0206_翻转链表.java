package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 15:50
 **/
public class LeetCode0206_翻转链表 {

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseListRec(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
