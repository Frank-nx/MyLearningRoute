package com.nixuan.test1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-13 19:07
 **/
public class 餐桌游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i = 0; i < num;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            lastRemaining(n,m);
        }
    }

    public static void lastRemaining(int n, int m) {
        if(n<1||m<1)
            return;
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        int index = 0;
        int count = 1;
        while(list.size()!=1){
            if(index==list.size()){
                index=0;
            }
            if(count==m){
                count=0;
                int res = list.remove(index--);
                System.out.print(res + " ");
            }
            count++;
            index++;
        }
        System.out.println(list.get(0));
    }
}
