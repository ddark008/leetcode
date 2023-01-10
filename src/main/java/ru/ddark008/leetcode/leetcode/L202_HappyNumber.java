package ru.ddark008.leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L202_HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();

        while(n != 1 && !nums.contains(n)){
            nums.add(n);
            int sum = 0;
            while(n != 0){
                int p = n%10;
                sum += p*p;
                n = n/10;
            }
            n = sum;
        }
        return n == 1;
    }
}
