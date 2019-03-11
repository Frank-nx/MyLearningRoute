package com.nixuan.leetCode.LeetCode401_500;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/10 10:20
 **/
public class LeetCode0415_字符串相加 {

    public static void main(String[] args) {
        String num1 = "92357895412";
        String num2 = "145623154452";
        String res = addStrings(num1,num2);
        System.out.println(res);
    }

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() < 1){
            return num2;
        }
        if (num2 == null || num2.length() < 1){
            return num1;
        }
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int base = 0;

        StringBuffer sb = new StringBuffer();
        while(index1 >= 0 && index2 >= 0){
            int sum = num1.charAt(index1--) + num2.charAt(index2--) + base - '0' - '0';
            base = sum / 10;
            sb.append((char) (sum % 10 + '0'));
        }
        while(index1 >= 0){
            int sum = num1.charAt(index1--) + base - '0';
            base = sum / 10;
            sb.append((char) (sum % 10 + '0'));
        }
        while(index2 >= 0){
            int sum = num2.charAt(index2--) + base - '0';
            base = sum / 10;
            sb.append((char) (sum % 10 + '0'));
        }
        if (base != 0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

}
