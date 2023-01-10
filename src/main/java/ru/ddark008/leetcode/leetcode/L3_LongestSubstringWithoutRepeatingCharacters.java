package ru.ddark008.leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // CPU O(N)
        // MEM O(1)
        // bb
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int size = 0;
        while(r < s.length()){
            Character r_ch = s.charAt(r);
            if (!set.contains(r_ch)){
                set.add(r_ch); // b
                r++; // 2
            } else {
                set.remove(s.charAt(l));
                l++; //1
            }
            size = Math.max(size, r-l); // 1
        }
        return size;
    }
}
