package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/29 18:03
 **/
public class LeetCode0396_旋转函数 {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 1){
            return 0;
        }
        int factSum = 0;
        int sum = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            factSum += i * A[i];
            sum += A[i];
        }
        int res = factSum;
        for (int i = 1; i < len; i++) {
            factSum = factSum - sum + len * A[i-1];
            res = Math.max(res,factSum);
        }
        return res;
    }
}
