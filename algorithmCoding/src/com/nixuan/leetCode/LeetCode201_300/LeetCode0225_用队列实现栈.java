package com.nixuan.leetCode.LeetCode201_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-13 18:37
 **/
public class LeetCode0225_用队列实现栈 {

    Queue<Integer> queue;
    Queue<Integer> help;

    /** Initialize your data structure here. */
    public LeetCode0225_用队列实现栈() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(queue.size() != 1){
            help.add(queue.remove());
        }
        int res = queue.remove();
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        while(queue.size() != 1){
            help.add(queue.remove());
        }
        int res = queue.remove();
        help.add(res);
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

}
