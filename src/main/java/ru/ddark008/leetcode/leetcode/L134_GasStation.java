package ru.ddark008.leetcode.leetcode;

public class L134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s = gas[0]-cost[0];
        int min = s;
        int index = 0;
        for (int i = 1; i<gas.length; i++){
            s = s + gas[i]-cost[i];
            if (min >= s){
                index = i;
                min = s;
            }
        }
        if (s < 0) return -1;
        if (index == gas.length -1) return 0;
        return index+1;
        //-2
        //-2 -2 -2 3 3
        //-2 -4 -6 -3 0
        //-1 -2 -1
        // [3 0 3] [1 2 3]
        // 2 -2 0
        // 2 0 0
    }
}
