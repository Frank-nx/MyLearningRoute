package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;


/**
 *有一个整形数组A，请设计一个复杂度为O(n)的算法，算出排序后相邻两数的最大差值。
 * 给定一个int数组A和A的大小n，请返回最大的差值。保证数组元素多于1个。
 * 测试样例：
 * [1,2,5,4,6],5
 * 返回：2
 */
public class Demo014_maxGap {

    public static void main(String[] args) {
        int[] arr = {3429,6401,8559,1052,4775,6220,3593,2406,4995};
        System.out.println(maxGap(arr,arr.length));
    }

    public static int maxGap(int[] A, int n) {
        // write code here
        if(A == null || A.length <= 1){
            return 0;
        }
        int max = A[0];
        int min = A[0];
        for(int i = 1;i < n;i++){
            max = Math.max(max,A[i]);
            min = Math.min(min,A[i]);
        }
        int[] bucket = new int[n+1];
        int[] maxNum = new int[n+1];
        int[] minNum = new int[n+1];
        for(int i = 0; i < n; i++){
            // 求桶号的时候，要注意转化
            int index = (int)((float)(A[i] - min)/(max - min)*n);
            bucket[index]++;
            if(bucket[index] == 1){
                maxNum[index] = A[i];
                minNum[index] = A[i];
            }else{
                maxNum[index] = Math.max(maxNum[index],A[i]);
                minNum[index] = Math.min(minNum[index],A[i]);
            }
        }
        int res = 0;
        int preMax = maxNum[0];
        for(int i = 1;i < n+1;i++){
            while(i< n+1&&bucket[i]==0){
                i++;
            }
            res = Math.max(res,minNum[i] - preMax);
            preMax = maxNum[i];
        }
        return res;
    }

}
