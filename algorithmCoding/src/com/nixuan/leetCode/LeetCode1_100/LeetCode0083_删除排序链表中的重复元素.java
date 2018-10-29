package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 22:37
 **/
public class LeetCode0083_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = head;
        while(cur != null){
            int temp = cur.val;
            cur = cur.next;
            while(cur != null && cur.val == temp){
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
        }
        return head;
    }
}
