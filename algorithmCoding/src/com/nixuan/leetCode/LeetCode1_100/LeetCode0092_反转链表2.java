package com.nixuan.leetCode.LeetCode1_100;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 12:55
 **/
public class LeetCode0092_反转链表2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.buildList(arr);
        ListNode p = reverseBetween(head,2,4);
        ListNode.printList(p);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        int count = 1;
        ListNode pHead = new ListNode(-1);
        pHead.next = head;
        ListNode cur = head;
        ListNode left = pHead;
        while(count < m){
            count++;
            left = cur;
            cur = cur.next;
        }
        ListNode more = cur;
        ListNode pre =null;
        while(count <= n){
            count++;
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        left.next = pre;
        more.next = cur;
        return pHead.next;
    }
}
