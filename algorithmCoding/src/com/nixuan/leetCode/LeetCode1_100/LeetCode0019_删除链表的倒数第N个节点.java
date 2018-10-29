package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 10:03
 **/
public class LeetCode0019_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return head;
        }
        ListNode front = head;
        ListNode back = head;
        while(n > 0){
            front = front.next;
            n--;
        }
        if(front == null){
            return head.next;
        }
        while(front.next != null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
}
