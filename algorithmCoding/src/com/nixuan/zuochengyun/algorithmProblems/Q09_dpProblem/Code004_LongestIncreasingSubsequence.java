package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 *
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 *
 * 测试样例：
 * [1,4,2,5,3],5
 * 返回：3
 *
 * 思路：dp + 二分法
 * 上升子序列：不能有相等的
 */
public class Code004_LongestIncreasingSubsequence {

    public static void main(String[] args) {
       int[] arr = {395,132,276,31,612,103,209,105,214,541,454,87,600,385,345,393,45,154,70,101,468,496,253,181,162,605,425,588,74,261,155,58,549,378,535,217,213,35,564,204,193,301,78,470,140,566,315,162,471,80,451,208,402,80,224,375,279,567,272,39,495,622,256,396,452,141,344,586,310,506,348,481,388,599,412,105,75,338,71,149,19,317,23,8,592,452,624,395,412,12,303,207,491,466,238,94,538,478,163,624,308,271,18,417,209,83,18,113,169,521,539,242,36,180,429,360,203,164,580,198,98,119,157,249,609,93,323,592,105,573,243,132,25,208,505,141,454,83,199,279,464,96,285,239,24,299,484,562,410,285,421,280,63,288,502,503,55,615,395,115,560,218,165,224,536,556,201,573,167,248,541,539,35,112,56,326,138,362,91,14,531,539,291,497,570,171,615,318,586,354,462,31,199,297,589,86,257,618,591,59,532,199,302,195,587,51,87,504,62,403,513,33,86,166,576,51,201,254,343,422,388,604,305,511,388,403,564,534,466,423,42,92,146,435,613,92,239,455,614,332,176,218,60,432,584,205,323,170,320};
       //int[] arr = {1,4,2,5,3,9,6,7,3,6,6,6,7,4,5,3,1};
       int len = arr.length;
       int res = getLIS(arr,len);
        System.out.println(res);
        System.out.println("=====================");
        System.out.println(LIS(arr));
    }

    public static int getLIS(int[] A, int n) {
        // write code here
        if(A == null || A.length == 0){
            return 0;
        }
        int[] dp = new int[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(count == 0 || dp[count-1] < A[i]){
                dp[count++] = A[i];
            }else{
                int index = BinarySort(dp,0,count-1,A[i]);
                dp[index] = A[i];
            }
        }
        int[] res = Arrays.copyOfRange(dp,0,count);
        System.out.println(Arrays.toString(res));
        return count;
    }

    public static int BinarySort(int[] arr,int start,int end,int target){
        if(arr[start] > target){
            return 0;
        }
        if(target > arr[end]){
            return end + 1;
        }
        while(start <= end){
            int mid = ((end - start)>>1)+start;
            if(target < arr[mid+1] && target > arr[mid]){
                return mid+1;
            }
            if(target > arr[mid]){
                start = mid + 1;
            }else if(target < arr[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int LIS(int[] arr){
        if(arr == null){
            return 0;
        }
        int len = arr.length;
        int[] dp = new int[len];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        res.add(list);
        dp[0] = 1;
        for(int i = 1; i < len; i++){
            ArrayList<Integer> list1 = new ArrayList<>();
            int count = -1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[i] < dp[j]+1){
                        dp[i] = dp[j] + 1;
                        count = j;
                }
            }
            if(count != -1){
                list1.addAll(res.get(count));
            }else{
                dp[i] = 1;
            }
            list1.add(arr[i]);
            res.add(list1);
        }
        int index = 0;
        int leng = 0;
        for(int i=0;i<len;i++){
            if(dp[i] > leng){
                leng = dp[i];
                index = i;
            }
        }
        System.out.println(res.get(index));
        return leng;
    }
}
