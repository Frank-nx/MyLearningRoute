package com.nixuan.test1;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description: 头条笔试
 * @author: nixuan
 * @create: 2018-09-20 20:04
 *
 5
bytedance
toutiaohao
toutiaoapp
iesaweme
iestiktok

 **/
public class 字符串组的前缀 {

   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = Integer.parseInt(input);
        String[] params = new String[len];
        for (int i = 0;i < len; i++){
            params[i] = sc.nextLine();
        }
        Trie trie = new Trie();
        for (int i =0;i<len;i++){
            trie.insert(params[i]);
        }
        for(int i=0;i < len;i++){
            String res = trie.search(params[i]);
            System.out.println(res);
        }
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = Integer.parseInt(input);
        String[] params = new String[len];
        Map<String,List<String>> map = new HashMap<>();
        Map<String,String> res = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0;i < len; i++){
            params[i] = sc.nextLine();
            list.add(params[i]);
        }
        map.put("",list);
        prefix(map,res);
        for(int i=0;i<len;i++){
            System.out.println(res.get(params[i]));
        }
    }

    public static void prefix(Map<String,List<String>> map,Map<String,String> res){
        if(map == null || map.size() < 1){
            return;
        }
        Map<String,List<String>> temp = new HashMap<>();
        for (Map.Entry<String,List<String>> entry:map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if(value.size() == 1){
                res.put(value.get(0),key);
                continue;
            }
            int len = key.length();
            List<String> left = new ArrayList<>();
            for(int i = 0;i<value.size();i++){
                List<String> right = new ArrayList<>();
                String curStr = value.get(i);
                if(curStr.length() == len){
                    left.add(curStr);
                    temp.put(key,left);
                    continue;
                }
                String fix = key+curStr.charAt(len);
                if(temp.containsKey(fix)){
                    temp.get(fix).add(curStr);
                }else{
                    right.add(curStr);
                    temp.put(fix,right);
                }
            }
        }
        prefix(temp,res);
    }

    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }


        public String search(String word) {
            if (word == null) {
                return null;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return sb.toString();
                }
                sb.append(chs[i]);
                node = node.nexts[index];
                if(node.path == 1){
                    return sb.toString();
                }
            }
            return null;
        }
    }

}
