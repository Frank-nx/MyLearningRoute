package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-15 22:24
 **/
public class LeetCode0234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        fast = newHead;
        ListNode pre = null;
        while(fast != null){
            ListNode temp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = temp;
        }
        fast = head;
        ListNode cur = pre;
        while(pre != null){
            if(fast.val != pre.val){
                return false;
            }
            fast = fast.next;
            pre = pre.next;
        }
        while(cur != null){
            ListNode temp = cur.next;
            cur.next =pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre;
        return true;
    }

}
