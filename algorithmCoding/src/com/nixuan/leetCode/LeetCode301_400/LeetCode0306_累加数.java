package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/12/11 11:37
 **/
public class LeetCode0306_累加数 {

    public static void main(String[] args) {
        String str = "199100199";
        System.out.println(isAdditiveNumber(str));
    }

    public static boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3){
            return false;
        }
        for (int i = 1; i <= num.length()/2 ; i++) {
            for (int j = 1; j <= num.length()/2; j++) {
                if(check(num.substring(0,i),num.substring(i,i+j),num.substring(i+j))){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(String s1,String s2,String sum){
        if(s1.length() > 1 && s1.charAt(0) == '0' || s2.length() > 1 && s2.charAt(0) == '0' || s1.length() > sum.length() || s2.length() > sum.length()){
            return false;
        }
        String res = add(s1,s2);
        System.out.println(s1 + "+" + s2 + "=" + res);
        if(res.equals(sum)){
            return true;
        }
        if(res.length() >= sum.length() || !res.equals(sum.substring(0,res.length()))){
            return false;
        }
        return check(s2,sum.substring(0,res.length()),sum.substring(res.length()));

    }

    public static String add(String s1, String s2){
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int n1 = s1.length()-1;
        int n2 = s2.length()-1;
        while(n1 >=0 || n2 >=0){
            int num = (n1 >= 0?s1.charAt(n1--)-'0':0)+(n2>=0?s2.charAt(n2--)-'0':0)+carry;
            sb.append(num%10);
            carry=num/10;
        }
        if(carry==1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
