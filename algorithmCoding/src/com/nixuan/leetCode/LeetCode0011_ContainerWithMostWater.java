package com.nixuan.leetCode;

public class LeetCode0011_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        if(height == null||height.length < 2){
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
            int area = Math.min(height[left],height[right])*(right-left);
            maxArea = Math.max(maxArea,area);
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }

}
