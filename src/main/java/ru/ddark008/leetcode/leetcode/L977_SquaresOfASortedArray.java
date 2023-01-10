package ru.ddark008.leetcode.leetcode;

public class L977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] r = new int[nums.length];
        int c = nums.length-1;
        int s = 0;
        int e = nums.length-1; // 1
        while(s<=e){
            if (nums[s] < 0 && -nums[s] > nums[e]){
                r[c--] = nums[s]*nums[s];
                s++;
            } else {
                r[c--] = nums[e]*nums[e];
                e--;
            }
        }
        return r;
    }
}
