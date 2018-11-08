package com.nixuan.leetCode.LeetCode101_200;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 14:54
 **/
public class LeetCode0155_最小栈 {

    Stack<Integer> stack;
    Stack<Integer> min;

    public LeetCode0155_最小栈() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek() >= x){
            min.push(x);
        }else{
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
