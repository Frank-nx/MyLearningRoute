package testMethod;

public class testHeap {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        heapSort(arr,arr.length);
    }

    private static void heapSort(int[] arr, int k) {
        if(arr == null || arr.length < 1){
            return;
        }
        for(int i = (k>>1)-1;i>=0;i--){

        }
    }
}
