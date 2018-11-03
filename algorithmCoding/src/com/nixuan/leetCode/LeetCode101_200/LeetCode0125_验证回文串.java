package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-03 22:40
 **/
public class LeetCode0125_验证回文串 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = "1P";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() < 2){
            return true;
        }
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(!((arr[left] >= 'a' && arr[left] <= 'z') ||(arr[left] >= '0' && arr[left] <= '9'))){
                left++;
            }else if (!((arr[right] >= 'a' && arr[right] <= 'z') ||(arr[right] >= '0' && arr[right] <= '9'))){
                right--;
            }else{
                if(arr[left++] != arr[right--]){
                    return false;
                }
            }
        }
        return true;
    }
}
