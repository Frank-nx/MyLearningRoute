package com.nixuan.leetCode.LeetCode1_100;

public class LeetCode0012_IntegerToRoman {

    //重做
    public String intToRoman(int num) {
         int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
         String[] unin = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
         StringBuilder sb = new StringBuilder();
         for(int i=0;i<value.length;i++){
             while(num>=value[i]){
                 num -= value[i];
                 sb.append(unin[i]);
             }
         }
         return sb.toString();
    }
}
