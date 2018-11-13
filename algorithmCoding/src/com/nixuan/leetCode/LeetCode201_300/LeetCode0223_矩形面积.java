package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * -2
 * -2
 * 2
 * 2
 * 1
 * -3
 * 3
 * -1
 *
 * -1500000001
 * 0
 * -1500000000
 * 1
 * 1500000000
 * 0
 * 1500000001
 * 1
 * @author: nixuan
 * @create: 2018-11-13 17:14
 **/
public class LeetCode0223_矩形面积 {

    public static void main(String[] args) {
        System.out.println(computeArea(-1500000001,0,-1500000000,1,1500000000,0,1500000001,1));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int leftX = Math.max(A,E);
        int leftY = Math.max(B,F);
        int rightX = Math.min(C,G);
        int rightY = Math.min(D,H);
        long sum = (long)(C-A)*(D-B)+(long)(G-E)*(H-F);
        long diff = 0;
        long width = (long)rightX - leftX;
        long length = (long)rightY - leftY;
        if(width > 0 && length > 0){
            diff = width * length;
        }
        return (int)(sum - diff);
    }
}
