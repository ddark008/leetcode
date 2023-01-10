package ru.ddark008.leetcode.leetcode;

import java.util.*;

public class L841_KeysAndRooms {
    // [1] [2,3] [] []
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>(); //1 2 3
        List<Integer> keys = rooms.get(0);
        for(var k:keys){
            queue.offer(k);
        }
        visited.add(0);

        while(queue.size()>0){ //
            int room = queue.poll();
            visited.add(room);
            keys = rooms.get(room);
            for(var k:keys){
                if (!visited.contains(k)){
                    queue.offer(k);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}
