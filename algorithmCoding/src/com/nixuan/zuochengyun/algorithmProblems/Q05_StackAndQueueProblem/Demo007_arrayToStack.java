package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description: 用数组实现栈
 * @author: nixuan
 * @create: 2018-09-15 16:32
 **/
public class Demo007_arrayToStack {

    int[] arr;
    int top = 0;

    public Demo007_arrayToStack(int n){
        arr = new int[n];
    }

    public int pop(){
        if(top <= 0){
            throw new RuntimeException("The stack is empty!");
        }
        return arr[--top];
    }

    public int peak(){
        if(top <= 0){
            throw new RuntimeException("The stack is empty!");
        }
        return arr[top-1];
    }

    public void push(int n){
        if(top >= arr.length){
            throw new RuntimeException("The stack is full!");
        }
        arr[top++] = n;
    }

    public void print(){
        if(arr == null){
            return;
        }
        int[] res = Arrays.copyOfRange(arr,0,top);
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        Demo007_arrayToStack stack = new Demo007_arrayToStack(5);
        stack.push(1);
        stack.push(5);
        stack.push(7);
        stack.print();
        System.out.println(stack.peak());
        stack.print();
        System.out.println(stack.pop());
        stack.print();
    }
}
