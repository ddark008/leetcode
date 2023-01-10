package ru.ddark008.leetcode.leetcode;

public class L1706_WhereWillTheBallFall {
    /**
     Input: grid = [[1,1,1,-1,-1],
     [1,1,1,-1,-1],
     [-1,-1,-1,1,1],
     [1,1,1,1,-1],
     [-1,-1,-1,-1,-1]]

     [1,2,-1,-1,3]
     Output: [1,-1,-1,-1,-1]
     **/
    public int[] findBall(int[][] grid) {
        int[] balls = new int[grid[0].length];
        for(int i=0; i<grid[0].length; i++) balls[i]=i;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<balls.length; j++){
                if (balls[j] == -1) continue;
                if (balls[j]<grid[0].length-1&&grid[i][balls[j]]==1&&grid[i][balls[j]+1]==1){
                    balls[j]++;
                } else if (balls[j]>0&&grid[i][balls[j]]==-1&&grid[i][balls[j]-1]==-1){
                    balls[j]--;
                } else {
                    balls[j] = -1;
                }
            }
        }
        return balls;
    }
}
