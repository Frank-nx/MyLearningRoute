package testMethod;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String[] param = input1.split(" ");
        int[] stomach = new int[param.length];
        for(int i = param.length-1;i>=0;i--){
            stomach[i] = Integer.parseInt(param[i]);
        }
        String input2 = sc.nextLine();
        String[] param2 = input2.split(" ");
        int[] candy = new int[param2.length];
        for(int i = param2.length-1;i>=0;i--){
            candy[i] = Integer.parseInt(param2[i]);
        }
        Arrays.sort(stomach);
        Arrays.sort(candy);
        int res = 0;
        int index1 = 0;
        int index2 = 0;
        while(index1 < stomach.length && index2 < candy.length){
            if(candy[index2] >= stomach[index1]){
                res++;
                index1++;
                index2++;
            }else{
                index2++;
            }
        }
        System.out.println(res);

    }
}
