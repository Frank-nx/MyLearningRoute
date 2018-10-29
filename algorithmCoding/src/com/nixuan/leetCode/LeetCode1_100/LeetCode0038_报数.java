package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 13:45
 **/
public class LeetCode0038_报数 {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String res = "1";
        while(--n > 0){
            int count = 1;
            int temp = res.charAt(0);
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < res.length(); i++) {
                if(temp != res.charAt(i)){
                    sb.append(count);
                    sb.append(temp-'0');
                    count = 1;
                    temp = res.charAt(i);
                }else{
                    count++;
                }
            }
            sb.append(count);
            sb.append(temp-'0');
            res = sb.toString();
        }
        return res;
    }
}
