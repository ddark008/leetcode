package ru.ddark008.leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L974_SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prev = 0;
        map.put(0,1);
        int count = 0;
        for(var i: nums){
            prev += i;
            int s = (prev%k + k)%k;
            if (map.containsKey(s)){
                count += map.get(s);
            }
            map.compute(s, (key,v) -> v == null?1:v+1);
        }
        return count;
    }
    public int subarraysDivByK2(int[] nums, int k) {
        int count=0;
        int[] freq =new int[k];
        freq[0]++;
        int sum=0;
        for(int i:nums)
        {
            sum+=i;
            int rem=sum%k;
            if(rem<0) rem+=k;
            count+=freq[rem];
            freq[rem]++;
        }
        return count;
    }
}
