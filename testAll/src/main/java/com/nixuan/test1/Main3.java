package com.nixuan.test1;


import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i=0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0;i<len;){
            if(isSingle(arr[i])){
                i++;
                continue;
            }else{
                int l = isMutiByte(arr[i]);
                if(l == 0){
                    System.out.println(0);
                    return;
                }
                i++;
                while(l>0){
                    if(i>=len||!isSuffix(arr[i++])){
                        System.out.println(0);
                        return;
                    }
                    l--;
                }
            }
        }
        System.out.println(1);
    }

    private static boolean isSingle(int a){
        if((a&0x0080)==0){
            return true;
        }
        return false;
    }

    private static int isMutiByte(int a){
        if((a&0x00e0)==0x00c0){
            return 1;
        }
        if((a&0x00f0)==0x00e0){
            return 2;
        }
        if((a&0x00f8)==0x00f0){
            return 3;
        }
        return 0;
    }

    public static boolean isSuffix(int a){
        if((a&0x00c0)==0x0080){
            return true;
        }
        return false;
    }
}
