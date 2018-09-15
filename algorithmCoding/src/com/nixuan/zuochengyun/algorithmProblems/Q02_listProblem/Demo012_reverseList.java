package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description: 翻转单链表
 * @author: nixuan
 * @create: 2018-09-14 23:00
 **/
public class Demo012_reverseList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = ListNode.buildList(arr);
        ListNode head1 = ListNode.buildList(arr);
        ListNode.printList(head);
        ListNode newHead = reverseList(head);
        ListNode.printList(newHead);
        ListNode.printList(head1);
        ListNode newHead1 = reverseListRec(head1);
        ListNode.printList(newHead1);
    }

    public static ListNode reverseList(ListNode head){
        if(head == null){
            return null;
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

    public static ListNode reverseListRec(ListNode head){
        if(head == null){
            return null;
        }
        ListNode node = reverseListRec(head,head.next);
        head.next = null;
        return node;
    }

    private static ListNode reverseListRec(ListNode head, ListNode next) {
        if(next == null){
            return head;
        }
        ListNode res = reverseListRec(next,next.next);
        next.next = head;
        return res;
    }
}
