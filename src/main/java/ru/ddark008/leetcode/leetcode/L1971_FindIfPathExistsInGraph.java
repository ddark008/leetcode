package ru.ddark008.leetcode.leetcode;

import java.util.*;

public class L1971_FindIfPathExistsInGraph {
    // 0 - 1, 2
    // 1 - 0, 2
    // 2 - 1, 0
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(var p:edges){
            addNode(p[0], p[1],  map);
            addNode(p[1], p[0], map);
        }
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(source);
        visited.add(source);
        while(queue.size()>0){
            int s = queue.pollLast();
            for(var i: map.get(s)){
                if (i == destination){
                    return true;
                }
                if (!visited.contains(i)){
                    visited.add(i);
                    queue.addFirst(i);
                }
            }
        }
        return false;
    }

    private void addNode(int a, int b, Map<Integer, List<Integer>> map){
        map.putIfAbsent(a, new ArrayList<>());
        map.get(a).add(b);
    }

    public static boolean validPath2(int n, int[][] edges, int source, int destination) {
        if (n == 1) return true;

        int[] root = new int[n];
        int[] range = new int[n];
        for(int i=0; i<n; i++){
            root[i]=i;
        }
        for(var e:edges){
            union(e[0],e[1], root, range);
        }
        return findRoot(source, root) == findRoot(destination, root);
    }
    static int findRoot(int x, int[] root){
        if (root[x] != x){
            root[x] = findRoot(root[x], root);
        }
        return root[x];
    }

    static void union(int a, int b, int[] root, int[] range){
        int rootA = findRoot(a, root);
        int rootB = findRoot(b, root);
        if (rootA != rootB){
            if(range[rootA] > range[rootB]){
                root[rootA] = root[rootB];
                range[rootB]++;
            } else {
                root[rootB] = root[rootA];
                range[rootA]++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(validPath2(3, new int[][]{{0,1},{1,2},{2,0}},0,2));
    }
}
