package com.nixuan.leetCode;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 22:18
 **/
public class LeetCode0082_删除排序链表中的重复元素2 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode cur = head;
        ListNode pre = pHead;
        while(cur != null){
            int temp = cur.val;
            if (cur.next != null && cur.next.val == temp){
                while(cur.next != null && cur.next.val == temp){
                    cur = cur.next;
                }
                cur = cur.next;
                pre.next = cur;
            }else{
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }
        return pHead.next;
    }
}
