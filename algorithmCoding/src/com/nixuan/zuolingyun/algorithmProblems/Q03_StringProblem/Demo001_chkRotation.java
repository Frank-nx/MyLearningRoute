package com.nixuan.zuolingyun.algorithmProblems.Q03_StringProblem;

public class Demo001_chkRotation {

    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(lena != lenb) {
            return false;
        }
        String newStr = A + A;
        return newStr.contains(B);
    }
}
