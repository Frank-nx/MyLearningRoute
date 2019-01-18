package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/18 9:35
 **/
public class LeetCode0345_反转字符串中的元音字母 {

    public String reverseVowels(String s) {
        if (s == null|| s.length() < 1){
            return s;
        }
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            while(left < right && !valid(Character.toLowerCase(arr[left]))){
                left++;
            }
            while(left < right && !valid(Character.toLowerCase(arr[right]))){
                right--;
            }
            swap(arr,left++,right--);
        }
        return new String(arr);
    }

    private boolean valid(char c) {
        if (c=='a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        return false;
    }

    private void swap(char[] arr,int left,int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
