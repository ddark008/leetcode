package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int l, r;
        for(int i = 0; i<nums.length-2; i++){ //0
            if (i == 0 || nums[i] != nums[i-1]){
                l = i+1; //1
                r = nums.length-1; //2
                while(l<r){
                    if (l != i+1 && nums[l] == nums[l-1]){
                        l++;
                    } else if (r != nums.length-1 && nums[r] == nums[r+1]){
                        r--;
                    } else {
                        if (nums[i]+nums[l]+nums[r] == 0){
                            result.add(List.of(nums[i],nums[l],nums[r]));
                        }
                        if (nums[i]+nums[l]+nums[r] < 0){
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
