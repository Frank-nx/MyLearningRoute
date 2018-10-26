package com.nixuan.leetCode;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 11:19
 **/
public class LeetCode0024_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode root = new ListNode(-1);
        ListNode pre = root;
        ListNode cur = head;
        ListNode last = head.next;
        while(last.next != null && last.next.next != null){
            cur.next = last.next;
            last.next = cur;
            pre.next = last;
            last = cur.next.next;
            pre = cur;
            cur = cur.next;
        }
        cur.next = last.next;
        last.next = cur;
        pre.next = last;
        return root.next;
    }
}
