package ru.ddark008.leetcode.leetcode;

import java.util.Arrays;

public class L452_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        // [0,1] [1,2]
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int arrow = points[0][1]; // 1
        for(var a: points){
            if (a[0] > arrow){
                count++;
                arrow = a[1];
            }
        }
        return count;
    }
}
