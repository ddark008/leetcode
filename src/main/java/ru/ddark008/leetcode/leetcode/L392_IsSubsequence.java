package ru.ddark008.leetcode.leetcode;

public class L392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }
}
