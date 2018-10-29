package com.nixuan.leetCode.LeetCode1_100;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-26 17:15
 **/
public class LeetCode0043_字符串相乘 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1,num2));
    }

    public static String multiply(String num1, String num2) {
        if(num1 == null || num1.length() < 1 || num2 == null ||
                num2.length() < 1 || num1.equals("0") || num2.equals("0")){
                    return "0";
        }
        String res = "";
        for (int i = num2.length()-1; i >= 0; i--) {
            String temp = mutiplyOne(num1,num2.charAt(i)+"");
            res = plus(res,temp,num2.length() - 1 - i);
        }
        return res;
    }

    private static String plus(String res, String temp, int i) {
        while(i-->0){
            temp = temp + "0";
        }
        int l1 = res.length()-1;
        int l2 = temp.length()-1;
        int base = 0;
        StringBuffer sb = new StringBuffer();
        while(l1 >= 0 && l2 >= 0){
            int sum = res.charAt(l1--) + temp.charAt(l2--) - 2*'0' + base;
            sb.append(sum%10);
            base = sum / 10;
        }
        while(l1 >= 0){
            int sum = res.charAt(l1--) - '0' + base;
            sb.append(sum%10);
            base = sum / 10;
        }
        while(l2 >= 0){
            int sum = temp.charAt(l2--) - '0' + base;
            sb.append(sum%10);
            base = sum / 10;
        }
        if(base != 0){
            sb.append(base);
        }
        return sb.reverse().toString();
    }

    private static String mutiplyOne(String num1, String s) {
        StringBuffer sb = new StringBuffer();
        int base = 0;
        int num = Integer.parseInt(s);
        for (int i = num1.length()-1; i >=0; i--) {
            int sum = (num1.charAt(i)-'0') * num + base;
            sb.append(sum%10);
            base = sum /10;
        }
        if(base != 0){
            sb.append(base);
        }
        return sb.reverse().toString();
    }
}
