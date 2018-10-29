package com.nixuan.leetCode.LeetCode1_100;

public class LeetCode0002_AddTwoNumbers{

    public static void main(String[] args) {

    }

    /*
    *   Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.*/
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int count = 0;
        while(l1!=null&&l2!=null){
            int sum = l1.val + l2.val + count;
            p.next = new ListNode(sum%10);
            p = p.next;
            count = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            p.next = new ListNode((l1.val + count)%10);
            p = p.next;
            count = (l1.val + count)/10;
            l1 = l1.next;
        }
        while(l2!=null){
            p.next = new ListNode((l2.val + count)%10);
            p = p.next;
            count = (l2.val + count)/10;
            l2 = l2.next;
        }
        if(count!=0)
            p.next = new ListNode(1);
        return head.next;
    }

}