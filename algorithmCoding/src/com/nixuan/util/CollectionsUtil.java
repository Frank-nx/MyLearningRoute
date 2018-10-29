package com.nixuan.util;

import java.util.List;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-28 10:40
 **/
public class CollectionsUtil {

    public static void printListList(List<List<Integer>> res){
        if(res == null){
            return;
        }
        for (List<Integer> list:res) {
            System.out.println(list);
        }
    }
}
