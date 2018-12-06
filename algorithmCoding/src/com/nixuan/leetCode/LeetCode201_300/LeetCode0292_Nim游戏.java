package com.nixuan.leetCode.LeetCode201_300;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2018/12/6 17:26
 **/
public class LeetCode0292_Nim游戏 {

    public boolean canWinNim(int n) {
        if(n < 4){
            return true;
        }
        return n%4!=0;
    }

}
