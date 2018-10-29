package com.nixuan.leetCode.LeetCode101_200;

import com.nixuan.leetCode.TreeNode;
import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 22:02
 **/
public class LeetCode0109_有序链表转换二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while( fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        TreeNode root = new TreeNode(slow.val);
        if(head.next == null){
            return root;
        }
        ListNode cur = head;
        while(cur != null && cur.next != slow){
            cur = cur.next;
        }
        if(cur != null){
            cur.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(newHead);
        return root;
    }
}
