package ru.ddark008.leetcode.leetcode;

import java.util.Arrays;

public class L2279_MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remain = new int[capacity.length];
        /*
        capacity = [2,3,4,5]
        rocks = [1,2,4,4]

        additionalRocks = 2
        */
        for(int i=0; i<capacity.length; i++){
            remain[i] = capacity[i] - rocks[i];
        }
        // capacity = [1,1,0,1]
        Arrays.sort(remain);
        // capacity = [0,1,1,1]
        int count = 0; //3
        for (int j : remain) {
            if (j <= additionalRocks) { // 0
                additionalRocks -= j;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
