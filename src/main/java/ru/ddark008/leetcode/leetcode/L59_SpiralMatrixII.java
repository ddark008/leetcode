package ru.ddark008.leetcode.leetcode;

public class L59_SpiralMatrixII {
    /**
         0 1 2
     0 [1][2][3]
     1 [8][9][4]
     2 [7][6][5]
     **/
    public int[][] generateMatrix(int n) {
        int[][] r = new int[n][n];

        int cur = 1;
        int rowStart = 0; //2
        int rowEnd = n-1; //1
        int colStart = 0; //1
        int colEnd = n-1; //0

        while(cur <= n*n){ // < 9
            //horisontal right
            for(int i = colStart; i<=colEnd; i++){ //1 //1
                r[rowStart][i] = cur++;
            }
            rowStart++;
            // vertical down
            for(int i = rowStart; i<=rowEnd; i++){ //1 //2
                r[i][colEnd] = cur++;
            }
            colEnd--;
            //horisontal left
            for(int i = colEnd; i>=colStart; i--){ //1 //0
                r[rowEnd][i] = cur++;
            }
            rowEnd--;
            // vertical up
            for(int i = rowEnd; i>=rowStart; i--){ //1 //1
                r[i][colStart] = cur++;
            }
            colStart++;
        }
        return r;
    }
}
