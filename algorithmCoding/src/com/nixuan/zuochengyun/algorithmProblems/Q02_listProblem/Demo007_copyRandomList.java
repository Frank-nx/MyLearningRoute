package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

public class Demo007_copyRandomList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head.random = node3;
        node2.random = node5;
        node4.random = node2;

        ListNode.printRandomList(head);
        ListNode newhead = clone(head);
        ListNode.printRandomList(newhead);
    }

    public static ListNode clone(ListNode pHead){
        if(pHead == null){
            return null;
        }
        copyNewNode(pHead);
        addRandom(pHead);
        return divideList(pHead);
    }

    public static void copyNewNode(ListNode head){
        ListNode cur = head;
        while(cur != null){
            ListNode newNode = new ListNode(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
    }

    public static void addRandom(ListNode head){
        ListNode cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
    }

    public static ListNode divideList(ListNode head){
        ListNode newHead = head.next;
        ListNode pre = head;
        ListNode last = newHead;
        while(pre != null){
            pre.next = last.next;
            last.next = pre.next==null?null:pre.next.next;
            pre = pre.next;
            last = last.next;
        }
        return newHead;
    }

}
