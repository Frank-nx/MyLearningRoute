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
        int[] arr = {4,7,1,6,1,7,4};
        ListNode pHead = ListNode.buildList(arr);
        boolean res = isPalindrome1(pHead);
        System.out.println(res);
        ListNode.printList(pHead);
    }

    public static boolean isPalindrome1(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return true;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        cur = pre;
        fast = pHead;
        while(cur != null && fast != null){
            if(cur.val != fast.val){
                return false;
            }
            cur = cur.next;
            fast = fast.next;
        }
        cur = pre;
        pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre;
        return true;
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
        // 反转后半边链表
        ListNode pre = null;
        ListNode cur = slow;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 对链表从两端到中间进行判断，看是否是回文
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
