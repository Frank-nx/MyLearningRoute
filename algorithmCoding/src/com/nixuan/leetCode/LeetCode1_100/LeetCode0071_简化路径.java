package com.nixuan.leetCode.LeetCode1_100;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 15:23
 **/
public class LeetCode0071_简化路径 {

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        if(path == null || path.length() < 1 || path.equals("/")){
            return path;
        }
        String[] parts = path.split("/");
        LinkedList<String> res = new LinkedList<>();
        for (int i = 0; i < parts.length; i++) {
            if(parts[i].equals("") || parts[i].equals(".")){
                continue;
            }else if(parts[i].equals("..")){
                if(!res.isEmpty()){
                    res.removeLast();
                }
            }else{
                res.add(parts[i]);
            }
        }
        if(res.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!res.isEmpty()){
            sb.append("/" + res.removeFirst());
        }
        return sb.toString();
    }
}
