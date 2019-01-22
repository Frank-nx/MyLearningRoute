package com.nixuan.leetCode.LeetCode301_400;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/20 21:13
 **/
public class LeetCode0378_有序矩阵中第k小的元素 {

    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int len = Math.min(k,row);
        PriorityQueue<Cuple> queue = new PriorityQueue<>(new Comparator<Cuple>() {
            @Override
            public int compare(Cuple o1, Cuple o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < len; i++) {
            queue.offer(new Cuple(0,i,matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Cuple cuple = queue.poll();
            if (cuple.x == row - 1){
                continue;
            }
            queue.offer(new Cuple(cuple.x+1,cuple.y,matrix[cuple.x+1][cuple.y]));
        }
        return queue.poll().val;
    }

    private static class Cuple{
        int x;
        int y;
        int val;

        public Cuple(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
