package com.nixuan.leetCode.LeetCode401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 16:18
 **/
public class LeetCode0412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1){
            return res;
        }
        for (int i = 1; i <= n; i++) {
            boolean c3 = i % 3 == 0;
            boolean c5 = i % 5 == 0;
            if (c3 && c5){
                res.add("FizzBuzz");
            }else if (c3){
                res.add("Fizz");
            }else if (c5){
                res.add("Buzz");
            }else{
                res.add(i+"");
            }
        }
        return res;
    }

}
