package ru.ddark008.leetcode.leetcode;

import java.util.*;

public class L49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(String s: strs){
            Map<Character, Integer> chars = new HashMap<>();
            for(Character ch: s.toCharArray()){
                chars.compute(ch, (k, v)-> v==null ? 1:v+1);
            }
            map.compute(chars, (k,v) -> {
                if (v == null){
                    v = new ArrayList<>();
                }
                v.add(s);
                return v;
            });

        }
        List<List<String>> result = new ArrayList<>();
        for(var v: map.values()){
            result.add(v);
        }
        return result;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int[] count = new int[29];
            for(int i=0; i<s.length(); i++){
                count[s.charAt(i) -'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
