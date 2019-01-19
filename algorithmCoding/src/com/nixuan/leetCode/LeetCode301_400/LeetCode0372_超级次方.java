package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description : 快速幂
 * @Author nixuan_sx
 * @Date 2019/1/19 15:00
 **/
public class LeetCode0372_超级次方 {

    public static void main(String[] args) {
        System.out.println(superPow(2,new int[]{3}));
    }

    public static int superPow(int a, int[] b) {
        if (!moreThanZero(b)){
            return 1;
        }
        boolean isEven = false;
        if (b[b.length-1]%2==0){
            isEven = true;
        }
        a = a % 1337;
        div(b,2);
        System.out.println("a:" + a);
        int result = superPow((a * a) % 1337 ,b);
        System.out.println("result:" + result);
        if (!isEven){
            result = (result % 1337) * a;
        }
        return result % 1337;
    }

    private static boolean moreThanZero(int[] b){
        for (int i = b.length-1; i >= 0; i--) {
            if (b[i] > 0){
                return true;
            }
        }
        return false;
    }

    private static void div(int[] b, int div){
        int temp = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i] + temp * 10;
            temp = b[i] % div;
            b[i] = b[i] / div;
        }
    }

    // 方法二
    public static int superPow1(int a, int[] b){
        a = a % 1337;
        int res = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            res = res * getPow(a,b[i]) % 1337;
            a = getPow(a,10);
        }
        return res;
    }

    public  static int getPow(int a,int b){
        a = a % 1337;
        int res = 1;
        for (int i = 0; i < b; i++) {
            res = res * a % 1337;
        }
        return res;
    }
}
