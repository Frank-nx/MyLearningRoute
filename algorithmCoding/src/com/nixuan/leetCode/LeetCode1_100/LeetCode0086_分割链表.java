package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 22:45
 **/
public class LeetCode0086_分割链表 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode less = null;
        ListNode more = null;
        ListNode cur = head;
        while(cur != null &&(less == null || more == null)){
            if(less == null && cur.val < x){
                less = cur;
            }else if(more == null && cur.val >= x){
                more = cur;
            }
            cur = cur.next;
        }
        if(less == null || more == null){
            return head;
        }
        cur = head;
        ListNode small = less;
        ListNode big = more;
        while(cur != null){
            if(cur != less && cur.val < x){
                small.next = cur;
                small = cur;
            }else if(cur != more && cur.val >= x){
                big.next = cur;
                big = cur;
            }
            cur = cur.next;
        }
        small.next = more;
        big.next = null;
        return less;
    }
}
