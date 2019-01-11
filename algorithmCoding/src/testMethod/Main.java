package testMethod;

import com.nixuan.leetCode.LeetCode301_400.LeetCode0307_区域和检索_数组可修改;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        LeetCode0307_区域和检索_数组可修改 obj = new LeetCode0307_区域和检索_数组可修改(arr);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(Arrays.toString(obj.tree));
        obj.update(1, 2);
        System.out.println(Arrays.toString(obj.tree));
        System.out.println(obj.sumRange(0, 2));
    }
}
