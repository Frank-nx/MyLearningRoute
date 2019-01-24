package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/23 9:31
 **/
public class LeetCode0388_文件的最长绝对路径 {

    public int lengthLongestPath(String input) {
        if (input == null || input.length() < 1){
            return 0;
        }
        String[] fileArr = input.split("\n");
        int[] help = new int[fileArr.length+1];
        int maxLen = 0;
        for (String file:fileArr) {
            int level = file.lastIndexOf("\t") + 2;
            help[level] = help[level - 1] + file.length() - level + 1;
            if (file.indexOf(".") != -1){
                maxLen = Math.max(maxLen,help[level] + level - 1);
            }
        }
        return maxLen;
    }

}
