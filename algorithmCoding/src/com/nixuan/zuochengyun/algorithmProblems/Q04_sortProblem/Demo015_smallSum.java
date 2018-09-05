package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

/**
 *
 *小和问题
 * 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组的小和。
 *
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数， 没有；
 * 3左边比3小的数， 1；
 * 4左边比4小的数， 1、 3；
 * 2左边比2小的数， 1；
 * 5左边比5小的数， 1、 3、 4、 2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 */
public class Demo015_smallSum {

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(smallSum(arr));
    }

    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        return smallSum(arr,0,arr.length - 1);
    }

    private static int smallSum(int[] arr, int left, int right) {
        if(left >= right){
            return 0;
        }
        int mid = ((right-left)>>1)+left;
        int leftSum = smallSum(arr,left,mid);
        int rightSum = smallSum(arr,mid+1,right);
        int count = merge(arr,left,mid,right);
        System.out.println("left:" + leftSum + "count:" + count + "right:" + rightSum);
        return leftSum+rightSum+count;
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[right-left+1];
        int index = 0;
        int sum = 0;
        int low = left;
        int high = mid+1;
        while(low<=mid&&high<=right){
            if(arr[low]<arr[high]){
                helper[index++] = arr[low++];
                sum = sum + arr[low - 1] * (right - high + 1);
            }else{
                helper[index++] = arr[high++];
            }
        }
        while(low<=mid){
            helper[index++] = arr[low++];
        }
        while(high<=right){
            helper[index++] = arr[high++];
        }
        for(int i=0;i<index;i++){
            arr[left+i] = helper[i];
        }
        return sum;
    }
}
