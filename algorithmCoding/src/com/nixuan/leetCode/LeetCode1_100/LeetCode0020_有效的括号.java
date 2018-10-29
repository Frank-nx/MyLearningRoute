package com.nixuan.leetCode.LeetCode1_100;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-25 10:11
 **/
public class LeetCode0020_有效的括号 {

    public boolean isValid(String s) {
        if(s == null || s.length() < 1){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(')');
            }else if(s.charAt(i) == '{'){
                stack.push('}');
            }else if(s.charAt(i) == '['){
                stack.push(']');
            }else if(!stack.isEmpty() && s.charAt(i) == stack.peek()){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}
