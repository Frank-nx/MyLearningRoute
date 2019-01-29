package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/29 17:10
 **/
public class LeetCode0395_至少有k个重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "aaabb";
        System.out.println(longestSubstring(s,2));
    }

    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() < k || k < 1){
            return 0;
        }
        int id_max = 0;
        int i = 0;
        int res = 0;
        int n = s.length();
        while(i+k <= n){
            int[] help = new int[32];
            int mask = 0;
            id_max = i;
            for (int j = i;j < n;j++){
                int index = s.charAt(j) - 'a';
                help[index]++;
                if (help[index] < k){
                    mask |= 1<<index;
                }else{
                    mask &= (~(1<<index));
                }
                if (mask == 0){
                    res = Math.max(res,j-i+1);
                    id_max = j;
                }
            }
            i = id_max + 1;
        }
        return res;
    }

}
