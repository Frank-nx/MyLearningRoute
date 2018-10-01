package com.nixuan.test1;

import java.util.*;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-09-18 20:41
 **/
public class Main7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        String target = arr[0];
        List<Integer> list = new LinkedList<>();
        for(int i = 1;i<arr.length;i++){
            int num = findMinCost(target,target.length(),arr[i],arr[i].length());
            list.add(num);
        }

    }

    public static int findMinCost(String A, int n, String B, int m) {
        // write code here
        int[][] res = new int[n+1][m+1];
        int ic = 3;
        int dc = 3;
        int uc = 2;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<B.length();i++){
            set.add(B.charAt(i));
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    res[i][j] = ic * j;
                }else if(j==0){
                    res[i][j] = dc*i;
                }else{
                    // 将最小值得初始值设成最高
                    int min = Integer.MAX_VALUE;
                    int useDc = res[i-1][j] + dc;
                    int useIc = res[i][j-1] + ic;
                    min = min<=useDc?min:useDc;
                    min = min<=useIc?min:useIc;
                    if(A.charAt(i-1) == B.charAt(j-1)){
                        min = min <= res[i-1][j-1]?min:res[i-1][j-1];
                    }
                    else{
                        if(set.contains(A.charAt(i-1))){
                            uc = 1;
                        }
                        int useUp = res[i-1][j-1] + uc;
                        min=min<=useUp?min:useUp;
                    }
                    res[i][j] = min;
                }
            }
        }
        for (int i=0;i<=n;i++){
            System.out.println(Arrays.toString(res[i]));
        }
        return res[n][m];
    }

    public int getS(List<Integer> list){
        if(list.isEmpty()){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=1;i<list.size();i++){
            //if()
        }
        return 0;
    }

}
