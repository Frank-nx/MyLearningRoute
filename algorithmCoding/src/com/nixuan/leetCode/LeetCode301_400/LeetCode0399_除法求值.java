package com.nixuan.leetCode.LeetCode301_400;

import java.util.*;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/3/8 18:01
 **/
public class LeetCode0399_除法求值 {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String,Double>> graph= new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            builtGraph(graph,equations[i][0],equations[i][1],values[i]);
            builtGraph(graph,equations[i][1],equations[i][0],1/values[i]);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = getValue(graph,queries[i][0],queries[i][1]);
        }
        return res;
    }

    private void builtGraph(Map<String, Map<String, Double>> graph, String start, String end, double value) {
        Map<String,Double> node;
        if (graph.containsKey(start)){
            node = graph.get(start);
        }else{
            node = new HashMap<>();
        }
        node.put(end,value);
        graph.put(start,node);
    }

    private double getValue(Map<String, Map<String, Double>> graph, String start, String end) {
        if (graph.get(start) == null || graph.get(end) == null){
            return -1;
        }
        if (start.equals(end)){
            return 1;
        }
        Queue<String> queue = new LinkedList<>();
        Map<String,Double> value = new HashMap<>();
        Set<String> distinct = new HashSet<>();

        queue.add(start);
        value.put(start,1d);
        distinct.add(start);

        String curNode,nextNode;
        while(!queue.isEmpty()){
            curNode = queue.remove();
            for (Map.Entry<String,Double> entry:graph.get(curNode).entrySet()) {
                nextNode = entry.getKey();
                value.put(nextNode,value.get(curNode) * entry.getValue());
                if (nextNode.equals(end)){
                    return value.get(nextNode);
                }else if (!distinct.contains(nextNode)){
                    queue.add(nextNode);
                    distinct.add(nextNode);
                }
            }
        }
        return -1;

    }


}
