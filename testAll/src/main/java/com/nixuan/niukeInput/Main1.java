package com.nixuan.niukeInput;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        if(len < 3){
            System.out.println("0");
        }
        for (int i=0; i < len; i++){
            arr[i] = sc.nextInt();
        }


    }
}
