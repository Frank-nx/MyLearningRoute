package com.nixuan.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-15 16:53
 **/
public class FindDifferent {

    public static void main(String[] args) {
        int[] arr = {1,6,3,6,8,1,4};
        int[] res = findDifferent(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findDifferent(int[] arr){
        if(arr == null || arr.length < 3){
            return arr;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue() == 1 && index < 2){
                res[index++] = entry.getKey();
            }
        }
        return res;
    }
}
