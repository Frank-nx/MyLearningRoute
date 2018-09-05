package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

import java.util.Arrays;

// 重复值判断，空间复杂度为O(1)
/**
 *请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 *
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 *
 * 测试样例：
 * [1,2,3,4,5,5,6],7
 * 返回：true
 *
 */
public class Demo009_checkDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,8,6,3,4,7,9};
        checkDuplicate(arr,arr.length);
    }

    public static boolean checkDuplicate(int[] a, int n) {
        // write code here
        if(a == null || a.length <= 1){
            return false;
        }
        for(int i = n/2 - 1;i>=0;i--){
            adjust(a,i,n);
        }
        for(int i = n - 1;i>0;i--){
            swap(a,0,i);
            adjust(a,0,i);
        }
        System.out.println(Arrays.toString(a));
        for(int i=0;i<n-1;i++){
            if(a[i] == a[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void adjust(int[] a, int k, int n){
        int temp = a[k];
        for(int i = 2*k+1;i<n;i=2*i+1){
            if(i+1<n&&a[i]<a[i+1]){
                i++;
            }
            if(temp<a[i]){
                a[k] = a[i];
                k = i;
            }else{
                break;
            }
        }
        a[k] = temp;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
