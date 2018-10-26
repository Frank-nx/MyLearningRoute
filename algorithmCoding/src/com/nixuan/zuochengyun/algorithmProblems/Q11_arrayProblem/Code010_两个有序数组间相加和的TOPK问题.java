package com.nixuan.zuochengyun.algorithmProblems.Q11_arrayProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: MyLearningRoute
 * @description:
 * 两个有序数组间相加和的TOP K问题
 * 【题目】
 * 给定两个有序数组arr1和arr2， 再给定一个整数k， 返回来自
 * arr1和arr2的两个数相加和最大的前k个， 两个数必须分别来自
 * 两个数组。
 * 【举例】
 * arr1=[1,2,3,4,5]， arr2=[3,5,7,9,11]， k=4。
 * 返回数组[16,15,14,14]。
 * 【要求】
 * 时间复杂度达到O(klogk)。
 * @author: nixuan
 * @create: 2018-10-22 13:20
 **/
public class Code010_两个有序数组间相加和的TOPK问题 {

    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5};
        int[] arr2={3,5,7,9,11};
        int k = 4;
        int[] res = topK(arr1,arr2,k);
        System.out.println(Arrays.toString(res));
        int[] res1 = topKWithHeap(arr1,arr2,k);
        System.out.println(Arrays.toString(res1));
    }

    public static class Node{
        int p1;
        int p2;
        int val;

        public Node(int p1,int p2,int val){
            this.p1 = p1;
            this.p2 = p2;
            this.val = val;
        }
    }

    public static int[] topK(int[] arr1,int[] arr2,int k){
        if(arr1.length*arr2.length < k){
            return null;
        }
        int[] res = new int[k];
        PriorityQueue<Node> max = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.val-o1.val;
            }
        });
        int p1 = arr1.length- 1;
        int p2 = arr2.length - 1;
        max.add(new Node(p1,p2,arr1[p1]+arr2[p2]));
        int index = 0;
        while(k > index){
            Node cur = max.poll();
            res[index++] = cur.val;
            p1 = cur.p1;
            p2 = cur.p2;
            if(p1 > 0 && p2 > 0){
                max.add(new Node(p1-1,p2,arr1[p1-1]+arr2[p2]));
                max.add(new Node(p1,p2-1,arr1[p1]+arr2[p2-1]));
            }else if(p1 > 0){
                max.add(new Node(p1-1,p2,arr1[p1-1]+arr2[p2]));
            }else{
                max.add(new Node(p1,p2-1,arr1[p1]+arr2[p2-1]));
            }
        }
        return res;
    }

    public static int[] topKWithHeap(int[] arr1,int[] arr2,int k){
        if(arr1.length*arr2.length < k){
            return null;
        }
        Node[] max = new Node[k+1];
        int p1 = arr1.length- 1;
        int p2 = arr2.length - 1;
        int[] res = new int[k];
        int size = 0;
        int count  = 0;
        heapInsert(max,++size,new Node(p1,p2,arr1[p1]+arr2[p2]));
        while(k > count){
            Node cur = max[0];
            swap(max,0,size-1);
            heapify(max,0,--size);
            res[count++] = cur.val;
            p1 = cur.p1;
            p2 = cur.p2;
            if(p1 > 0 && p2 > 0){
                heapInsert(max,++size,new Node(p1-1,p2,arr1[p1-1]+arr2[p2]));
                heapInsert(max,++size,new Node(p1,p2-1,arr1[p1]+arr2[p2-1]));
            }else if(p1 > 0){
                heapInsert(max,++size,new Node(p1-1,p2,arr1[p1-1]+arr2[p2]));
            }else{
                heapInsert(max,++size,new Node(p1,p2-1,arr1[p1]+arr2[p2-1]));
            }
        }
        return res;
    }



    public static void heapify(Node[] arr,int i,int len){
        for(int j = 2*i+1;j<len;j=j*2+1){
            if(j+1<len && arr[j].val < arr[j+1].val){
                j++;
            }
            if(arr[i].val < arr[j].val){
                swap(arr,i,j);
                i = j;
            }else{
                break;
            }
        }
    }

    public static void heapInsert(Node[] arr,int len,Node cur){
        arr[len-1] = cur;
        int index = len - 1;
        int parent = (index - 1)>>1;
        while(parent >= 0){
            if(arr[index].val > arr[parent].val){
                swap(arr,index,parent);
                index = parent;
                parent = (index - 1)>>1;
            }else{
                break;
            }
        }
    }

    private static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
