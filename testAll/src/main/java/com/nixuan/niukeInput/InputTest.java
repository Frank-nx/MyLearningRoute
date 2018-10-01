package com.nixuan.niukeInput;

import org.junit.Test;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description: 牛客网的键盘输入
 * @author: nixuan
 * @create: 2018-09-07 09:10
 **/
public class InputTest {

    public static void main(String[] args) {
       // inputOneNum();
       // inputArray();
       // inputMatrix();
       // inputOneNumNextLine();
       // inputMutiLineNextLine();
        inputMutiLineNextLine1();
    }

    public static void inputOneNum(){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        System.out.println(len);
    }

    public static void inputArray(){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i=0; i < len; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void inputMatrix(){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        // 打印语句
        for (int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void inputOneNumNextLine(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = Integer.parseInt(input);
        System.out.println(len);
    }

    public static void inputMutiLineNextLine(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = Integer.parseInt(input);
        for (int i = 0;i < len; i++){
            String input1 = sc.nextLine();
            String[] param = input1.split(" ");
            System.out.println(Arrays.toString(param));
        }
    }

    public static void inputMutiLineNextLine1(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = Integer.parseInt(input);
        Map<Integer,List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++){
            String input1 = sc.nextLine();
            map.put(i,Arrays.asList(input1.split(" ")));
        }
        // 打印语句
        for(int i = 0; i < len; i++){
            System.out.println(i + "--" +map.get(i));
        }
    }


}
