package com.nixuan.leetCode.LeetCode301_400;

import com.nixuan.util.ListNode;

import java.util.List;
import java.util.Random;

/**
 * @Description 蓄水池采样算法
 * @Author nixuan_sx
 * @Date 2019/1/22 10:54
 **/
public class LeetCode0382_链表随机节点 {

    ListNode head;
    Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LeetCode0382_链表随机节点(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        ListNode cur = head.next;
        int pool = head.val;
        while(cur != null){
            int temp = random.nextInt(++count);
            if (temp == 0){
                pool = cur.val;
            }
            cur = cur.next;
        }
        return pool;
    }

}
