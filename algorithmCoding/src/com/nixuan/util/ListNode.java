package com.nixuan.util;

public class ListNode {

    public int val;

    public ListNode next = null;

    public ListNode random = null;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    public static ListNode buildList(int[] arr){
        if(arr == null){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i < arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printCircleList(ListNode head){
        if(head == null){
            return;
        }
        ListNode cur = head;
        while(cur!=null && cur.next!=head){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        if (cur!=null){
            System.out.println(cur.val + "-");
        }
    }

    public static void printList(ListNode head){
        if(head == null){
            return;
        }
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public static void printRandomList(ListNode head){
        if(head == null){
            return;
        }
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + "->");
            ListNode ran = cur.random;
            if (ran != null){
                System.out.print(ran.val + "->");
            }
            System.out.println("null");
            System.out.println("|");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
