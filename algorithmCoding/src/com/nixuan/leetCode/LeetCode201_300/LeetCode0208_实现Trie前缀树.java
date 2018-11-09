package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 21:09
 **/
public class LeetCode0208_实现Trie前缀树 {

    private static class Node{
        Node[] next = new Node[26];
        int path;
        int end;
    }

    Node root;
    /** Initialize your data structure here. */
    public LeetCode0208_实现Trie前缀树() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() < 1){
            return true;
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.next[index] == null){
                return false;
            }
            cur = cur.next[index];
        }
        return cur.end > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() < 1){
            return true;
        }
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i)-'a';
            if(cur.next[index] == null){
                return false;
            }
            cur = cur.next[index];
        }
        return cur.path > 0;
    }

}
