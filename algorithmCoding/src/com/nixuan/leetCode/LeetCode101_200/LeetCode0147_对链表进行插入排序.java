package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-06 20:06
 **/
public class LeetCode0147_对链表进行插入排序 {

    public static void main(String[] args) {
        int[] arr = {6,5,3,1,8,7,2,4};
        ListNode head = ListNode.buildList(arr);
        ListNode newhead = insertionSortList1(head);
        ListNode.printList(newhead);
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        ListNode tail = head;
        while(cur != null){
            if(cur.val <= head.val){
                tail.next = cur.next;
                cur.next = head;
                head = cur;
                cur = tail.next;
                continue;
            }
            ListNode p = head;
            while(p.next != cur && p.next.val < cur.val){
                p = p.next;
            }
            if(p.next == cur){
                tail = cur;
                cur = cur.next;
            }else{
                tail.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = tail.next;
            }
        }
        return head;
    }

    public static ListNode insertionSortList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode cur = head.next;
        ListNode tail = head;
        while(cur != null){
            ListNode p = start;
            while(p.next != cur && p.next.val < cur.val){
                p = p.next;
            }
            if(p.next == cur){
                tail = cur;
                cur = cur.next;
            }else{
                tail.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = tail.next;
            }
        }
        return start.next;
    }
}
