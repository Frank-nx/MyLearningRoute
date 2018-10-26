package com.nixuan.test1;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-15 11:38
 **/
public class wordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(s,wordDict));
    }
    public static boolean ans = false;
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() < 1){
            return true;
        }
        wordDict.add("");
        return process(s,wordDict,"",0);
    }

    private static boolean process(String s, List<String> wordDict, String res, int index) {
        if(index == wordDict.size() || res.length() >= s.length()){
            ans = ans || res.equals(s);
            return ans;
        }
        for(int i = 0;i<wordDict.size();i++){
            ans = process(s,wordDict,res+wordDict.get(i),index+1)||
                    process(s,wordDict,res,index+1);
        }
        return ans;
    }
}
