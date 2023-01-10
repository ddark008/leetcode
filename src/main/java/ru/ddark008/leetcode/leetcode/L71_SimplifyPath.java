package ru.ddark008.leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class L71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> list = new LinkedList<>();
        for(var s: parts){
            if (s.isEmpty() || s.equals(".")) continue;
            if (s.equals("..")) {
                if (list.size()>0) list.removeLast();
            }
            else {
                list.addLast(s);
            }
        }
        if (list.size() == 0) return "/";

        StringBuilder sb = new StringBuilder();
        for(var s:list){
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }
}
