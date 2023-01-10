package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L38_CountAndSay {
    public String countAndSay(int n) {
        List<Integer> r = new ArrayList<>();
        r.add(1);
        for (int i = 1; i<n; i++){
            r = map(r);
        }
        StringBuilder sb = new StringBuilder();
        for(var i:r){
            sb.append(i);
        }
        return sb.toString();
    }
    public List<Integer> map(List<Integer> l){
        List<Integer> r = new ArrayList<>();
        int t = l.get(0);
        int n = 1;
        for(int i = 1; i<l.size(); i++){
            if (l.get(i) != t){
                r.add(n);
                r.add(t);
                t = l.get(i);
                n = 1;
            } else {
                n++;
            }
        }
        r.add(n);
        r.add(t);
        return r;
    }
}
