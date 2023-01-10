package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 Input
 ["RecentCounter", "ping", "ping", "ping", "ping"]
 [[], [1], [100], [3001], [3002]]
 Output
 [null, 1, 2, 3, 3]

 Explanation
 RecentCounter recentCounter = new RecentCounter();
 recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
 recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
 recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
 recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 **/
public class L933_NumberOfRecentCalls {
    class RecentCounter {

        // {1, 100, 3001, 3002}
        List<Integer> ts = new ArrayList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            ts.add(t);
            int l = Lbins(t-3000);
            return ts.size()-l;
        }

        // 2
        private int Lbins(int t){
            int l = 0;
            int r = ts.size()-1; //1
            while(l<r){
                int m = (l+r)/2; // 0
                if(ts.get(m) >= t){
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }
    }

    class RecentCounter2 {
        Deque<Integer> ts = new LinkedList<>();

        public RecentCounter2() {

        }

        public int ping(int t) {
            ts.addLast(t);
            while(ts.peekFirst() < t-3000){
                ts.removeFirst();
            }
            return ts.size();
        }
    }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
