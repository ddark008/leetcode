package ru.ddark008.leetcode.leetcode;

public class L238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // CPU: 2N
        // MEM: O(2N)

        //  {1,2,3}
        //  {1,1,2,6}
        //  {6,3,1}
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        int[] result = new int[nums.length];
        l[0] = 1;
        for (int i = 0; i<nums.length-1; i++){
            l[i+1] = l[i]*nums[i];
        }
        r[r.length-1] = 1;
        for (int i = nums.length-1; i>0; i--){
            r[i-1] = r[i]*nums[i];
        }
        for(int i = 0; i< nums.length; i++){
            result[i] = l[i] * r[i];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        // CPU: 2N
        // MEM: O(1)
        int[] r = new int[nums.length];
        r[0] = 1;
        for (int i = 0; i<nums.length-1; i++){
            r[i+1] = r[i]*nums[i];
        }
        int right = 1;
        for (int i = nums.length-1; i>0; i--){
            right = right*nums[i];
            r[i-1] *= right;
        }
        return r;
    }
}
