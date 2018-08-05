package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.Arrays;
import java.util.Stack;

/**
 *对于一个没有重复元素的整数数组，请用其中元素构造一棵MaxTree，MaxTree定义为一棵二叉树，
 * 其中的节点与数组元素一一对应，同时对于MaxTree的每棵子树，它的根的元素值为子树的最大值。
 * 现有一建树方法，对于数组中的每个元素，其在树中的父亲为数组中它左边比它大的第一个数和右边比它大的第一个数中更小的一个。
 * 若两边都不存在比它大的数，那么它就是树根。请设计O(n)的算法实现这个方法。
 *
 * 给定一个无重复元素的数组A和它的大小n，请返回一个数组，其中每个元素为原数组中对应位置元素在树中的父亲节点的编号，若为根则值为-1。
 *
 * 测试样例：
 * [3,1,4,2],4
 * 返回：[2,0,-1,2]
 *
 * 思路：使用栈，先得到每个数左边第一个比它大的数，在得到右边第一个比它大的数，两者比较取较小的
 */

public class Demo006_buildMaxTree {

    public static void main(String[] args) {
        int[] arr = {36,1173,934,436};
        int[] res = buildMaxTree(arr,arr.length);
        System.out.println(Arrays.toString(res));
    }

    public static int[] buildMaxTree(int[] arr, int n) {
        // write code here
        if(arr == null){
            return null;
        }
        int len = arr.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = len - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                stack.pop();
            }
            // 当前找不到最右边的第一个大于的值的时候，即stack 为空时，直接采用左边找到比它大值的下表。
            // stack非空时，如果左边没有较大值，或者右边找到更小值，更新数组。
            if(!stack.isEmpty() && (res[i] == -1 || arr[res[i]] > arr[stack.peek()])){
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
