package testMethod;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description: ..
 * @author: nixuan
 * @create: 2018-09-16 20:01
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = n+"";
        int len = s.length();
        int res = 0;
        for(int i = 1;i<len;i++){
            res+=Math.pow(4,i);
        }
        char[] arr = {'2','5','6','9'};
        char[] num = new char[len];
        for (int i = 0;i<len;i++){
            num[i] = '2';
        }
        for(int i = len-1;i>=0;i--){
            for(int j=0;j<4;j++){
                num[i] = arr[j];
                if(Integer.parseInt(String.valueOf(num)) <= n){
                    res++;
                }else{
                    System.out.println(res);
                    return;
                }
            }
        }

    }
}
