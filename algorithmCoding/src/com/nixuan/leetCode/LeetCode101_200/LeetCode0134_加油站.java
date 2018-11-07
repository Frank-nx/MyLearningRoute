package com.nixuan.leetCode.LeetCode101_200;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-06 16:53
 **/
public class LeetCode0134_加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length < 1 || gas.length != cost.length){
            return -1;
        }
        int total = 0;
        int diff = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            diff +=gas[i] - cost[i];
            if(diff < 0){
                start = i+1;
                diff  = 0;
            }
        }
        return total < 0?-1:start;
    }

}
