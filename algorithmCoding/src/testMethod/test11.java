package testMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-09-15 22:10
 **/
public class test11 {

    public static void main(String[] args) {
        String str = "12,";
        String[] a = str.split("[,，]");
        System.out.println(Arrays.toString(a));
        System.out.println(true ^ true);
        System.out.println(true ^ false);
    }
}
