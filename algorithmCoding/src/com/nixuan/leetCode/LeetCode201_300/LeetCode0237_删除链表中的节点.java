package com.nixuan.leetCode.LeetCode201_300;

import com.nixuan.util.ListNode;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-16 18:44
 **/
public class LeetCode0237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = node.next.next;
    }

}
