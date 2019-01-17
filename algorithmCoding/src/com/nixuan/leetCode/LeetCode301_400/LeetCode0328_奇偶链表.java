package com.nixuan.leetCode.LeetCode301_400;

import com.nixuan.util.ListNode;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/14 10:55
 **/
public class LeetCode0328_奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }
        ListNode oddNode = head;
        ListNode evenHead = head.next;
        ListNode evenNode = evenHead;
        ListNode cur = head.next.next;
        for(int i = 3;cur != null;i++){
            if ((i&1)==1){
                oddNode.next = cur;
                oddNode = oddNode.next;
            }else{
                evenNode.next = cur;
                evenNode = evenNode.next;
            }
            cur = cur.next;
        }
        oddNode.next = evenHead;
        evenNode.next = null;
        return head;
    }
}
