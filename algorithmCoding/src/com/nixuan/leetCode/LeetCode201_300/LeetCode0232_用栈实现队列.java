package com.nixuan.leetCode.LeetCode201_300;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-15 22:17
 **/
public class LeetCode0232_用栈实现队列 {

    Stack<Integer> stack;
    Stack<Integer> help;

    /** Initialize your data structure here. */
    public LeetCode0232_用栈实现队列() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(help.isEmpty()){
            while(!stack.isEmpty()){
                help.push(stack.pop());
            }
        }
        return help.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(help.isEmpty()){
            while(!stack.isEmpty()){
                help.push(stack.pop());
            }
        }
        return help.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && help.isEmpty();
    }
}
