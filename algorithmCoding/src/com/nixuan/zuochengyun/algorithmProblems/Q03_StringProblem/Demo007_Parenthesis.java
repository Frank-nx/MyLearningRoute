package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

/**
 *对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 */
public class Demo007_Parenthesis {

    public boolean chkParenthesis(String A, int n) {
        // write code here
        if(A == null){
            return true;
        }
        int num = 0;
        for(int i = 0;i<n;i++){
            if(A.charAt(i) == '('){
                num++;
            }else if(A.charAt(i) == ')'){
                num--;
            }
            if(num<0){
                return false;
            }
        }
        return num == 0;
    }
}
