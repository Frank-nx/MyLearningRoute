package com.nixuan.zuochengyun.algorithmProblems.Q09_dpProblem;

/**
 * @program: MyLearningRoute
 * @description:
 * 字符算串法匹扩配展问题题目二
 * 【题目】
 * 给定字符串str， 其中绝对不含有字符'.'和'*'。 再给定字符串exp，
 * 其中可以含有'.'或'*'， '*'字符不能是exp的首字符， 并且任意两个
 * '*'字符不相邻。 exp中的'.'代表任何一个字符， exp中的'*'表示'*'
 * 的前一个字符可以有0个或者多个。 请写一个函数， 判断str是否能被
 * exp匹配。
 * 【举例】
 * str="abc"， exp="abc"， 返回true。
 * str="abc"， exp="a.c"， exp中单个'.'可以代表任意字符， 所以返回
 * true。
 * str="abcd"， exp=".*"。 exp中'*'的前一个字符是'.'， 所以可表示任
 * 意数量的'.'字符， 当exp是"...."时与"abcd"匹配， 返回true。
 * str=""， exp="..*"。 exp中'*'的前一个字符是'.'， 可表示任意数量
 * 的'.'字符， 但是".*"之前还有一个'.'字符， 该字符不受'*'的影响，
 * 所以str起码有一个字符才能被exp匹配。 所以返回false。
 * @author: nixuan
 * @create: 2018-10-13 15:12
 **/
public class Code010_stringMatch {

    public static void main(String[] args) {
        String str = "abc";
        String exp = "a.ce";
        String exp2 = ".*";
        boolean res1 = match(str,exp2,0,0);
        System.out.println(res1);
        System.out.println(matchDp(str,exp2));
    }

    public static boolean match(String s, String exp, int si, int ei){
        if(si == s.length() && exp.length() == ei){
            return true;
        }
        if(exp.length() == ei){
            return false;
        }
        if(ei+1==exp.length() || exp.charAt(ei+1) != '*'){
            if(si != s.length() &&(s.charAt(si) == exp.charAt(ei) || exp.charAt(ei) == '.')){
                return match(s, exp, si+1, ei+1);
            }else{
                return false;
            }
        }
        if(ei < exp.length() - 1&&exp.charAt(ei+1) == '*'){
            return match(s, exp,si,ei+2) || match(s, exp,si+1,ei);
        }
        return match(s, exp,si,ei+2);
    }

    public static boolean matchDp(String str, String exp){
        int strLen = str.length();
        int expLen = exp.length();
        boolean[][] dp = new boolean[strLen+1][expLen+1];
        dp[strLen][expLen] = true;
        for(int i = expLen - 2;i >=0;i = i+2){
            if(exp.charAt(i) == '*'){
                dp[strLen][i] = true;
            }else{
                break;
            }
        }
        if(str.charAt(strLen - 1) == exp.charAt(expLen-1) || exp.charAt(expLen - 1) == '.'){
            dp[strLen-1][expLen-1] = true;
        }
        for(int i = strLen - 1;i>=0;i--){
            for(int j = expLen-2;j>=0;j--){
                if(exp.charAt(j+1) != '*'){
                    boolean temp = str.charAt(i) == exp.charAt(j) || exp.charAt(j) == '.';
                    dp[i][j] = temp&&dp[i+1][j+1];
                }else{
                    int cur = i;
                    while(cur < strLen && (str.charAt(cur) == exp.charAt(j) || exp.charAt(j) == '.')){
                        if(dp[cur][j+2]){
                            dp[i][j] = true;
                        }
                        cur++;
                    }
                    if(!dp[i][j]){
                        dp[i][j] = dp[cur][j+2];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
