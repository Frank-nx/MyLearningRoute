package com.nixuan.niukeInput;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        for (int i=0; i < 8; i++){
            arr[i+2] = sc.nextInt();
        }
       /* Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr1 = input.split(",");
        int[] arr = new int[10];
        arr[0] = Integer.parseInt(arr1[0]);
        arr[1] = Integer.parseInt(arr1[1]);
        String input1 = sc.nextLine();
        String[] param = input1.split(",");
        for (int i = 0;i < param.length; i++){
            arr[i+2] = Integer.parseInt(param[i]);
        }*/
        int min = Integer.MAX_VALUE;
        String res = "yes";
        int a = 0;
        int b = 0;
        if(arr[2] == arr[4] && arr[5] == arr[7] && arr[6] == arr[8] && arr[9] == arr[3] ){
            if(arr[0] < arr[2]){
                a = arr[2]-arr[0];
               // min = Math.min(arr[2]-arr[0],min);
                res = "no";
            }
            if(arr[0] > arr[8]){
                a = arr[0]-arr[8];
               // min = Math.min(arr[0]-arr[8],min);
                res = "no";
            }
            if(arr[1] > arr[5]){
                b = arr[1]-arr[5];
                int temp = (int)Math.round(Math.sqrt(a*a+b*b));
                min = Math.min(temp,min);
                res = "no";
            }
            if(arr[1] < arr[3]){
                b = arr[3]-arr[1];
                int temp = (int)Math.round(Math.sqrt(a*a+b*b));
                min = Math.min(temp,min);
                res="no";
            }
            if(min == Integer.MAX_VALUE){
                min = 0;
            }
            System.out.println(res +","+min);
        }else{
            System.out.println("yes,0");
        }

    }
}
