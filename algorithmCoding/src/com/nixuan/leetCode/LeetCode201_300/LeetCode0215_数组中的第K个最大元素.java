package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-09 14:36
 **/
public class LeetCode0215_数组中的第K个最大元素 {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr,2));
    }

    public static int findKthLargest(int[] nums, int k) {
        return findKth(nums,0,nums.length-1,k);
    }

    public static int findKth(int[] nums, int left, int right, int k){
        int key = getMedian0fMedianArray(nums,left,right);
        int[] res = partition(nums,left,right,key);
        System.out.println(res[0] + "  "+ res[1]) ;
        if(k > res[1]){
            findKth(nums,left,res[1],k);
        }else if(k < res[0]){
            findKth(nums,res[0],right,k);
        }else{
            return nums[res[0]];
        }
        return -1;
    }

    public static int[] partition(int[] nums, int left, int right, int key){
        int more = left - 1;
        int less = right + 1;
        while(left < less){
            if(nums[left] > key){
                swap(nums,++more,left++);
            }else if(nums[left] == key){
                left++;
            }else{
                swap(nums,more,--less);
            }
        }
        return new int[]{more+1,less-1};
    }

    public static int getMedian0fMedianArray(int[] nums, int left, int right){
        int[] median = divide(nums,left,right);
        if(median.length == 1){
            return median[0];
        }
        return getMedian0fMedianArray(median,0,median.length-1);
    }

    public static int[] divide(int[] nums, int left, int right){
        int len = right - left + 1;
        int offset = len%5 == 0 ? 0 : 1;
        int[] median = new int[len/5 + offset];
        for (int i = left; i <= right; i = i+5) {
            int end = i+4>right?right:i+4;
            insertSort(nums,i,end);
            median[i/5] = nums[((end-i)>>1)+i];
        }
        return median;
    }

    public static void insertSort(int[] nums, int left, int right){
        for (int i = left+1; i <= right; i++) {
            for (int j = i; j >left ; j--) {
                if(nums[j] < nums[j-1]){
                    swap(nums,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
