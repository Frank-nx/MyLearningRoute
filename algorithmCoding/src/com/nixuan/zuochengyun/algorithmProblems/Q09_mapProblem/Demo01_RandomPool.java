package com.nixuan.zuochengyun.algorithmProblems.Q09_mapProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MyLearningRoute
 * @description:
 * 设计一种结构， 在该结构中有如下三个功能：
 * insert(key)： 将某个key加入到该结构， 做到不重复加入。
 * delete(key)： 将原本在结构中的某个key移除。
 * getRandom()： 等概率随机返回结构中的任何一个key。
 * 【要求】 Insert、 delete和getRandom方法的时间复杂度都是 O(1)
 * @author: nixuan
 * @create: 2018-09-23 09:08
 **/
public class Demo01_RandomPool<K> {
    private Map<K,Integer> originalMap;
    private Map<Integer,K> help;
    private int size;

    public Demo01_RandomPool(){
        originalMap = new HashMap<>();
        help = new HashMap<>();
        size = 0;
    }

    public void insert(K key){
        if(!originalMap.containsKey(key)){
            size++;
            originalMap.put(key,size);
            help.put(size,key);
        }
    }

    public void delete(K key){
        if(originalMap.containsKey(key)){
            int index = originalMap.get(key);
            K tail = help.get(size);
            originalMap.put(tail,index);
            originalMap.remove(key);
            help.put(index,tail);
            help.remove(size);
            size--;
        }

    }

    public K getRandom(){
        if(size <= 0){
            return null;
        }
        int index = (int)Math.random()*size+1;
        return help.get(index);
    }



}
