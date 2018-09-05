package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

import java.util.Comparator;
import java.util.PriorityQueue;

// 小范围排序练习题
/**
 *
 *已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
 * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
 *
 * 给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
 *
 * 测试样例：
 * [2,1,4,3,6,5,8,7,10,9],10,2
 * 返回：[1,2,3,4,5,6,7,8,9,10]
 */
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
