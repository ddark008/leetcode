package ru.ddark008.leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L567_PermutationInString {
    static boolean checkInclusion(String s1, String s2) {
        int a = 'a';
        int[] n = new int[100];
        // a = 1
        // b = 0
        for (int i = 0; i < s1.length(); i++) {
            n[s1.charAt(i) - a]++;
        }
        int l = 0; //1
        int r = 0; //1
        int counter = s1.length(); // 1
        while (counter > 0 && l < s2.length() && r < s2.length()) {
            if (n[s2.charAt(r) - a] > 0) {
                n[s2.charAt(r) - a]--;
                r++;
                counter--;
            } else if (l < r) {
                n[s2.charAt(l) - a]++;
                l++;
                counter++;
            } else {
                l++;
                r++;
            }
        }
        return counter == 0;
    }
    public static boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        while (l < s2.length() && r < s2.length()) {
            Integer lVal = map.get(s2.charAt(l));
            Integer rVal = map.get(s2.charAt(r));
            if (lVal != null && rVal != null && rVal > 0) {
                if (r - l + 1 == s1.length()) {
                    return true;
                }
                map.put(s2.charAt(r), rVal - 1);
                r++;
            } else {
                if (lVal != null) {
                    map.put(s2.charAt(l), lVal + 1);
                }
                l++;
            }
            r = Math.max(l, r);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("pqzhi", "ghrqpihzybre"));
    }
}
