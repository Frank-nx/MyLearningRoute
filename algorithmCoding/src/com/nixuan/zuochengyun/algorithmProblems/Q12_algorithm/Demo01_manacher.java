package com.nixuan.zuochengyun.algorithmProblems.Q12_algorithm;

import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description: manacher算法
 * @author: nixuan
 * @create: 2018-09-24 21:14
 **/
public class Demo01_manacher {

    public static void main(String[] args) {
        String str = "abcdcbafabcdck";
        //String str = "acbbcbds";
        System.out.println(manacher(str));
    }

    public static char[] manacherString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append("#");
            sb.append(str.charAt(i));
        }
        sb.append("#");
        System.out.println(sb);
        return sb.toString().toCharArray();
    }

    public static int manacher(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] radius = new int[charArr.length];
        int R = -1;
        int c = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < radius.length; i++) {
            // R > i时第一种情况，否则是第二种情况
            radius[i] = R > i ? Math.min(radius[2*c-i],R-i+1):1;
            // 不管是什么情况，都往外扩，是第一种情况时，会扩到不能扩为止
            // 第二种情况的1、2会直接跳出
            // 第二种情况的3也会扩到不能扩为止
            while(i+radius[i] < charArr.length && i - radius[i] > -1){
                if(charArr[i-radius[i]] == charArr[i+radius[i]]){
                    radius[i]++;
                }else{
                    break;
                }
            }
            if(i + radius[i] > R){
                R = i + radius[i]-1;
                c = i;
            }
            max = Math.max(max,radius[i]);
        }
        System.out.println(Arrays.toString(radius));
        return max-1;
    }

}
