package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.Arrays;
import java.util.Stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 *
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 *
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 * */
public class Demo003_reverseStack {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] target = reverseStack(arr,arr.length);
        System.out.println(Arrays.toString(target));
       /* getBottom(arr,arr.length);
        System.out.println(Arrays.toString(arr));*/

       System.out.println("-----------------------");
       Stack<Integer> stack = new Stack<>();
       stack.push(1);
       stack.push(2);
       stack.push(3);
        System.out.print("最初的栈：");
        printStack(stack);
       reverseStack(stack);
        System.out.println("翻转之后的栈：");
        printStack(stack);

    }

    public static int[] reverseStack(int[] A, int n) {
        // write code here
        if(n <= 0){
            return null;
        }
        int last = getBottom(A,n);
       // A[n-1] = last;
        reverseStack(A,--n);
        A[n++] = last;
        return A;
    }

    public static int getBottom(int[] stack,int top){
        int res = stack[--top];
        if(top <= 0){
            return res;
        }else{
            int last = getBottom(stack,top);
            stack[top-1] = res;
            return last;
        }
    }

    public static void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int last = getBottomWithStack(stack);
        reverseStack(stack);
        stack.push(last);
    }

    public static int getBottomWithStack(Stack<Integer> stack){
        int res = stack.pop();
        if(stack.isEmpty()){
            return res;
        }else{
            int last = getBottomWithStack(stack);
            stack.push(res);
            return last;
        }
    }

    public static void printStack(Stack<Integer> stack){
        int[] res = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            res[index++] = stack.peek();
            System.out.print(stack.pop());
        }
        while(index>0){
            stack.push(res[--index]);
        }
        System.out.println();
    }
}
