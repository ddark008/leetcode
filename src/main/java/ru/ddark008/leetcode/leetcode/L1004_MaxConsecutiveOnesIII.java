package ru.ddark008.leetcode.leetcode;

public class L1004_MaxConsecutiveOnesIII {
    // CPU: O(N)
    // MEM: O(1)
    public int longestOnes(int[] nums, int k) {
        int l = 0; // 0
        int r = 0; // 3
        int counter = 0;
        while(r < nums.length){
            if (nums[r] == 1){
                r++;
            } else {
                if (k > 0){ // 1
                    k--;
                    r++;
                } else {
                    if(nums[l] == 0) k++;
                    l++;
                }
            }
            counter = Math.max(counter, r-l); // 3
        }
        return counter;
    }
}
