package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-09 10:33
 **/
public class LeetCode0211_添加与搜索单词_数据结构设计 {

    private static class Node{
        Node[] next;
        int path;
        int end;
        public Node(){
            next = new Node[26];
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public LeetCode0211_添加与搜索单词_数据结构设计() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() < 1){
            return;
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.next[index] == null){
                cur.next[index] = new Node();
            }
            cur = cur.next[index];
            cur.path++;
        }
        cur.end++;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() < 1){
            return true;
        }
        Node cur = root;
        return process(cur,word,0);
    }

    private boolean process(Node cur, String word, int i) {
        if(cur == null){
            return false;
        }
        if(i == word.length()){
            if(cur.end > 0){
                return true;
            }else{
                return false;
            }
        }
        char c = word.charAt(i);
        boolean res = false;
        if(c != '.'){
            if(cur.next[c - 'a'] == null){
                return false;
            }
            res =res || process(cur.next[c-'a'],word,i+1);
        }else{
            for (int j = 0; j < 26; j++) {
                if(!res){
                    res =res || process(cur.next[j],word,i+1);
                }
            }
        }
        return res;
    }
}
