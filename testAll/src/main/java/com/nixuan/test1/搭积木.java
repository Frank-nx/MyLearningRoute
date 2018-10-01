package com.nixuan.test1;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description: 快手笔试
 * @author: nixuan
 * @create: 2018-09-25 22:19
 **/
public class 搭积木 {

    public static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

   /* public static int buildingBlocks(List<Pair> list){
        if(list.isEmpty()){
            return 0;
        }
        List<Pair> xandy = copyList(list);
        Collections.sort(xandy, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int res = o1.x>o2.x?1:(o1.x==o2.x&&o1.y>o1.y?1:0);
                return res;
            }
        });
        List<Pair> yandx = copyList(list);
        Collections.sort(yandx, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int res = o1.y>o2.y?1:(o1.y==o2.y&&o1.x>o1.x?1:0);
                return res;
            }
        });
        int xin = 0;
        int yin = 0;
        int len = list.size();
        int res = 0;
        while(xin < len && yin < len){
            if(isValid(xandy.get(xin),yandx.get(yin))){
                res++;
                xin++;
            }else if(xin < len && yin < len && isValid(yandx.get(yin),xandy.get(xin))){
                res++;
                yin++;
            }else




        }
    }
*/
    public static List<Pair> copyList(List<Pair> list){
        List<Pair> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(i));
        }
        return res;
    }

    public static boolean isValid(Pair left,Pair right){
        if(left.x <= right.x && left.y <= right.y){
            if(!(left.x == right.x&&left.y==right.y)){
                return true;
            }
        }
        return false;
    }
}
