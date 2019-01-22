package com.nixuan.leetCode.LeetCode301_400;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/21 20:07
 **/
public class LeetCode0380_常数时间插入删除和获取随机元素 {

    Map<Integer,Integer> valueToIndex;
    Map<Integer,Integer> indexToValue;
    int index;

    /** Initialize your data structure here. */
    public LeetCode0380_常数时间插入删除和获取随机元素() {
        valueToIndex = new HashMap<>();
        indexToValue = new HashMap<>();
        index = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)){
            return false;
        }
        valueToIndex.put(val,index);
        indexToValue.put(index++,val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)){
            return false;
        }
        if (valueToIndex.get(val) == index - 1){
            valueToIndex.remove(val);
        }else{
            int cur = valueToIndex.remove(val);
            indexToValue.put(cur,indexToValue.get(index-1));
            valueToIndex.put(indexToValue.get(cur),cur);
        }
        index--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int getIndex = (int) (Math.random()*index);
        return indexToValue.get(getIndex);
    }

}
