package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> added = new HashSet<>();
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        add(nums, r, added, now);
        return r;
    }

    public void add(int[] nums, List<List<Integer>> r, Set<Integer> added, List<Integer> now){
        for (var i: nums){
            if(now.size() == nums.length){
                r.add(new ArrayList<>(now));
                return;
            }
            if (added.contains(i)) continue;
            added.add(i);
            now.add(i);
            add(nums, r, added, now);
            now.remove(now.size()-1);
            added.remove(i);
        }
    }
}
