package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 16:08
 **/
public class LeetCode0165_比较版本号 {

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1";
        int res = compareVersion(version1,version2);
        System.out.println(res);
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = 0;
        int len2 = 0;
        while(len1 < arr1.length && len2 < arr2.length){
            int diff = Integer.parseInt(arr1[len1++]) - Integer.parseInt(arr2[len2++]);
            if(diff > 0){
                return 1;
            }
            if(diff < 0){
                return -1;
            }
        }
        while(len1 < arr1.length){
            if(Integer.parseInt(arr1[len1++]) != 0){
                return 1;
            }
        }
        while(len2 < arr2.length){
            if(Integer.parseInt(arr2[len2++]) != 0){
                return -1;
            }
        }
        return 0;
    }
}
