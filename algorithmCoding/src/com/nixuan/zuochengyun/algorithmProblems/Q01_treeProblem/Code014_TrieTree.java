package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

/**
 * @program: MyLearningRoute
 * @description: 前缀树
 * @author: nixuan
 * @create: 2018-09-23 19:18
 **/
public class Code014_TrieTree {

    private static class Node{
        int path;
        int end;
        Node[] next;

        public Node(){
            this.path = 0;
            this.end = 0;
            this.next = new Node[26];
        }
    }

    private static class TrieTree{
        Node root = new Node();

        public void insert(String s){
            if(s == null || s.length() < 1){
                return;
            }
            Node cur = root;
            char[] arr = s.toCharArray();
            for(int i = 0;i<arr.length;i++){
                cur.path++;
                cur = cur.next[arr[i]-'a'] == null ? new Node():cur.next[arr[i]-'a'];
            }
            cur.end++;
        }

        public void delete(String word){
            if(search(word) != 0){
                Node cur = root;
                char[] arr = word.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    int index = arr[i] - 'a';
                    if(--cur.path == 0){
                        cur.next[arr[i]-'a'] = null;
                        return;
                    }
                    cur = cur.next[index];
                }
                cur.end--;
            }
        }

        public int search(String word){
            if(word == null || word.length() < 1){
                return 0;
            }
            char[] arr = word.toCharArray();
            Node cur = root;
            for(int i = 0; i < arr.length;i++){
                int index = arr[i] - 'a';
                if(cur.next[index]==null){
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.end;
        }
    }
}
