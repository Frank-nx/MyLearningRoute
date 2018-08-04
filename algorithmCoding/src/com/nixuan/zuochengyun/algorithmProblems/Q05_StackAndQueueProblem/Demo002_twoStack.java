package com.nixuan.zuochengyun.algorithmProblems.Q05_StackAndQueueProblem;

import java.util.Stack;

/**
 *编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 *
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 *
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 */
public class Demo002_twoStack {

    public int[] twoStack(int[] ope, int n) {
        // write code here
        Stack<Integer> data = new Stack<>();
        Stack<Integer> help = new Stack<>();
        int len = 0;
        for(int i = 0; i < n; i++){
            if(ope[i]  == 0){
                len++;
            }
        }
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < n; i++){
            if(ope[i] != 0){
                push(data,help,ope[i]);
            }else{
                res[index++] = pop(data,help);
            }
        }
        return res;
    }

    public int pop(Stack<Integer> data, Stack<Integer> help){
        if(help.isEmpty()){
            while(!data.isEmpty()){
                help.push(data.pop());
            }
        }
        return help.pop();
    }

    public void push(Stack<Integer> data, Stack<Integer> help,int node){
        data.push(node);
    }
}
