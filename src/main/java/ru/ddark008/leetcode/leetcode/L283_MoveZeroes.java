package ru.ddark008.leetcode.leetcode;

public class L283_MoveZeroes {
    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    public void moveZeroes(int[] nums) {
        int w = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[w++] = nums[i];
            }
        }
        while(w <  nums.length){
            nums[w++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int w = 0;
        int r = 0;
        int t;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                t = nums[w];
                nums[w++] = nums[i];
                nums[i] = t;
            }
        }
    }
}
