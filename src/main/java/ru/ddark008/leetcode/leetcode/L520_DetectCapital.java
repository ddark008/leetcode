package ru.ddark008.leetcode.leetcode;

public class L520_DetectCapital {
    // CPU: O(N)
    // MEM: O(1)
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        boolean isAllCap = isCap(word.charAt(0)) && isCap(word.charAt(1));
        for(int i=1; i < word.length(); i++){
            if (isAllCap && !isCap(word.charAt(i))) return false;
            if (!isAllCap && isCap(word.charAt(i))) return false;
        }
        return true;
    }

    public boolean isCap(char ch){
        return ch >= 'A' && ch <= 'Z';
    }
}
