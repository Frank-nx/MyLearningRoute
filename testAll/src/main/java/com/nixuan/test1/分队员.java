package com.nixuan.test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-09-28 16:02
 *
4
5 4 7 6
 **/
public class 分队员 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] people = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            people[i] = sc.nextInt();
            sum += people[i];
        }
        int[] res = new int[1];
        process(people,sum,res,0,0,Integer.MAX_VALUE);
        System.out.println(res[0]);
    }

    private static void process(int[] people, int sum, int[] res,int num,int index,int min) {
        if(num > (sum>>1)){
            return;
        }
        if(index == people.length){
            if(isValid(sum,num,min)){
                res[0]++;
            }
            return;
        }
        process(people,sum,res,num+people[index],index+1,min);
        min = Math.min(people[index],min);
        process(people,sum,res,num,index+1,min);
    }

    private static boolean isValid(int sum, int num, int min) {
        if(sum-num>num&&num+min>(sum>>1)){
            return true;
        }
        return false;
    }

    public static int getNums(int n, int k, String str) {
        if (str == null || str.length() == 0 || k > str.length()) {
            return 0;
        }
        int[] card = new int[26];
        char[] ch = str.toCharArray();
        int res = 0;
        for (int i = 0; i < ch.length; i++) {
            int j = ch[i] - 'A';
            card[j]++;
        }
        Arrays.sort(card);
        int num = 0;
        for (int i = 0; i < 26; i++) {
            if (card[i] != 0) {
                if(card[i] < k){
                    num = card[i] * card[i];
                    res += num;
                    k -= card[i];
                }else{
                    num = k * k;
                    res += num;
                    break;
                }
            }
        }


        return res;
    }

}
