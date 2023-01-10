package ru.ddark008.leetcode.leetcode;

public class L1493_LongestSubarrayOf1AfterDeletingOneElement {
    // {1}
    // {0}
    public int longestSubarray(int[] nums) {
        int l = 0; //0
        int r = 0; //4
        int count = 0; //1
        while(r < nums.length){
            if (nums[r] == 0) count++;
            r++;
            if (count > 1){
                if (nums[l] == 0) count--;
                l++;
            }
        }
        return r-l-1;
    }
}
