package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

import java.util.Comparator;
import java.util.PriorityQueue;

// 小范围排序练习题
public class Demo008_sortElement {

    public int[] sortElement(int[] A, int n, int k){
        if(A == null || A.length <= 1){
            return A;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int min = n>k?k:n;
        int index = 0;
        for(;index<min;index++){
            heap.add(A[index]);
        }
        for(;index<n;index++){
            A[index-k] = heap.poll();
            heap.add(A[index]);
        }
        while(!heap.isEmpty()){
            A[index-min] = heap.poll();
            index++;
        }
        return A;
    }
}
