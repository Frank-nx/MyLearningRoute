package com.nixuan.niukeInput;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        System.out.println(step(10));

    }

    public static int step(int n){
        if(n == 1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        return step(n-1)+step(n-2)+step(n-3);
    }
}
