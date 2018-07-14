package com.nixuan.leetCode;

public class LeetCode0013_RomanToInteger {

    /*
    * Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
    * */
    public int romanToInt(String s) {
        if(s == null || s.length()<1)
            return 0;
        int result = 0;
        for(int i=0;i<s.length()-1;i++){
            int num = tranfer(s.charAt(i));
            if(num<tranfer(s.charAt(i+1)))
                result -= num;
            else
                result += num;
        }
        return result+tranfer(s.charAt(s.length()-1));
    }

    public int tranfer(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}
