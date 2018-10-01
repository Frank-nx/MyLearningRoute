package com.nixuan.test1;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-09-27 14:43
 *
3
1 2
2 3
4 5
 *
 **/
public class 交集 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = Integer.parseInt(input);
        LinkedList<Set<Integer>> list = new LinkedList<>();
        Set<Integer> all = new HashSet<>();
        for (int i = 0;i < len; i++){
            Set<Integer> set = new HashSet<>();
            String input1 = sc.nextLine();
            String[] param = input1.split(" ");
            for(String s:param){
                int temp = Integer.parseInt(s);
                set.add(temp);
                all.add(temp);
            }
            list.add(set);
        }
        UnionFindSet<Integer> ufs = new UnionFindSet<>();
        ufs.makeSets(all);
        for(Set<Integer> set:list){
            Integer root = set.iterator().next();
            System.out.println(root);
            for (Integer i:set) {
                ufs.union(root,i);
            }
        }
        ufs.print();
        Set<Integer> res = new HashSet<>();
        int maxSize = 0;
        for(Integer i:all){
            Integer head = ufs.findHead(i);
            res.add(head);
            maxSize = Math.max(maxSize,ufs.getSize(head));
        }
        System.out.println(res);
        System.out.println(maxSize);
    }


    public static class UnionFindSet<K>{
        private HashMap<K,K> fatherMap;
        private HashMap<K,Integer> sizeMap;

        public UnionFindSet(){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(Set<K> nodes){
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

        public int getSize(K node){
            return sizeMap.get(findHead(node));
        }

        public K findHead(K node){
            K parent = fatherMap.get(node);
            if(parent != node){
                parent = findHead(parent);
            }
            fatherMap.put(node,parent);
            return parent;
        }

        public boolean isSameSet(K node1, K node2){
            return findHead(node1) == findHead(node2);
        }

        public void union(K a,K b){
            if(a == null || b == null || isSameSet(a,b)){
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

        public void print(){
            for(Map.Entry<K,K> entry: fatherMap.entrySet()){
                System.out.println(entry.getKey() + "->" + entry.getValue());
            }
        }
    }
}
