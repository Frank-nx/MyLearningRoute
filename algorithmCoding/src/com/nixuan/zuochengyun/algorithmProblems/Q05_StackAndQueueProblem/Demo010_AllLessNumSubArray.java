package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.LinkedList;

/**
 * @program: MyLearningRoute
 * @description:
 * 最大值减去最小值小于或等于num的子数组数量
 * 【题目】
 * 给定数组arr和整数num， 共返回有多少个子数组满足如下情况：
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * max(arr[i..j])表示子数组arr[i..j]中的最大值， min(arr[i..j])表
 * 示子数组arr[i..j]中的最小值。
 * 【要求】
 * 如果数组长度为N， 请实现时间复杂度为O(N)的解法。
 * @author: nixuan
 * @create: 2018-09-26 16:30
 **/
public class Demo010_AllLessNumSubArray {

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3,4,2,6,7,9,4,234,546,34,76,4};
        int res = allLessNumSubArray(arr,2);
        int standard = getNum(arr,2);
        System.out.println(res);
        System.out.println(standard);
    }

    public static int allLessNumSubArray(int[] arr,int num){
        if(arr == null ||arr.length < 1){
            return 0;
        }
        int res = 0;
        int cur = 0;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int len = arr.length;
        for(int i = 0;i<arr.length;i++){
            while(cur<len){
                while(!maxQueue.isEmpty()&&cur<len &&arr[maxQueue.peekFirst()] <= arr[cur]){
                    maxQueue.pollFirst();
                }
                maxQueue.addFirst(cur);
                while(!minQueue.isEmpty()&&cur<len&&arr[minQueue.peekFirst()] >= arr[cur]){
                    minQueue.pollFirst();
                }
                minQueue.addFirst(cur);
                if(maxQueue.peekLast() < i){
                    maxQueue.pollLast();
                }
                if(minQueue.peekLast() < i){
                    minQueue.pollLast();
                }
                if (arr[maxQueue.peekLast()]-arr[minQueue.peekLast()] > num){
                    break;
                }
                cur++;
            }
            res += cur - i;
        }
        return res;
    }

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += j - i;
            i++;
        }
        return res;
    }
}
