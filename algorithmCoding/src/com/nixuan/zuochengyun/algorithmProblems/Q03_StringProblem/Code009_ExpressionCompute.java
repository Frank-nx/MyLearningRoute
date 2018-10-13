package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * 给定一个字符串str， str表示一个公式， 公式里可能有整数、 加减乘除符号和
 * 左右括号， 返回公式的计算结果。
 * 【举例】
 * str="48*((70-65)-43)+8*1"， 返回-1816。
 * str="3+1*4"， 返回7。 str="3+(1*4)"， 返回7。
 * 【说明】
 * 1． 可以认为给定的字符串一定是正确的公式， 即不需要对str做公式有效性检
 * 查。
 * 2． 如果是负数， 就需要用括号括起来， 比如"4*(-3)"。 但如果负数作为公式的
 * 开头或括号部分的开头， 则可以没有括号， 比如"-3*4"和"(-3*4)"都是合法的。
 * 3． 不用考虑计算过程中会发生溢出的情况
 * @author: nixuan
 * @create: 2018-10-10 16:12
 **/
public class Code009_ExpressionCompute {

   /* public static int expressionCompute(String s){
        if(s == null || s.length() < 1){
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] res = expressionComputeCore(arr,0);
        return res[0];
    }

    private static int[] expressionComputeCore(char[] arr, int start) {
        Stack<String> stack = new Stack<>();
        int pre = 0;
        while(start < arr.length && arr[start] != ')'){
            if (arr[start] >= '0' && arr[start] <= '9'){
                pre = pre * 10 + arr[start++] - '0';
            }else if(arr[start] != '('){
                addNum(stack,pre);
            }
        }
    }

    private static void addNum(Stack<String> stack, int pre) {
    }

    private static class Pair{
        int result;
        int index;
    }*/
}
