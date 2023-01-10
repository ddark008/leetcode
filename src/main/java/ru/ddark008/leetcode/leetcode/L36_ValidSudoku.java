package ru.ddark008.leetcode.leetcode;

import java.util.Arrays;

public class L36_ValidSudoku {
    // CPU: 9*9*3
    public boolean isValidSudoku(char[][] board) {
        int[] map = new int[9];
        for (char[] chars : board) {
            clear(map);
            for (int j = 0; j < board[0].length; j++) {
                if (chars[j] == '.') continue;

                int p = chars[j] - '0' - 1;
                if (map[p] != 0) return false;
                map[p]++;
            }
        }
        for(int i=0; i<board[0].length; i++){
            clear(map);
            for (char[] chars : board) {
                if (chars[i] == '.') continue;

                int p = chars[i] - '0' - 1;
                if (map[p] != 0) return false;
                map[p]++;
            }
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                clear(map);
                for(int k=i*3; k<i*3+3; k++){
                    for(int h=j*3; h<j*3+3; h++){
                        if (board[k][h] == '.') continue;

                        int p = board[k][h] - '0' -1;
                        if (map[p] != 0) return false;
                        map[p]++;
                    }
                }
            }
        }
        return true;
    }
    public void clear(int[] map){
        Arrays.fill(map, 0);
    }
}
