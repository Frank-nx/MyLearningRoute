package com.nixuan.test1;


import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int all = sc.nextInt();
        int len = sc.nextInt();
        if(all > len+1){
            System.out.println(0);
            return;
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int i=0; i < len; i++){
            int key = sc.nextInt();
            int value = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            set.add(value);
            set.add(key);
            map.put(key,set);
        }
        Set<Integer> res = new HashSet<>();
        boolean isStart = true;
        for (Map.Entry<Integer,Set<Integer>> entry:map.entrySet()) {
            if(isStart){
                res = entry.getValue();
            }else{
                res = diff(res,entry.getValue());
            }
        }
        System.out.println(res.size());
    }

    private static Set<Integer> diff(Set<Integer> res, Set<Integer> value) {
        if(res.isEmpty()){
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for
    }
}
