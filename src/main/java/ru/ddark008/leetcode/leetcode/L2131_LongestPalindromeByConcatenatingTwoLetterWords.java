package ru.ddark008.leetcode.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L2131_LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> mirrored = new HashMap<>();
        int counter = 0;
        for (var w: words){
            mirrored.putIfAbsent(w, 0);
            if (mirrored.get(w) > 0){
                counter += 4;
                mirrored.compute(w, (k,v)-> v-1);
            } else {
                String m = mirror(w);
                mirrored.putIfAbsent(m, 0);
                mirrored.compute(m, (k,v)-> v+1);
            }
        }
        for (var w: mirrored.entrySet()){
            if (w.getValue() > 0 && w.getKey().charAt(0) == w.getKey().charAt(1)){
                counter += 2;
                break;
            }
        }
        return counter;
    }
    private String mirror(String s){
        char[] ch = new char[] {s.charAt(1), s.charAt(0)};
        return String.valueOf(ch);
    }

    public int longestPalindrome2(String[] words) {
        int[][] map = new int[26][26];
        int counter = 0;
        for (var w: words){
            int a = w.charAt(0) - 'a';
            int b = w.charAt(1) - 'a';
            if (map[b][a] > 0){
                counter += 4;
                map[b][a]-- ;
            } else {
                map[a][b]++;
            }
        }
        for (int i=0; i < map.length; i++){
            if (map[i][i] > 0) {
                counter += 2;
                break;
            }
        }
        return counter;
    }
}
