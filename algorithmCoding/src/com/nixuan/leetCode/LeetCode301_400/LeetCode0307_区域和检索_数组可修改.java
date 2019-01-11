package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/12/20 11:08
 **/
public class LeetCode0307_区域和检索_数组可修改 {

    public int[] data;
    public int[] tree;

    public LeetCode0307_区域和检索_数组可修改(int[] nums) {
        if(nums == null || nums.length < 1){
            return;
        }
        int len = nums.length;
        data = new int[len];
        for (int i = 0; i < len; i++) {
            data[i] = nums[i];
        }
        tree = new int[len*4];
        buildTree(0,0,len-1);
    }

    public void buildTree(int treeIndex,int start,int end){
        if(start == end){
            tree[treeIndex] = data[start];
            return;
        }
        int leftIndex = 2 * treeIndex + 1;
        int rightIndex = 2 * treeIndex + 2;
        int mid = (start + end)>>1;

        buildTree(leftIndex,start,mid);
        buildTree(rightIndex,mid+1,end);

        tree[treeIndex] = tree[leftIndex] + tree[rightIndex];
    }


    public void update(int i, int val) {
        if(i < 0 || i >= data.length){
            throw new RuntimeException("index is out");
        }
        update(0,0,data.length-1,i,val);
    }

    private int update(int treeIndex, int start, int end, int i, int val) {
        if(start == end){
            int diff = val - data[i];
            data[i] = val;
            tree[treeIndex] = val;
            return diff;
        }
        int leftIndex = treeIndex*2+1;
        int rightIndex = treeIndex*2+2;
        int mid = (start+end)>>1;

        int diff = 0;
        if (mid >= i){
            diff = update(leftIndex,start,mid,i,val);
            tree[treeIndex] = tree[treeIndex] + diff;
        }else{
            diff = update(rightIndex,mid+1,end,i,val);
            tree[treeIndex] = tree[treeIndex] + diff;
        }
        return diff;
    }

    public int sumRange(int i, int j) {
        if (i < 0 || i >=data.length || j < 0 || j>=data.length || i > j){
            throw new RuntimeException("index is out");
        }
        if(i==j){
            return data[i];
        }
        return sumRange(0,0,data.length-1,i,j);
    }

    private int sumRange(int treeIndex, int start, int end, int i, int j) {
        if (start == i && end == j){
            return tree[treeIndex];
        }
        int leftIndex = treeIndex*2+1;
        int rightIndex = treeIndex*2+2;
        int mid = (start+end)>>1;

        if(mid >= j){
            return sumRange(leftIndex,start,mid,i,j);
        }else if(mid < i){
            return sumRange(rightIndex,mid+1,end,i,j);
        }
        return sumRange(leftIndex,start,mid,i,mid)+sumRange(rightIndex,mid+1,end,mid+1,j);
    }
}
