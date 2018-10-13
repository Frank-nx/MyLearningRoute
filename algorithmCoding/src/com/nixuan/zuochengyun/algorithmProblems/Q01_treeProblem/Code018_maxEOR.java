package com.nixuan.zuochengyun.algorithmProblems.Q01_treeProblem;

/**
 * @program: MyLearningRoute
 * @description:
 * 给定一个数组， 求子数组的最大异或和。
 *
 * 一个数组的异或和为， 数组中所有的数异或起来的结果。
 * @author: nixuan
 * @create: 2018-10-12 16:16
 **/
public class Code018_maxEOR {

    private static class Node{
        Node[] next;

        public Node(){
            next = new Node[2];
        }
    }

    private static class TrieTree{
        Node root = new Node();

        public void add(int n){
            Node cur = root;
            for(int i = 31; i >= 0;i--){
                int index = (n >> i)&1;
                if(cur.next[index] == null){
                    cur.next[index] = new Node();
                }
                cur = cur.next[index];
            }
        }

            public int maxEOR(int sum){
            Node cur = root;
            int res = 0;
            for(int i = 31; i >= 0; i--){
                int flag = (sum >> i) & 1;
                //不是符号位则走与sum对应的位相反的路
                int base = i == 31 ? flag : (flag ^ 1);
                base = cur.next[base] == null ? (base ^ 1) : base;
                res |= (flag ^ base) << i;
                cur = cur.next[base];
            }
            return res;
        }
    }

    public static int maxEorCore(int[] arr){
        if(arr == null || arr.length < 1){
            return 0;
        }
        int res = 0;
        int eor = 0;
        TrieTree trie = new TrieTree();
        trie.add(0);
        for(int i = 0;i < arr.length; i++){
            trie.add(i);
            eor ^= arr[i];
            res = Math.max(res,trie.maxEOR(eor));
        }
        return res;
    }

    //暴力解法，用于检测
    public static int maxEor1(int[] arr){
        if(arr == null ||arr.length < 1){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int eor = 0;
            for (int j = i; j >=0 ; j--) {
                eor ^= arr[j];
                res = Math.max(res,eor);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-9,-7,4,-6,7,2,4,8,-7};
        int res = maxEorCore(arr);
        System.out.println(res);
        System.out.println(maxEor1(arr));
    }


}
