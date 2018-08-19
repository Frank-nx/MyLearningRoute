package testMethod;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(int i=0;i<list.size();i++){
            if(list.get(i) == 2){
                list.remove((Integer)2);
            }
        }
        System.out.println(list);
    }
}
