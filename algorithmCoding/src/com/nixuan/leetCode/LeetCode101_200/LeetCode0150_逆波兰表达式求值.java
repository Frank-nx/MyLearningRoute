package com.nixuan.leetCode.LeetCode101_200;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-07 12:22
 **/
public class LeetCode0150_逆波兰表达式求值 {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length < 1){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            switch(tokens[i]){
                case "+":stack.push(stack.pop()+stack.pop());break;
                case "-":
                    int p = stack.pop();
                    stack.push(stack.pop() - p);break;
                case "*":stack.push(stack.pop() * stack.pop());break;
                case "/":
                    int temp = stack.pop();
                    stack.push(stack.pop() / temp);break;
                default:stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
