package com.nixuan.leetCode.LeetCode301_400;

import com.nixuan.util.TimeMeasureUtil;
import com.nixuan.util.interfaces.TimeMeasure;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/11 17:50
 **/
public class LeetCode0324_摆动排序2 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 1, 1, 6, 4};
        TimeMeasureUtil.getTimeResult(new TimeMeasure() {
            @Override
            public void measureMethod() {
                wiggleSort(arr);
            }
        });
        System.out.println(Arrays.toString(arr));
    }


    public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2){
            return;
        }
        int median = getMedian(nums,0,nums.length-1,nums.length/2);
        int len = nums.length;
        int more = 0;
        int less = len-1;
        int cur = 0;
        while(cur <= less){
            if (nums[newIndex(cur,len)] > median){
                swap(nums,newIndex(cur++,len),newIndex(more++,len));
            }else if (nums[newIndex(cur,len)] < median){
                swap(nums,newIndex(cur,len),newIndex(less--,len));
            }else{
                cur++;
            }
        }
    }

    private static int newIndex(int i, int n){
        int newIndex = (1+2*i)%(n|1);
       // System.out.println("oldIndex:" + i + ",newIndex:" + newIndex);
        return newIndex;
    }

    private static int getMedian(int[] nums, int left, int right, int index) {
        int mid = partition(nums,left,right);
        if (mid == index){
            return nums[mid];
        }else if (mid > index){
            return getMedian(nums,left,mid-1,index);
        }
        return getMedian(nums,mid+1,right,index);
    }

    private static int partition(int[] nums, int left, int right) {
        int key = nums[left];
        while(left < right){
            while(left < right && nums[right] <= key){
                right--;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] >= key){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        return left;
    }

    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}
