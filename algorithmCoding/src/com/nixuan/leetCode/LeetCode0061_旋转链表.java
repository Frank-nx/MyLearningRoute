package com.nixuan.leetCode;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 13:30
 **/
public class LeetCode0061_旋转链表 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.buildList(arr);
        ListNode.printList(rotateRight(head,5));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k < 1){
            return head;
        }
        ListNode position = head;
        int count = 0;
        while(position != null && count < k){
            position = position.next;
            count++;
        }
        if(position == null){
            k = k % count;
            if(k == 0){
                return head;
            }
            position = head;
            count = 0;
            while(count++ < k){
                position = position.next;
            }
        }
        ListNode cur = head;
        while(position.next != null){
            cur = cur.next;
            position = position.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        position.next = head;
        return newHead;
    }
}
