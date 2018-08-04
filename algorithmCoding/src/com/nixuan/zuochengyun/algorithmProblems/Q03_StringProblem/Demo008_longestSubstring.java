package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

import java.util.HashMap;
import java.util.Map;

/**
 *对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 *
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 *
 * 测试样例：
 * "aabcb",5
 * 返回：3
 */
public class Demo008_longestSubstring {

    public int longestSubstring(String A, int n) {
        // write code here
        if(A == null){
            return 0;
        }
        int res = 0;
        int pre = -1;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int index = map.get(A.charAt(i)) == null?-1:map.get(A.charAt(i));
            int length = Math.min(i - pre,i - index);
            res = Math.max(res,length);
            pre = Math.max(pre,index);
            map.put(A.charAt(i),i);
        }
        return res;
    }
}
