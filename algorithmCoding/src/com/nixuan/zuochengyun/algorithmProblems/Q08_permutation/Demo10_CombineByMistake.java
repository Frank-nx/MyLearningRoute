package com.nixuan.zuochengyun.algorithmProblems.Q08_permutation;

/**
 * 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，问有多少种装法?
 *
 * 给定一个整数n，请返回装发个数，为了防止溢出，请返回结果Mod 1000000007的值。保证n的大小小于等于300。
 *
 * 测试样例：
 * 2
 * 返回：1
 *
 * 思路：
 * 两种情况
 * 1、n信装在i信封，i信装在n信封 f(n-2)
 * 2、n信装在i信封，n信没有装在i信封，f(n-1);
 * i的选择有n-1中
 * 所以f(n) = (n-1)*(f(n-2) + f(n-1))
 */
public class Demo10_CombineByMistake {

    public static void main(String[] args) {
        int res = countWays(4);
        System.out.println(res);
    }
    public static int countWays(int n) {
        // write code here
        if(n <= 1){
            return 0;
        }
        long res1 = 0;
        long res2 = 1;
        for(int i = 3;i <= n;i++){
            long res = (res1 + res2)*(i-1);
            res1 = res2%1000000007;
            res2 = res%1000000007;
        }
        return (int)res2;
    }
}
