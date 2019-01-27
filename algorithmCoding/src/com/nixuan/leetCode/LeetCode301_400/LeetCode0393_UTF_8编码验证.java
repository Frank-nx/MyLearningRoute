package com.nixuan.leetCode.LeetCode301_400;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/25 9:21
 **/
public class LeetCode0393_UTF_8编码验证 {

    public static void main(String[] args) {
        int[] data = {197,130,1};
        boolean res = validUtf8(data);
        System.out.println(res);
    }

    public static boolean validUtf8(int[] data) {
        if (data == null || data.length < 1){
            return true;
        }
        int index = 0;
        while(index < data.length){
            int numOfOne = getHeadOne(data[index]);
            //System.out.println("data[" + index + "],numOfOne:" + numOfOne);
            if (numOfOne == 1 || numOfOne > 4){
                return false;
            }
            if (numOfOne == 0){
                index++;
            }else{
                int curNum = 1;
                index++;
                while(curNum < numOfOne && index < data.length){
                    if (getHeadOne(data[index]) != 1){
                        return false;
                    }
                    index++;
                    curNum++;
                }
                if (curNum != numOfOne){
                    return false;
                }
            }
        }
        return true;
    }

    public static int getHeadOne(int data){
        int index = 0;
        int refer = 0x80;
        while((data & refer)!=0){
            index++;
            refer = refer >> 1;
        }
        return index;
    }

}
