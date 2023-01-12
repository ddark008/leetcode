package ru.ddark008.leetcode.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1519_NumberOfNodesInTheSubTreeWithTheSameLabel {
    // CPU: O(N)
    // MEM: O(N)
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (var e : edges) {
            nodes.putIfAbsent(e[0], new HashSet<>());
            nodes.putIfAbsent(e[1], new HashSet<>());
            nodes.get(e[0]).add(e[1]);
            nodes.get(e[1]).add(e[0]);
        }
        int[] r = new int[n];
        dfs(nodes, labels, r, 0, -1);
        return r;
    }

    public Map<Character, Integer> dfs(Map<Integer, Set<Integer>> nodes, String labels, int[] r, int node, int parent) {
        Map<Character, Integer> count = new HashMap<>();
        if (nodes.containsKey(node)) {
            for (var i : nodes.get(node)) {
                if (i == parent) continue;
                var child = dfs(nodes, labels, r, i, node);
                child.forEach((k, v) -> count.merge(k, v, Integer::sum));
            }
        }
        count.merge(labels.charAt(node), 1, Integer::sum);
        r[node] = count.get(labels.charAt(node));
        return count;
    }
}
