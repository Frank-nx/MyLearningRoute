package com.nixuan.leetCode.LeetCode401_500;

import com.nixuan.util.ArrayMatrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/9 14:42
 **/
public class LeetCode0406_根据身高重建队列 {

    public static void main(String[] args) {
        // [7,0], [4,4], [7,1], [5,0], [6,1], [5,2]
        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        ArrayMatrix.printMatrix(reconstructQueue(people));
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1){
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0]==0?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1],people[i]);
        }
        return list.toArray(people);
    }

}
