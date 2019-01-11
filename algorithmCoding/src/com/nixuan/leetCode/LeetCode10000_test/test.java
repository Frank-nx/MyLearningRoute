package com.nixuan.leetCode.LeetCode10000_test;

import com.nixuan.leetCode.LeetCode301_400.LeetCode0307_区域和检索_数组可修改;

import java.util.Arrays;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/9 14:42
 **/
public class test {

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        LeetCode0307_区域和检索_数组可修改 obj = new LeetCode0307_区域和检索_数组可修改(arr);
        System.out.println("tree"+Arrays.toString(obj.tree));
        System.out.println("sumRange(0,2):"+obj.sumRange(0,2));
        System.out.println("tree"+Arrays.toString(obj.tree));
        obj.update(1,2);
        System.out.println("tree"+Arrays.toString(obj.tree));
        System.out.println("sumRange(0,2):"+obj.sumRange(0,2));
    }
}
