package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-06 18:34
 **/
public class LeetCode0138_复制带随机指针的链表 {

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        head.random = node3;
        node2.random = node5;
        node4.random = node2;
        copyRandomList(head);
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode temp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = temp;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode pHead = head.next;
        RandomListNode p = pHead;
        while(p.next != null){
            cur.next = p.next;
            p.next = cur.next.next;
            cur = cur.next;
            p = p.next;
        }
        cur.next = null;
        return pHead;
    }


      //Definition for singly-linked list with a random pointer.
    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

}
