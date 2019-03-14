package com.nixuan.leetCode.LeetCode401_500;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/14 9:50
 **/
public class LeetCode0421_数组中两个数的最大异或值 {

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int[] nums1 = {4,6,7};
        int res = findMaximumXOR(nums);
        System.out.println(res);
        System.out.println(findMaximumXOR(nums1));
    }

    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        if (nums.length == 2){
            return nums[0] ^ nums[1];
        }
        Trie root = new Trie();
        addTrie(root,nums[0]);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = getXOR(root,nums[i]);
            res = Math.max(res,temp);
            addTrie(root,nums[i]);
        }
        return res;
    }

    public static void addTrie(Trie root,int num){
        int temp = 1 << 30;
        for (int i = 0; i < 31; i++) {
            int flag = (temp & num) == 0 ? 0 : 1;
            if (root.next[flag] == null){
                root.next[flag] = new Trie();
            }
            root = root.next[flag];
            temp = temp >> 1;
        }
    }

    private static int getXOR(Trie root,int num){
        int temp = 1 << 30;
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int flag = (temp & num) == 0 ? 1 : 0;
            res = res << 1;
            if (root.next[flag] != null){
                res++;
                root = root.next[flag];
            }else{
                root = root.next[flag^1];
            }
            temp = temp >> 1;
        }
        return res;
    }

    private static class Trie{
        Trie[] next;
        public Trie(){
            next = new Trie[2];
        }
    }

}
