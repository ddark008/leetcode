package ru.ddark008.leetcode.leetcode;

import java.util.Stack;

public class L232_ImplementQueueUsingStacks {
    class MyQueue {
        Stack<Integer> main = new Stack<>();
        Stack<Integer> reversed = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            main.push(x);
        }

        public int pop() {
            if(reversed.isEmpty()){
                refill();
            }
            return reversed.pop();
        }

        public int peek() {
            if(reversed.isEmpty()){
                refill();
            }
            return reversed.peek();
        }

        public boolean empty() {
            return reversed.isEmpty() && main.isEmpty();
        }

        private void refill(){
            while(!main.isEmpty()){
                reversed.push(main.pop());
            }
        }
    }
//You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
