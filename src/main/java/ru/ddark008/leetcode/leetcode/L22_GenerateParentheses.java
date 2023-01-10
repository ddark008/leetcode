package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] a = new char[2*n];
        a[0] = '(';
        gen(a, 1, 0, n, result);
        return result;
    }
    // "(" 1, 0, 3
    // "((" 2 0 3,  "()" 1 1 3,
    // "(((" 3 0 3, "(()" 2 1 3, "()(" 2 1 3
    // "((()" 3 1 3, "(()(" 3 1 3, "()((" 3 1 3, "()()" 2 2 3
    // "((())" 3 2 3, "(()()" 3 2 3, "()(()" 3 2 3, "()()(" 3 2 3
    // "((()))" 3 3 3, "(()())" 3 3 3, "()(())" 3 3 3, "()()()" 3 3 3

    private void gen(char[] a, int l, int r, int n, List<String> result){
        if (l < n){
            a[l+r] = '(';
            gen(a, l+1, r, n, result);
        }
        if (r < l){
            a[l+r] = ')';
            gen(a, l, r+1, n, result);
        }
        if (l == n && r == n){
            result.add(String.valueOf(a));
            return;
        }
    }
}
