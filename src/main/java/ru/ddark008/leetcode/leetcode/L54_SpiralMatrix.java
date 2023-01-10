package ru.ddark008.leetcode.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> r = new LinkedList<>();

        int rowStart=0;  // 2
        int rowEnd=matrix.length-1; // 1
        int colStart=0; //1
        int colEnd=matrix[0].length-1; //1
        int count = 0;
        int size = matrix.length*matrix[0].length;
        while(r.size() < size){
            for(int i=colStart; i<=colEnd; i++){
                r.add(matrix[rowStart][i]);
            }
            rowStart++;
            if(r.size() >= size) break;

            for(int i=rowStart; i<=rowEnd; i++){
                r.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(r.size() >= size) break;

            for(int i=colEnd; i>=colStart; i--){
                r.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            if(r.size() >= size) break;

            for(int i=rowEnd; i>=rowStart; i--){
                r.add(matrix[i][colStart]);
            }
            colStart++;
            if(r.size() >= size) break;
        }
        return r;
    }
}
