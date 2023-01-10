package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L228_SummaryRanges {
//Input: nums = [0,1,2,4,5,7]
//Output: ["0->2","4->5","7"]

    public List<String> summaryRanges(int[] nums) {
        List<String> r = new ArrayList<>();
        if (nums.length == 0) return r;
        int s = nums[0];
        StringBuilder sb = new StringBuilder(String.valueOf(s));
        for(int i = 1; i<nums.length; i++){
            if ((long)nums[i] - (long)nums[i-1] > 1){
                if (nums[i-1] != s){
                    sb.append('-').append('>');
                    sb.append(nums[i-1]);
                }
                r.add(sb.toString());
                s = nums[i];
                sb = new StringBuilder(s);
            }
        }
        if (nums[nums.length-1] != s){
            sb.append('-').append('>');
            sb.append(nums[nums.length-1]);
        }
        r.add(sb.toString());
        return r;
    }

    public List<String> summaryRanges2(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();

        if (n == 0) return res;
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        int start = 0;
        for (int i = 1; i < n; i++) {
            if ((long)nums[i] - nums[i-1] > 1) {
                if (i - start > 1) {
                    sb.append("->");
                    sb.append(nums[i-1]);
                }
                res.add(sb.toString());
                sb = new StringBuilder();
                sb.append(nums[i]);
                start = i;
            }
        }
        if (n - start > 1) {
            sb.append("->");
            sb.append(nums[n-1]);
        }
        res.add(sb.toString());
        return res;
    }
}
