package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 *
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 *
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 */

public class Demo002_listDivide {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);

        ListNode newHead = listDivide1(head,3);
        ListNode.printList(newHead);
    }

    public ListNode listDivide(ListNode head, int val) {
        // write code here
        if(head == null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            if(cur.val <= val){
                list.add(cur.val);
            }
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(cur.val > val){
                list.add(cur.val);
            }
            cur = cur.next;
        }
        ListNode pHead = new ListNode(list.get(0));
        cur = pHead;
        for(int i = 1;i < list.size(); i++){
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return pHead;
    }

    public static ListNode listDivide1(ListNode head, int val) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode lessHead = null;

        ListNode moreHead = null;

        while(cur != null){
            if(cur.val <= val){
                lessHead = cur;
                break;
            }
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(cur.val > val){
                moreHead = cur;
                break;
            }
            cur = cur.next;
        }
        cur = head;
        ListNode less = lessHead;
        ListNode more = moreHead;
        while(cur!=null){
            if(less != cur && cur.val <= val){
                less.next = cur;
                less = cur;
            }
            if(more != cur && cur.val > val){
                more.next = cur;
                more = cur;
            }
            cur = cur.next;
        }
        less.next = moreHead;
        return lessHead;
    }
}
