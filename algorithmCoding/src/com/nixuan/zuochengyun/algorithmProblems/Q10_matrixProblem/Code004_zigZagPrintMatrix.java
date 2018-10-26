package com.nixuan.zuochengyun.algorithmProblems.Q10_matrixProblem;

/**
 * @program: MyLearningRoute
 * @description: “之” 字形打印矩阵
 * @author: nixuan
 * @create: 2018-09-14 22:07
 **/
public class Code004_zigZagPrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9,10,11,12},
                {13,14,15,16}
        };
        zigZagPrintMatrix(matrix);
    }

    public static void zigZagPrintMatrix(int[][] matrix){
        if(matrix == null){
            return;
        }
        int aRow = 0;
        int aCol = 0;
        int bRow = 0;
        int bCol = 0;
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        boolean order = false;
        while(bCol <= col){
            zigZagPrint(matrix,aRow,aCol,bRow,bCol,order);
            aRow = aCol==col?aRow+1:aRow;
            aCol = aCol==col?aCol:aCol+1;
            // bCol与bRow的书写顺序不能换，否则运行错误
            bCol = bRow==row?bCol+1:bCol;
            bRow = bRow==row?bRow:bRow+1;

            order = !order;
        }
    }

    private static void zigZagPrint(int[][] matrix, int aRow, int aCol, int bRow, int bCol, boolean order) {
        if(!order){
            while(aRow <= bRow){
                System.out.print(matrix[bRow--][bCol++]+",");
            }
        }else{
            while(aCol >= bCol){
                System.out.print(matrix[aRow++][aCol--]+",");
            }
        }
    }
}
