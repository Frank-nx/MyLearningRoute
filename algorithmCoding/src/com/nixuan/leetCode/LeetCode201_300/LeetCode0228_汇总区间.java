package com.nixuan.leetCode.LeetCode201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-13 21:02
 **/
public class LeetCode0228_汇总区间 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length < 1){
            return res;
        }
        res.add(nums[0]+"");
        if(nums.length == 1){
            return res;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1] - nums[i] != 1){
                String s = res.remove(res.size()-1);
                String next = nums[i]+"";
                if(!next.equals(s)){
                    res.add(s+"->"+next);
                }else{
                    res.add(next);
                }
                res.add(nums[i+1]+"");
            }
        }
        String s = res.remove(res.size()-1);
        String next = nums[nums.length-1]+"";
        if(!next.equals(s)) {
            res.add(s + "->" + next);
        }else{
            res.add(next);
        }
        return res;
    }

}
