package com.nixuan.test1;

import java.util.Scanner;
import java.util.Stack;

public class 简化unix的路径 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String path = in.nextLine();

        String simplePath = "";
        Stack<String> stack = new Stack<String>();

        for(int i=0;i<path.length();i++){
            String name="";

            while(i<path.length() && path.charAt(i)=='/')
                i++;	//该操作跳过斜线'/'

            while(i<path.length() && path.charAt(i)!='/')
                name += path.charAt(i++);	//记录路径名，也包括'.'和'。。'

            if(!name.equals(".") && !name.equals("..")){
                stack.push(name);
            }
            if(!stack.isEmpty() && name.equals(".."))
                stack.pop();	//如果当前文件名为“..”，表示退到上一层目录，需弹出栈
        }
        if(stack.isEmpty())
            System.out.print("/");
        while(!stack.isEmpty()){
            simplePath = "/"+stack.peek()+simplePath;
            stack.pop();
        }
        System.out.println(simplePath);
    }
}
