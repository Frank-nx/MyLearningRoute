package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-08 21:33
 **/
public class LeetCode8000_test {

    public static void main(String[] args) {
        LeetCode0208_实现Trie前缀树 trie = new LeetCode0208_实现Trie前缀树();
        trie.insert("app");
        trie.insert("apple");
        /*trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");*/
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
    }
}
