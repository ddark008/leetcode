package ru.ddark008.leetcode.leetcode;

import java.util.*;

public class L56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list);
        List<Interval> result = new ArrayList<>();
        int s = list.get(0).start;
        int e = list.get(0).end;
        for(int i=1; i<list.size(); i++){
            if (list.get(i).start > e){
                result.add(new Interval(s, e));
                s=list.get(i).start;
                e=list.get(i).end;
            } else if (list.get(i).end > e){
                e=list.get(i).end;
            }
        }
        result.add(new Interval(s, e));
        int[][] r = new int[result.size()][2];
        for(int i=0; i<result.size(); i++){
            r[i][0] = result.get(i).start;
            r[i][1] = result.get(i).end;
        }
        return r;

    }
    static class Interval implements Comparable<Interval>{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval o2){
            if (this.start != o2.start){
                return Integer.compare(this.start, o2.start);
            } else {
                return Integer.compare(this.end, o2.end);
            }
        }
    }

    public int[][] merge2(int[][] intervals) {
        //CPU N*LogN + N/2
        //MEM N
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]){
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int[][] r = new int[intervals.length][2];

        int counter = 0;
        int s = intervals[0][0];
        int e = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if (intervals[i][0] > e){
                r[counter][0] =s;
                r[counter++][1] =e;
                s=intervals[i][0];
                e=intervals[i][1];
            } else if (intervals[i][1] > e){
                e=intervals[i][1];
            }
        }
        r[counter][0] =s;
        r[counter++][1] =e;

        return Arrays.copyOf(r,counter);
    }

    public int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
