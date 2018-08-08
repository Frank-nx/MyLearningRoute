package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;


import com.nixuan.util.ListNode;

/**
 *请编写一个函数，检查链表是否为回文。
 *
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 *
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 */
public class Demo006_palindromeList {

    public static void main(String[] args) {
        int[] arr = {4,7,1,6,1,4,2,6,9,6,3,8,7,5,2,8,1,7,8,5,6,8,9,6,3,3,5,1,7,8,5,6,5,7,1,4,8,3,9,3,3,7,7,7,3,1,3,8,3,4,1,8,8,2,8,4,6,0,2,1,3,1,2,0,6,4,8,2,8,8,1,4,3,8,3,1,3,7,7,7,3,3,9,3,8,4,1,7,5,6,5,8,7,1,5,3,3,6,9,8,6,5,8,7,1,8,2,5,7,8,3,6,9,6,2,4,1,6,1,7,4};
        ListNode pHead = ListNode.buildList(arr);
        boolean res = isPalindrome(pHead);
        System.out.println(res);
    }

    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        if(pHead == null || pHead.next == null){
            return true;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        ListNode start1 = pHead;
        ListNode start2 = pre;
        while(start1 != null && start2 != null){
            if(start1.val != start2.val){
                return false;
            }
            start1 = start1.next;
            start2 = start2.next;
        }
        return true;
    }
}
