package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

/**
 *如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 *
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 *
 */
public class Demo008_chkLook {

    public int chkLoop(ListNode head, int adjust) {
        // write code here
        if(head == null || head.next == null){
            return -1;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null &&slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 上面的循环不是因为slow==fast而停止的，证明没有环的存在
        if(slow != fast){
            return -1;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast.val;
    }
}
