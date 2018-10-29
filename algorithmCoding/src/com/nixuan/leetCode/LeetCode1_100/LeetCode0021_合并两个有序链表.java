package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 10:18
 **/
public class LeetCode0021_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val >= l2.val){
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
}
