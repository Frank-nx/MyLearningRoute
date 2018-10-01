package com.nixuan.niukeInput;

import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int times = sc.nextInt();
         for(int i = 0;i<times;i++){
             int m = sc.nextInt();
             if(m <= 0){
                 System.out.println("yes");
                 return;
             }
             int n = sc.nextInt();
             int[] disk = new int[n];
             for(int j=0;j<n;j++){
                 disk[j] = sc.nextInt(16);
             }
             process(disk);
         }
    }

    private static void process(int[] disk) {
        if(disk == null){
            System.out.println("no");
            return;
        }
        int tail = disk.length;
        for(int i=0;i<tail;i++){
            if(disk[i] == 0){
                swap(disk,i,--tail);
            }
        }
        if(tail < 1){
            System.out.println("no");
            return;
        }
        int[] res = new int[1];
        boolean l = processCore(disk,0,tail,res,0);
        if(l){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

    }

    private static boolean processCore(int[] disk, int i, int tail,int[] res,int time) {
        if(i == tail){
            return false;
        }
        if(res[0] == 0 && time !=0 ){
            return true;
        }
        boolean a = processCore(disk,i+1,tail,res,time);
        res[0] = res[0]^disk[i];
        boolean b = processCore(disk,i+1,tail,res,time+1);
        return a || b;
    }

    private static void swap(int[] arr, int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
