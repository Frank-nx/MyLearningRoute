package com.nixuan.leetCode.LeetCode301_400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/22 19:27
 **/
public class LeetCode0386_字典序排数 {

    public List<Integer> lexicalOrder(int n) {
        if (n < 1){
            return new ArrayList<>();
        }
        int cur = 1;
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            res.add(cur);
            if (cur * 10 <= n){
                cur *= 10;
            }else if (cur % 10 != 9 && cur + 1 <= n){
                cur++;
            }else{
                while((cur / 10) % 10 == 9){
                    cur = cur / 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return res;
    }

}
