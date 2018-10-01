package com.nixuan.zuochengyun.algorithmProblems.Q09_mapProblem;

import java.util.HashMap;
import java.util.List;

/**
 * @program: MyLearningRoute
 * @description: 并查集
 * @author: nixuan
 * @create: 2018-09-23 18:38
 **/
public class Demo02_UnionFind {

    public static void main(String[] args) {
        UnionFindSet<String> ufs = new UnionFindSet<>();

    }

    public static class UnionFindSet<K>{
        private HashMap<K,K> fatherMap;
        private HashMap<K,Integer> sizeMap;

        public UnionFindSet(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(List<K> nodes){
            if(nodes == null || nodes.isEmpty()){
                return;
            }
            fatherMap.clear();
            sizeMap.clear();
            for (K node: nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        public K findHead(K node){
            K parent = fatherMap.get(node);
            if (parent != node){
                parent = findHead(parent);
            }
            fatherMap.put(node,parent);
            return parent;
        }

        public boolean isSameSet(K node1, K node2){
            return findHead(node1) == findHead(node2);
        }

        public void union(K a,K b){
            if(a == null || b == null){
                return;
            }
            K aHead = findHead(a);
            K bHead = findHead(b);
            Integer aSize = sizeMap.get(aHead);
            Integer bSize = sizeMap.get(bHead);
            if(aSize > bSize){
                fatherMap.put(bHead,aHead);
                sizeMap.put(aHead,aSize+bSize);
            }else{
                fatherMap.put(aHead,bHead);
                sizeMap.put(bHead,aSize+bSize);
            }
        }
    }
}
