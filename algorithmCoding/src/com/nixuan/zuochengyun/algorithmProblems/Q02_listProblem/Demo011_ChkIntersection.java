package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

/**
 *给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 *
 * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。请返回一个bool值代表它们是否相交。
 */
public class Demo011_ChkIntersection {

    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        if(head1 == null || head2 == null){
            return false;
        }
        ListNode node1 = chkLoop(head1);
        ListNode node2 = chkLoop(head2);
        if(node1 == null && node2 == null){
            return chkIntersect(node1,node2);
        }else if(node1 == null || node2 == null){
            return false;
        }else{
            if(node1 == node2){
                return true;
            }
            ListNode cur = node1.next;
            while(cur != node1){
                if(cur == node2){
                    return true;
                }
                cur = cur.next;
            }
            return false;
        }

    }

    public ListNode chkLoop(ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null &&slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow != fast){
            return null;
        }
        fast = head;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public boolean chkIntersect(ListNode headA, ListNode headB) {
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
