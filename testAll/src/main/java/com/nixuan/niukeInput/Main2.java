package com.nixuan.niukeInput;

import java.util.Scanner;
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int[][] matrix = new int[row][3];
        for (int i = 0; i < row; i++) {
            for(int j=0;j<3;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
    }

}
