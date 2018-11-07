package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 11:56
 **/
public class LeetCode0148_排序链表 {

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        ListNode head = ListNode.buildList(arr);
        ListNode newHead = sortList(head);
        ListNode.printList(newHead);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge(sortList(head),sortList(fast));
    }

    private static ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = merge(list1.next,list2);
            return list1;
        }else{
            list2.next = merge(list1,list2.next);
            return list2;
        }
    }
}
