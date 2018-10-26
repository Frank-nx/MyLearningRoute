package com.nixuan.test1;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-15 10:43
 **/
public class a {

    public static void main(String[] args) {
        String a = "a";
        String b = "bc";
        String c = "bca";

        System.out.println(judge(a,b,c));
        System.out.println(process1(a,b,c));
    }

    public static boolean judge(String a,String b,String c){
        if(a.length() + b.length() != c.length()){
            return false;
        }
        return process(a,b,c,0,0,0);
    }

    public static boolean process(String a,String b,String c,int aStart,int bStart,int cStart){
        if(aStart == a.length()&&bStart == b.length() && cStart == c.length()){
            return true;
        }
        boolean res = false;
        if(aStart != a.length() && a.charAt(aStart) == c.charAt(cStart)){
            res = res || process(a,b,c,aStart+1,bStart,cStart+1);
        }
        if(bStart != b.length() && b.charAt(bStart) == c.charAt(cStart)){
            res =res || process(a,b,c,aStart,bStart+1,cStart+1);
        }
        return res;
    }

    public static boolean process1(String a,String b,String c){
        if(a.length() + b.length() != c.length()){
            return false;
        }
        int aLen = a.length();
        int bLen = b.length();
        int cLen = c.length();
        boolean[][][] res = new boolean[cLen + 1][aLen + 1][bLen+ 1];
        for(int i = 0; i<=aLen;i++){
            for(int j=0;j<=bLen;j++){
                res[cLen][i][j] = false;
            }
        }
        res[cLen][aLen][bLen] = true;
        for(int k = cLen-1;k >=0;k--){
            for(int i = aLen; i >= 0;i--){
                for(int j=bLen;j >= 0;j--){
                    if(j != bLen && b.charAt(j) == c.charAt(k)){
                        res[k][i][j] = res[k+1][i][j+1];
                    }
                    if(i != aLen && a.charAt(i) == c.charAt(k)){
                        res[k][i][j] = res[k][i][j] || res[k+1][i+1][j];
                    }
                    System.out.print(k + "" + i + j + ":" +res[k][i][j]);
                }
                System.out.println();
            }
        }
        return res[0][0][0];
    }
}
