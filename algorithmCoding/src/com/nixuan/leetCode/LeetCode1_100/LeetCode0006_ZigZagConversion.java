package com.nixuan.leetCode.LeetCode1_100;

public class LeetCode0006_ZigZagConversion {
//PINALSIGYAHRPI
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }

    public static String convert(String s, int numRows) {
        if(s == null || s.length() < 1 || numRows < 2 || s.length() <= numRows)
            return s;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<numRows&&i<s.length();i++){
            for(int j=0;j+i<s.length();j+=2*numRows-2){
                if(i==0||i==numRows-1){
                    sb.append(s.charAt(i+j));
                }else if((j+2*(numRows-1-i)+i)<s.length()){
                    sb.append(s.charAt(i+j));
                    sb.append(s.charAt(j+2*(numRows-1-i)+i));
                }else
                    sb.append(s.charAt(i+j));
            }
        }
        return sb.toString();
    }
}

