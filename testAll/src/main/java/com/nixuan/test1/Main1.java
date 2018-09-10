package com.nixuan.test1;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        if(len <= 0 ){
            System.out.println(0);
            return;
        }
        int[][] matrix = new int[len][len];
        for (int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        if(matrix == null && matrix.length <1){
            System.out.println(0);
            return;
        }
        int res = 0;
        for(int i = 0;i<len;i++){
            for(int j=0;j<len;j++){
                if(matrix[i][j] == 1){
                    res++;
                    infect(matrix,i,j,len);
                }
            }
        }
        System.out.println(res);
    }

    private static void infect(int[][] matrix, int i, int j,int len) {
        if(i > 0 && matrix[i-1][j]==1){
            matrix[i-1][j] = 0;
            infect(matrix,i-1,j,len);
        }
        if(i < len-1&&matrix[i+1][j]==1){
            matrix[i+1][j] = 0;
            infect(matrix,i+1,j,len);
        }
        if(j>0&&matrix[i][j-1]==1){
            matrix[i][j-1] = 0;
            infect(matrix,i,j-1,len);
        }
        if(j<len-1&&matrix[i][j+1]==1){
            matrix[i][j+1]=0;
            infect(matrix,i,j+1,len);
        }
    }

}
