package com.nixuan.zuochengyun.algorithmProblems.Q07_bitProblem;


/**
 *
 * 给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 *
 * 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 *
 * 测试样例：
 * [1,2,4,4,2,1,3,5],8
 * 返回：[3,5]
 * */
public class Demo003_findOdds {

    public static void main(String[] args) {
        int[] arr = {3,5,4,3,4,8};
        int[] res = findOdds(arr,6);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

    public static int[] findOdds(int[] arr, int n) {
        // write code here
        if(arr == null){
            throw new RuntimeException("The Array is empty!");
        }
        int res = 0;
        for (int i:arr) {
            res = res ^ i;
        }
        int count = 1;
        while((count&res) == 0){
            count = count << 1;
        }
        int res1 = 0;
        for(int i:arr){
            if((count&i) != 0){
                res1 = res1 ^ i;
            }
        }
        int res2 = res ^ res1;
        return new int[]{Math.min(res1,res2),Math.max(res1,res2)};
    }
}
