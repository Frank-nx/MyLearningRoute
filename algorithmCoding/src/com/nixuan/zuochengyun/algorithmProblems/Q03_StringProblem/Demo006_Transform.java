package com.nixuan.zuochengyun.algorithmProblems.Q03_StringProblem;

import java.util.HashMap;
import java.util.Map;

public class Demo006_Transform {

    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        if(A == null || B == null || A.length() != B.length()){
            return false;
        }
        int[] arr = new int[256];
        for(int i = 0;i<lena;i++){
            arr[A.charAt(i)]++;
        }
        for(int i = 0;i<lenb;i++){
            arr[B.charAt(i)]--;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
