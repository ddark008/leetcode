package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L797_AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        dfs(graph, result, current);
        return result;
    }
    // {0 1 3},
    // 0
    // 0 2 3
    public void dfs(int[][] graph, List<List<Integer>> result, List<Integer> current){
        int next = current.get(current.size()-1);
        if (next == graph.length -1) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (var i: graph[next]){
            current.add(i);
            dfs(graph, result, current);
            current.remove(current.size()-1);
        }
    }
}
