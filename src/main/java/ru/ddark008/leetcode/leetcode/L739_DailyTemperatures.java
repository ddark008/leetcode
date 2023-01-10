package ru.ddark008.leetcode.leetcode;

import java.util.Stack;

public class L739_DailyTemperatures {
    // CPU: N
    // MEM: N
    // {1}
    // {1,2}
    // {2,1}
    // {1,5,1}
    public int[] dailyTemperatures(int[] temperatures) {
        int[] r = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = temperatures.length-1; i>=0; i--){ //0
            int d = 0;
            while(stack.size()>0){
                if (temperatures[i] < stack.peek()[0]){
                    d = stack.peek()[1] - i;
                    break;
                } else {
                    stack.pop();
                }
            }
            r[i] = d;
            stack.push(new int[]{temperatures[i], i}); // {5,2}
        }
        return r;
    }
}
