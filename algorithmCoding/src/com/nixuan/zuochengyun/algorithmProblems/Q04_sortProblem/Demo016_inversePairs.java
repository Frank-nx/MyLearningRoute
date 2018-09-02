package com.nixuan.zuochengyun.algorithmProblems.Q04_sortProblem;

/***
 *
 * 逆序对问题
 * 在一个数组中， 左边的数如果比右边的数大， 则折两个数构成一个逆序对， 请打印所有逆序
 * 对。
 */
public class Demo016_inversePairs {

    public static void main(String[] args) {
        int[] arr = {6,2,4,8,1};
        int count = inverPairs(arr);
        System.out.println(count);
    }

    public static int inverPairs(int[] arr){
        if(arr == null || arr.length<1){
            return 0;
        }
        return inversePairs(arr,0,arr.length-1);
    }

    private static int inversePairs(int[] arr, int left, int right) {
        if(left >= right){
            return 0;
        }
        int mid = ((right-left)>>1)+left;
        int leftNum = inversePairs(arr,left,mid);
        int rightNum = inversePairs(arr,mid + 1,right);
        int count = merge(arr,left,mid,right);

        return leftNum + rightNum + count;

    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[right- left +1];
        int lEnd = mid;
        int rEnd = right;
        int index = right - left;
        int count = 0;
        while(lEnd >=left && rEnd >= mid + 1){
            if(arr[lEnd] > arr[rEnd]){

                count = count + rEnd - mid;
                for (int i = rEnd;i>mid;i--){
                    System.out.println("["+ arr[lEnd] + "," + arr[i] +"]");
                }
                helper[index--] = arr[lEnd--];
            }else{
                helper[index--] = arr[rEnd--];
            }
        }
        while(lEnd>=left){
            helper[index--] = arr[lEnd--];
        }
        while(rEnd>=mid+1){
            helper[index--] = arr[rEnd--];
        }
        for(int i = 0;i<right-left +1;i++){
            arr[left+i] = helper[i];
        }
        return count;
    }
}
