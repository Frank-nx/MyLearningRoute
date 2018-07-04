package com.nixuan.leetCode;

public class LeetCode0008_StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String str) {
        if(str == null||str.trim().length()<1)
            return 0;
        long result = 0;
        String newStr = str.trim();
        int index = 0;
        int sign = 1;
        if(newStr.charAt(index) == '-'){
            sign = -1;
            index++;
        }else if(newStr.charAt(index) == '+')
            index++;
        while(index<newStr.length()){
            int num = newStr.charAt(index++) - '0';
            if(num>=0&&num<=9){
                if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10))
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                result = result*10+num;
               /* if(result*sign>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if(result*sign<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;*/
            }else{
                break;
            }
        }
        return (int)(result*sign);
    }
}
