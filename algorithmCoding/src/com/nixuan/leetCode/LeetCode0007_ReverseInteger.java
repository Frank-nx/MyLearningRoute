package com.nixuan.leetCode;

public class LeetCode0007_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1100));
    }

    public static int reverse(int x){
        long result = 0;
        while(x!=0){
            int mod = x%10;
            result = result*10+mod;
            if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)
                result = 0;
            x = x/10;
        }
        return (int) result;
    }

    public static int reverse_2(int x) {
        if(x == 0)
            return 0;
        StringBuffer sb = new StringBuffer();
        if(x<0)
            sb.append("-");
        while(x!=0){
            sb.append(Math.abs(x%10));
            x = x/10;
        }
        long result = Long.parseLong(sb.toString());
        if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE)
            result = 0;
        return (int)result;
    }
}
