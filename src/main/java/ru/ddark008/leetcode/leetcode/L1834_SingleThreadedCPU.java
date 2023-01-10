package ru.ddark008.leetcode.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class L1834_SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[] r = new int[tasks.length];
        Queue<int[]> avialableTasks = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Queue<int[]> processigTasks = new PriorityQueue<>((a,b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });
        int time = 0; //5
        int count = 0; // 1 [0, 0, 1 ,0]
        // {1,4} {2,2}
        for (int i=0; i<tasks.length; i++){
            avialableTasks.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }
        while(!avialableTasks.isEmpty() || !processigTasks.isEmpty()){
            while(!avialableTasks.isEmpty() && avialableTasks.peek()[0] <= time){
                processigTasks.offer(avialableTasks.poll());
            }
            if (!avialableTasks.isEmpty() && processigTasks.isEmpty()){
                time =  avialableTasks.peek()[0];
            }
            if (!processigTasks.isEmpty()){
                int[] currentTask = processigTasks.poll();
                time += currentTask[1];
                r[count++] = currentTask[2];
            }
        }
        return r;
    }
}
