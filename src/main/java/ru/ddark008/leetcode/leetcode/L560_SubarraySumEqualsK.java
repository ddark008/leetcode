package ru.ddark008.leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L560_SubarraySumEqualsK {
    // {1,1,1} k = 2
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prev = 0;
        map.put(0,1); // 0=1; 1=1; 2=1;
        int count = 0; //1
        for (int num : nums) {
            prev += num; // 3
            int s = prev - k; //
            if (map.containsKey(s)) {
                count += map.get(s);
            }
            map.compute(prev, (key, v) -> (v == null) ? 1 : v + 1);
        }
        return count;
    }
}
