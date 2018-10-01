package com.nixuan.test1;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description: 头条笔试
 * @author: nixuan
 * @create: 2018-09-20 19:18
 *
 * 5 5 3
 * hello help high
 * p a b h m
 * f h e c p
 * o i l l h
 * b g h o n
 * h x c m l
 **/
public class 矩阵中的路径 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] params = input.split(" ");
        int m = Integer.parseInt(params[0]);
        int n = Integer.parseInt(params[1]);
        int k = Integer.parseInt(params[2]);
        input = sc.nextLine();
        String[] target = input.split(" ");
        char[] matrix = new char[m*n];
        int index = 0;
        for(int i = 0;i<n;i++){
            input = sc.nextLine();
            String[] chars = input.split(" ");
            for(int j=0;j<m;j++){
                matrix[index++] = chars[j].charAt(0);
            }
        }
        for (int i = 0;i<target.length;i++){
            char[] str = target[i].toCharArray();
            if(hasPath(matrix,n,m,str)){
                System.out.println(target[i]);
            }
        }
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null||matrix.length<str.length)
            return false;

        boolean[] visit = new boolean[matrix.length];

        for(int curRow=0;curRow<rows;curRow++){
            for(int curCol=0;curCol<cols;curCol++)
                if(hasPathCore(matrix,rows,cols,curRow,curCol,str,0,visit))
                    return true;
        }
        return false;
    }

    public static boolean hasPathCore(char[] matrix, int rows, int cols, int curRow, int curCol,char[] str,int index,boolean[] visit){
        if(index==str.length)
            return true;
        if(curRow>=0&&curRow<rows&&curCol>=0&&curCol<cols&&matrix[curRow*cols+curCol]==str[index]&&!visit[curRow*cols+curCol]){
            visit[curRow*cols+curCol] = true;

            boolean path = hasPathCore(matrix,rows,cols,curRow+1,curCol,str,index+1,visit)||
                    hasPathCore(matrix,rows,cols,curRow-1,curCol,str,index+1,visit)||
                    hasPathCore(matrix,rows,cols,curRow,curCol+1,str,index+1,visit)||
                    hasPathCore(matrix,rows,cols,curRow,curCol-1,str,index+1,visit);
            if(!path)
                visit[curRow*cols+curCol] = false;
            return path;
        }
        return false;
    }

}
