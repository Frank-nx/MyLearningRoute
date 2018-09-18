package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: MyLearningRoute
 * @description: 用两个队列实现栈
 * @author: nixuan
 * @create: 2018-09-16 07:25
 **/
public class Demo009_twoQueueToStack {

    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> help = new LinkedList<>();

    public void push(int n){
        queue.add(n);
    }

    public int pop(){
        if(queue.isEmpty()){
            throw new RuntimeException("the stack is empty！");
        }
        while(queue.size() > 1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    public int peak(){
        if(queue.isEmpty()){
            throw new RuntimeException("the stack is empty！");
        }
        while(queue.size() > 1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
    }



    public static void main(String[] args) {
        Demo009_twoQueueToStack stack = new Demo009_twoQueueToStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peak());
        System.out.println(stack.pop());
        System.out.println(stack.peak());
    }
}
