package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

import java.util.Arrays;

/**
 *现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 *
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 *
 * 测试样例：
 * {1,2,3,4,5,6,7},{2,4,6,8,10}
 * 返回：[2.4.6]
 */

public class Demo003_findCommonParts {

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7};
        int[] B = {2,4,6,8,10};
        ListNode headA = ListNode.buildList(A);
        ListNode headB = ListNode.buildList(B);
        int[] res = findCommonParts(headA,headB);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int[] res = new int[500];
        int index = 0;
        while(curA != null && curB != null){
            if(curA.val == curB.val){
                res[index++] = curA.val;
                curA = curA.next;
                curB = curB.next;
            }else if(curA.val > curB.val){
                curB = curB.next;
            }else{
                curA = curA.next;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
