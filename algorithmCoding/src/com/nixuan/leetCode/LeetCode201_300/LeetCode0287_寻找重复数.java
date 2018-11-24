package com.nixuan.leetCode.LeetCode201_300;

/**
 * @program: MyLearningRoute
 * @description:
 * @author: nixuan
 * @create: 2018-11-23 22:14
 **/
public class LeetCode0287_寻找重复数 {

    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int left = 1;
        int right = nums.length-1;
        while(left < right){
            if(nums[left] == nums[right]){
                return nums[left];
            }
            int mid = ((right-left)>>1)+left;
            if(count(nums,left,mid) >mid-left+1){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int count(int[] nums,int left,int right){
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= right && nums[i] >= left){
                res++;
            }
        }
        return res;
    }

    // 方法二：使用有环链表的思想
    public int findDuplicate1(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast){
                break;
            }
        }
        return slow;
    }
}
