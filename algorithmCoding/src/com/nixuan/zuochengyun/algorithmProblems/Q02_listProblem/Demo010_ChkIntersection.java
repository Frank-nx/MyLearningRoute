package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

/**
 *如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，
 * 不想交的话返回空。如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 *
 * 给定两个链表的头结点head1和head2
 * (注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
 * 请返回一个bool值代表它们是否相交。
 */
public class Demo010_ChkIntersection {

    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // write code here
        ListNode node1 = chkLoop(head1);
        ListNode node2 = chkLoop(head2);
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
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
