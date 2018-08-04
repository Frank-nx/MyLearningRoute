package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 *
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 *
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class Demo004_twoStacksSort {



    public static void main(String[] args) {
        int[] numbers = {1,2,5,3,4,9,6,7,3};
        ArrayList<Integer> res = twoStacksSort(numbers);
        System.out.println(res.toString());
    }

    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> help = new Stack<>();
        int top = 0;
        while(top <numbers.length){
            if(help.isEmpty()){
                help.push(numbers[top++]);
            }
            int temp = numbers[top];
            while(!help.isEmpty()&&temp > help.peek()){
                numbers[top--] = help.pop();
            }
            help.push(temp);
            top++;
        }
        while(!help.isEmpty()){
            numbers[--top] = help.pop();
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i < numbers.length; i++){
            res.add(numbers[i]);
        }
        return res;
    }
}
