package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description: 用数组实现队列
 * @author: nixuan
 * @create: 2018-09-15 21:54
 **/
public class Demo008_arrayToQueue {

    int[] arr;
    int head = 0;
    int tail = 0;
    int size = 0;

    public Demo008_arrayToQueue(int n){
        arr = new int[n];
    }

    public void add(int n){
        if(size >= arr.length){
            throw new RuntimeException("The queue is full!");
        }
        size++;
        arr[head++] = n;
        head = head == arr.length?0:head;
    }

    public int remove(){
        if(size == 0){
            throw new RuntimeException("The queue is empty!");
        }
        size--;
        int res = arr[tail++];
        tail = tail == arr.length?0:tail;
        return res;
    }

    public void print(){
        if(arr == null){
            return;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("head" + head);
        System.out.println("tail" + tail);
    }

    public static void main(String[] args) {
        Demo008_arrayToQueue queue = new Demo008_arrayToQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();
        queue.add(4);
        queue.add(5);
        queue.remove();
        queue.print();
        queue.add(6);
        queue.print();

    }
}
