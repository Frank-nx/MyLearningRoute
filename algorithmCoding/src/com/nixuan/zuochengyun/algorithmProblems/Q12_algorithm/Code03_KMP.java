package com.nixuan.zuochengyun.algorithmProblems.Q12_algorithm;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * 两个字符串str1，str2，求str2是否是str1的子串，如果是，返回第一个子串的第一个字母在str1中的索引。
 *
 * 例如：str1 = "ababcababtk";str2 = "ababtk";则返回5。
 * @author: nixuan
 * @create: 2018-10-23 21:33
 **/
public class Code03_KMP {

    public static void main(String[] args) {
        String str1 = "ababcababtk";
        String str2 = "ababtk";
        int[] next = getNext(str2);
        int res = KMP(str1,str2,next);
        System.out.println(res);
    }

    public static int KMP(String str1,String str2,int[] next){
        if(str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()){
            return -1;
        }
        char[] strArr1 = str1.toCharArray();
        char[] strArr2 = str2.toCharArray();
        int p1 = 0;
        int p2 = 0;
        while(p1 < strArr1.length && p2 < strArr2.length){
            // 情况1，strArr1[p1] == strArr2[p2] ，则p1和p2都往后移一位
            if(strArr1[p1] == strArr2[p2]){
                p1++;
                p2++;
            // 情况3，str1[p1] != str2[p2]且p2==0，p2不移动，p1向后移动一位
            }else if(p2 == 0){
                p1++;
            // 情况2，str1[p1] != str2[p2]且p2!=0，则p2 = next[p2]，p1不动。
            }else{
                p2 = next[p2];
            }
        }
        return p2 == strArr2.length ? p1-p2:-1;
    }

    public static int[] getNext(String str){
        // 如果str长度为1，直接返回只含-1的数组
        if(str.length() == 1){
            return new int[]{-1};
        }
        int[] next = new int[str.length()];
        char[] str2 = str.toCharArray();
        // 首先将人为设定最长相等前缀的值填好
        next[0] = -1;
        next[1] = 0;
        int n = 2;
        // m代表i前面一个字符的最长相等前缀的长度，最开始i=2,next[i-1] = 0,所以n的初始值是0；
        int m = 0;
        while(n < next.length){
             // 这是情况一，str[n-1] = str[m],此时next[n] = m+1
            if(str2[m] == str2[n-1]){
                next[n++] = ++m;
             // 这是情况二，str[n-1] != str[m],此时，m = next[m],再次比较
            }else if(m > 0){
                m = next[m];
                // 当m=0时,则next[n] = 0;
            }else{
                next[n++] = 0;
            }
        }
        return next;
    }
}
