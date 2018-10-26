package com.nixuan.niukeInput;

import java.util.Scanner;
public class Main2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        process(arr,"",0);
    }

    public static void process(int[] arr,String res,int time){
        if(time == 3){
            System.out.println(res);
            return;
        //   return res;
        }
        for(int i = 0; i < arr.length;i++){
            process(arr,res+arr[i],time+1);
        }
       // return res;
    }

}
