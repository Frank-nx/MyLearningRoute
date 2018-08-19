package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;

import com.nixuan.util.MathUtil;

/**
 *在XxY的方格中，以左上角格子为起点，右下角格子为终点，每次只能向下走或者向右走，请问一共有多少种不同的走法
 *
 * 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
 *
 * 测试样例：
 * 2,2
 * 返回：2
 *
 * 思路：从x+y中选x
 */

public class Demo01_move {

    public int countWays(int x, int y) {
        // write code here
        if(x == 1 || y==1){
            return 1;
        }
        x--;
        y--;
        return (int)MathUtil.permutation(x,y+x);
    }
}
