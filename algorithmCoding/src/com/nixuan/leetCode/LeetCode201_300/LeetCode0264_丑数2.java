package com.nixuan.leetCode.LeetCode201_300;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/11/21 17:07
 **/
public class LeetCode0264_丑数2 {

    public int nthUglyNumber(int n) {
        if(n <= 0){
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        int mul2 = 0;
        int mul3 = 0;
        int mul5 = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.min(res[mul2]*2,res[mul3]*3);
            temp = Math.min(temp,res[mul5]*5);
            if(temp /res[mul2] == 2){
                mul2++;
            }
            if(temp / res[mul3] == 3){
                mul3++;
            }
            if(temp / res[mul5] == 5){
                mul5++;
            }
            res[i] = temp;
        }
        return res[res.length-1];
    }

}
