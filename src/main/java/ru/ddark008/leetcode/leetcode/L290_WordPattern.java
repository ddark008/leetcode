package ru.ddark008.leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        if (pattern.length() == 1) return true;

        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> mapBack = new HashMap<>();
        for (int i=0; i<pattern.length(); i++){
            Character ch = pattern.charAt(i);
            String  word = words[i];
            map.putIfAbsent(ch, word);
            mapBack.putIfAbsent(word, ch);
            if (!map.get(ch).equals(word)) return false;
            if (!mapBack.get(word).equals(ch)) return false;
        }
        return true;
    }
}
