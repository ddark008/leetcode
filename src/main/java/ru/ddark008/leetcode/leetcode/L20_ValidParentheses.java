package ru.ddark008.leetcode.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 *
 *     1 <= s.length <= 104
 *     s consists of parentheses only '()[]{}'.
 */

/**
 * CPU: O(N)
 * MEM: O(1)
 */
public class L20_ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for(var ch: s.toCharArray()){
            if (ch == '{' || ch == '(' || ch == '['){
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char openCh = stack.poll();
                if (ch == '}' && openCh != '{') {
                    return false;
                }
                if (ch == ')' && openCh != '(') {
                    return false;
                }
                if (ch == ']' && openCh != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
