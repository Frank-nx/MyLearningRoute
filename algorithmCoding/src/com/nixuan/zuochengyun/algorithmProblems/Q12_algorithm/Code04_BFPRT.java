package com.nixuan.zuochengyun.algorithmProblems.Q12_algorithm;


import java.util.Arrays;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-10-24 14:37
 **/
public class Code04_BFPRT {

    public static void main(String[] args) {
        int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };

        int[] res = minKthNumsByBFPRT(arr,11);
        System.out.println(Arrays.toString(res));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] minKthNumsByBFPRT(int[] arr,int k){
        if(arr == null || k < 1 || arr.length < 1 ||arr.length < k){
            return null;
        }
        // 使用BFPRT算法得到第k小的数kthNum
        int kthNum = getKthMInNumByBFPRT(arr,0,arr.length - 1,k);
        int[] res = new int[k];
        int index = 0;
        // 将小于kthNum的数放到结果数组中
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < kthNum){
                res[index++] = arr[i];
            }
        }
        //小于kthNum的数个数小于k个时，剩下的数全部用kthNum填充
        while(index < k){
            res[index++] = kthNum;
        }
        // 返回最小的前k的数的数组
        return res;
    }

    private static int getKthMInNumByBFPRT(int[] arr, int left, int right, int k) {
        if(left == right){
            return arr[left];
        }
        // 将原数组进行复制
        int[] copy = copyArr(arr);
        // 得到中位数的中位数median
        int median = getMedianOfMedian(copy,left,right);
        // 按median进行划分小于等于大于三部分，中间等于区域的索引范围
        int[] range = partition(copy,left,right,median);
        // 在等于区域的范围内，直接返回
        if(k >= range[0] && k <= range[1]){
            return copy[k];
        // k在等于区域的左边，即在小于区域，再对左边的区域进行BFPRT算法即可
        }else if(k < range[0]){
            return getKthMInNumByBFPRT(copy,left,range[0]-1,k);
        // k在等于区域的右边，即在大于区域，再对右边的区域进行BFPRT算法即可
        }else{
            return getKthMInNumByBFPRT(copy,range[1]+1,right,k);
        }
    }

    // 对copy数组使用median进行partition操作，大于median放左边，等于median放中间，大于median放右边
    private static int[] partition(int[] copy, int left, int right, int median) {
        int less = left - 1;
        int more = right + 1;
        int cur = left;
        while(cur < more){
            if(copy[cur] < median){
                swap(copy,++less,cur++);
            }else if(copy[cur] > median){
                swap(copy,cur,--more);
            }else{
                cur++;
            }
        }
        return new int[]{less+1,more-1};
    }

    private static int getMedianOfMedian(int[] copy, int left, int right) {
        int len = right - left + 1;
        // 检查区间长度是否能被5整除，如果不足5个剩下的数作为一组
        int offset = len%5==0?0:1;
        // median是存放每个数组中位数的数组
        int[] median = new int[len/5+offset];
        int index = 0;
        for(int i = left;i <= right;i = i+5){
            // 取最小值是因为最后一组可能没有5个数
            int end = Math.min(i + 4,right);
            // 采用插入排序
            insertSort(copy,i,end);
            // 取每组的中位数
            median[index++] = copy[(i+end)>>1];
        }
        // 求中位数组成的数组的中位数
        return getKthMInNumByBFPRT(median,0,median.length-1,median.length/2);
    }

    private static void insertSort(int[] copy, int left, int right) {
        for(int i = left+1;i<=right;i++){
            for (int j = i-1; j >=left ; j--) {
                if(copy[j] > copy[j+1]){
                    swap(copy,j,j+1);
                }else{
                    break;
                }
            }
        }
    }

    private static void swap(int[] copy, int j, int i) {
        int temp = copy[j];
        copy[j]=  copy[i];
        copy[i] = temp;
    }

    private static int[] copyArr(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


}
