package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;


import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * */
public class Demo001_minStack {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(min.isEmpty() || node < min.peek()){
            min.push(node);
        }else{
            min.push(min.peek());
        }
    }

    public int pop() {
        if(data.isEmpty()){
            throw new RuntimeException("the stack is empty!");
        }

        int res = data.pop();
        min.pop();
        return res;
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
