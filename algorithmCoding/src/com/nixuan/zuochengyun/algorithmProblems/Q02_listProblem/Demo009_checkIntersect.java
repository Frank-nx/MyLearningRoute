package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

/**
 *现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 *
 * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。保证两个链表长度小于等于500。
 */
public class Demo009_checkIntersect {

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode headB = new ListNode(1);
        headB.next = node2;

        boolean res = chkIntersect(headA,headB);
        System.out.println(res);
    }

    public static boolean chkIntersect(ListNode headA, ListNode headB) {
        // write code here
        if(headA == null || headB == null){
            return false;
        }
        int lenA = 0;
        ListNode curA = headA;
        while(curA != null){
            lenA++;
            curA = curA.next;
        }
        int lenB = 0;
        ListNode curB = headB;
        while(curB != null){
            lenB++;
            curB = curB.next;
        }
        int diff = lenA - lenB;
        curA = headA;
        curB = headB;
        if(diff > 0){
            while(diff-- > 0){
                curA = curA.next;
            }
        }else if(diff < 0){
            while(diff++ < 0){
                curB = curB.next;
            }
        }
        while(curA != null && curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        if(curA != null){
            return true;
        }
        return false;
    }
}
