package com.nixuan.test1;

import java.util.Arrays;
import java.util.LinkedList;

public class Main1 {

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = slipWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] slipWindow(int[] arr,int k){
        if(arr == null || arr.length < k || k < 1){
            return null;
        }
        LinkedList<Integer> dq = new LinkedList<>();
        int[] res = new int[arr.length - k + 1];
        for (int i = 0; i < arr.length; i++) {
            while(!dq.isEmpty()&&arr[i]>=arr[dq.peekFirst()]){
                dq.pollFirst();
            }
            dq.addFirst(i);
            if(i-k >= dq.peekLast()){
                dq.pollLast();
            }
            if(i >= k - 1){
                res[i-k+1] = arr[dq.peekLast()];
            }
        }
        return res;
    }
}
