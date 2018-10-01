package testMethod;

import java.util.Scanner;

public class testSmallestCommon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int lcm = 1;
        for(int i=2;i<=n;i++){
            lcm = getLcm(i,lcm);
        }
        if(lcm/(n+1)==0){
            System.out.println(n+1);
            return;
        }
        int lcm1 = n+1;
        int index = n+1;
        while(true){
            if((index&1)==0&&index>2*n){
                index++;
                continue;
            }
            int gcd = getGcd(index,lcm);
            lcm = index/gcd*lcm;
            lcm1 = getLcm(index,lcm1);
            if(lcm == lcm1){
                System.out.println(index);
                return;
            }
            index++;
        }
    }

    public static int getGcd(int m,int n){
        while(n > 0){
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    //求解数m和n和最小公倍数
    public static int getLcm(int m,int n){
        int gcd = getGcd(m,n);
        int result = m/gcd*n;
        return result;
    }
}
