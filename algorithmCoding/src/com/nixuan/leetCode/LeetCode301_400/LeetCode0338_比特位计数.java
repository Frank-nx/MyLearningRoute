package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/17 9:41
 **/
public class LeetCode0338_比特位计数 {

    public int[] countBits(int num) {
        if (num < 0){
            return null;
        }
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int n = i;
            while(n != 0){
                n = (n-1)&n;
                res[i]++;
            }
        }
        return res;
    }

    // 方法二：
    public int[] countBits2(int num) {
        if (num < 0){
            return null;
        }
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[(i-1)&i] + 1;
        }
        return res;
    }

}
