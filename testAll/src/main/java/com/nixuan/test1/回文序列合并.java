package com.nixuan.test1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-13 19:41
 **/
public class 回文序列合并 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len;i++){
            arr[i] = sc.nextInt();
        }
        int res = huiwenMerge(arr);
        System.out.println(res);
    }

    public static int huiwenMerge(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while(left < right){
            if(arr[left] < arr[right]){
                arr[++left] = arr[left - 1] + arr[left];
                // left++;
                res++;
            }else if(arr[left] == arr[right]){
                left++;
                right--;
            }else{
                arr[--right] = arr[right] + arr[right + 1];
                //  right--;
                res++;
            }
        }
        return res;
    }

    /*public static boolean isValid(List<Integer> list){
        if(list.size() == 1){
            return true;
        }
        int len = list.size() - 1;
        int end = list.size() >> 1;
        for(int i = 0;i < end;i++){
            if(list.get(i) != list.get(len-i)){
                return false;
            }
        }
        return true;
    }

    public static int process(LinkedList<Integer> list,int left,int res){
        int leftNum = list.remove(left);
        int rightNum = list.remove(left);
        list.add(left,leftNum+rightNum);
        if(isValid(list)){
            res = Math.max(res,list.size());
            return res;
        }
        for(int i = 0;left+i<list.size()-1;i++){
            res = Math.max(res,process(list,left+i,res));
            list.remove(left);
            list.add(left,rightNum);
            list.add(left,leftNum);
        }
        return res;
    }*/
}
