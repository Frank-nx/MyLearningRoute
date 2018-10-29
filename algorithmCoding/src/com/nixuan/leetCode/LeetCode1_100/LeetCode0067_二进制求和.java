package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 14:47
 **/
public class LeetCode0067_二进制求和 {

    public String addBinary(String a, String b) {
        if(a == null || a.length() < 1){
            return b;
        }
        if(b == null || b.length() < 1){
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int alen = a.length()-1;
        int blen = b.length()-1;
        int base = 0;
        while(alen >= 0 && blen >= 0){
            int sum = a.charAt(alen--) + b.charAt(blen--) + base - 2*'0';
            sb.append(sum%2);
            base = sum/2;
        }
        while(alen >= 0){
            int sum = a.charAt(alen--) + base - '0';
            sb.append(sum%2);
            base = sum/2;
        }
        while(blen >= 0){
            int sum = b.charAt(blen--) + base - '0';
            sb.append(sum%2);
            base = sum/2;
        }
        if(base != 0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
