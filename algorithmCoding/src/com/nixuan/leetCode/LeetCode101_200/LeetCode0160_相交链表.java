package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 *
 * Intersected at '10': [1,3,5,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]
 * [10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]
 * @author: nixuan
 * @create: 2018-11-07 15:06
 **/
public class LeetCode0160_相交链表 {

    public static void main(String[] args) {
        int[] a = {1,3,5,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int[] b = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        ListNode headA = ListNode.buildList(a);
        ListNode headB = ListNode.buildList(b);
        ListNode res = getIntersectionNode(headA,headB);
        ListNode.printList(res);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int lenA = 0;
        while(a != null){
            lenA++;
            a = a.next;
        }
        int lenB = 0;
        while(b != null){
            lenB++;
            b = b.next;
        }
        a = headA;
        b = headB;
        while(lenA > lenB){
            a = a.next;
            lenA--;
        }
        while(lenB > lenA){
            b = b.next;
            lenB--;
        }
        while(a != null && b != null && a != b){
            a = a.next;
            b = b.next;
        }
        return a == b ? a : null;
    }

}
