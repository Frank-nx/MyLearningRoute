package testMethod;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-09-15 22:10
 **/
public class test11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(in.hasNextInt()){
            list.add(in.nextInt());
        }
        int[] res = new int[list.size()];
        int head = 0;
        int tail = res.length-1;
        int count = 0;
        while(head < tail){
            res[count++] = list.get(head++);
            if(count < res.length){
                res[count++] = list.get(tail--);
            }
        }
        for (int i=0;i<res.length;i++){
            System.out.println("node = "+res[i]);
            System.out.println();
        }
    }
}
