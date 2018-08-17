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
        // 设置小于目标值的头结点lessHead和大于目标值的头结点moreHead
        ListNode lessHead = null;
        ListNode moreHead = null;
        // 找到小于目标值的头结点lessHead和大于目标值的头结点moreHead
        while(cur != null){
            if(lessHead == null && cur.val <= val){
                lessHead = cur;
            }
            if(moreHead == null && cur.val > val){
                moreHead = cur;
            }
            if(lessHead !=null && moreHead != null){
                break;
            }
            cur = cur.next;
        }
        // 这里要对lessHead和moreHead进行判断，不然后面直接用会出现空指针异常
        if(lessHead == null){
            return moreHead;
        }
        if(moreHead == null){
            return lessHead;
        }
        cur = head;
        ListNode less = lessHead;
        ListNode more = moreHead;
        while(cur!=null){
            if(cur != lessHead && cur.val <= val){
                less.next = cur;
                less = cur;
            }
            if(cur != moreHead && cur.val > val){
                more.next = cur;
                more = cur;
            }
            cur = cur.next;
        }
        // 这里要将大于的尾指针指向null，防止more指令为头结点时出现一个环
        more.next = null;
        less.next = moreHead;

        return lessHead;
    }
}
