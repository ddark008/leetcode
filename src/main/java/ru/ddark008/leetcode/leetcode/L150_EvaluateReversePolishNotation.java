package ru.ddark008.leetcode.leetcode;

import java.util.Stack;

public class L150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(var s: tokens){
            switch (s) {
                case "+" -> stack.push(stack.pop()+stack.pop());
                case "-" -> stack.push(-stack.pop()+stack.pop());
                case "*" -> stack.push(stack.pop()*stack.pop());
                case "/" -> {
                    int i2 =  stack.pop();
                    int i1 =  stack.pop();
                    stack.push(i1/i2);
                }
                default -> stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
