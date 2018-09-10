package com.nixuan.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s == null){
            System.out.println(0);
        }
        int res = 0;
        int pre = -1;
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int index = map.get(s.charAt(i)) == null?-1:map.get(s.charAt(i));
            int length = Math.min(i - pre,i - index);
            res = Math.max(res,length);
            pre = Math.max(pre,index);
            map.put(s.charAt(i),i);
        }
        System.out.println(res);
    }
}
