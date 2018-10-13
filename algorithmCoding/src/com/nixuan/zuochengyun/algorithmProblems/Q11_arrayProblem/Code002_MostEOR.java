package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MyLearningRoute
 * @description:
 * 定义数组的异或和的概念：
 * 数组中所有的数异或起来， 得到的结果叫做数组的异或和，
 * 比如数组{3,2,1}的异或和是， 3^2^1 = 0
 * 给定一个数组arr， 你可以任意把arr分成很多不相容的子数组， 你的目的是：
 * 分出来的子数组中， 异或和为0的子数组最多。
 * 请返回： 分出来的子数组中， 异或和为0的子数组最多是多少？
 * @author: nixuan
 * @create: 2018-10-10 15:19
 **/
public class Code002_MostEOR {

    public static void main(String[] args) {
        int[] arr = {0,4,3,2,1,0,8};
        int res = mostEOR(arr);
        System.out.println(res);
    }

    public static int mostEOR(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int[] most = new int[arr.length];
        int eor = 0;
        for(int i = 0; i < arr.length; i++){
            eor ^= arr[i];
            if(map.containsKey(eor)){
                int value = map.get(eor);
                most[i] = value == -1 ? 1 : most[value]+1;
            }
            if(i > 0){
                most[i] = Math.max(most[i-1],most[i]);
            }
            map.put(eor,i);
        }
        return most[arr.length-1];
    }
}
