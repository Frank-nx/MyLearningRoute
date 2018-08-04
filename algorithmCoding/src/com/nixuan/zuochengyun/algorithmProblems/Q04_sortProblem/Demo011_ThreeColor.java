package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;


/**
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 * 测试样例：
 * [0,1,1,0,2,2],6
 * 返回：[0,0,1,1,2,2]
 */
public class Demo011_ThreeColor {

    public int[] sortThreeColor(int[] A, int n) {
        // write code here
        if(A == null || A.length <= 1){
            return A;
        }
        int less = -1;
        int more = n;
        int target = 1;
        int index = 0;
        while(index<more){
            if(A[index] == target){
                index++;
            }else if(A[index] < target){
                swap(A,++less,index++);
            }else{
                swap(A,--more,index);
            }
        }
        return A;
    }

    private void swap(int[] a, int i, int index) {
        int temp = a[i];
        a[i] = a[index];
        a[index] = temp;
    }
}
