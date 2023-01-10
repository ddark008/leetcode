package ru.ddark008.leetcode.leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 * Constraints:
 *
 *     3 <= nums.length <= 500
 *     -1000 <= nums[i] <= 1000
 *     -104 <= target <= 104
 */
public class L16_3SumClosest {

    // cpu: n*logn + n*n
    // mem: O(1)
    static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int dist = Integer.MAX_VALUE;
        int result = 0;
        int l,r;
        for(int i=0; i<nums.length-2; i++){ // 0
            l = i+1; //1
            r = nums.length-1; //3
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r]; // 2
                if (sum == target) return sum;
                int local_dist = Math.max(sum, target) - Math.min(sum, target); // 102
                if (local_dist < dist) {
                    dist = local_dist; // 102
                    result = sum; //2
                }
                if (sum < target){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,1,1,0}, -100));
    }
}
