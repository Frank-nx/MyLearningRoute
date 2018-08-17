package com.nixuan.zuochengyun.algorithmProblems.Q02_listProblem;

import com.nixuan.util.ListNode;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 *
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 */

public class Demo004_KInverse {

    public static void main(String[] args) {
        int[] arr = {0,1,2,5,11};
        ListNode oldHead = ListNode.buildList(arr);
        ListNode.printList(oldHead);
        ListNode newHead = inverse(oldHead,2);
        ListNode.printList(newHead);
    }

    public static ListNode inverse(ListNode head, int k) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode[] temp = inverseKList(head,k);
        ListNode newHead = temp[0];
        while(temp[1] != null){
            ListNode[] nodes = inverseKList(temp[1].next,k);
            // 如果刚好是K的整数倍，则最后nodes会返回null，如果是null要直接退出
            if (nodes != null){
                temp[1].next = nodes[0];
                temp = nodes;
            }else{
                break;
            }
        }
        return newHead;
    }

    public static ListNode[] inverseKList(ListNode node, int k){
        if (node == null){
            return null;
        }
        int count = 0;
        ListNode pre = null;
        ListNode cur = node;
        // 查看node节点及之后是否有k个节点
        while(cur != null && count < k){
            count++;
            cur = cur.next;
        }
        cur = node;
        // 如果有k个节点就进行k个节点的反转
        if(count >= k){
            count = 0;
            while(cur != null && count < k){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                count++;
            }
            // 将反转之后的尾节点与剩下链表的头结点连起来，保证链表不会断开
            node.next = cur;
            // 返回一个数组，pre为反转之后的头结点，node为反转之后的尾节点
            return new ListNode[]{pre,node};
        }
        // 不足k个数不进行反转，直接返回头结点
        return new ListNode[]{node,null};
    }
}
