package ru.ddark008.leetcode.leetcode;

/**
 * CPU: O(M*N)
 * MEM O(M*N)
 */
public class L200_NumberOfIslands {
    //     0   1   2
    // 0  [1] [0] [0]
    // 1  [0] [1] [1]

    // m
    //     0   1   2
    // 0  [1] [0] [0]
    // 1  [0] [0] [0]

    public int numIslands(char[][] grid) {
        int[][] m = new int[grid.length][grid[0].length];  // 2; 3
        int counter = 0; // 1
        for(int i = 0; i < grid.length; i++){ // 1
            for(int j = 0; j < grid[0].length; j++){ // 1
                if (grid[i][j] == '1' && m[i][j] != 1){
                    markIsland(grid, m, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }
    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

    void markIsland(char[][] grid, int[][] m, int i, int j){
        m[i][j] = 1;

        for (int[] d: dir){
            int k = Math.min(Math.max(i+d[0], 0), grid.length-1); // 1
            int f = Math.min(Math.max(j+d[1], 0), grid[0].length-1); // 3
            if (m[k][f] != 1 && grid[k][f] == '1'){
                markIsland(grid, m, k, f);
            }
        }
    }
}

