package com.nixuan.leetCode.LeetCode1_100;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-27 10:10
 **/
public class LeetCode0056_合并区间 {

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2){
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        int index = 1;
        while(index < intervals.size()){
            if(intervals.get(index-1).end >= intervals.get(index).start){
                Interval temp = new Interval(intervals.get(index-1).start,Math.max(intervals.get(index).end,intervals.get(index-1).end));
                intervals.remove(index);
                intervals.remove(index-1);
                intervals.add(index-1,temp);
            }else{
                index++;
            }
        }
        return intervals;
    }

    private static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
