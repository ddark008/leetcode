package ru.ddark008.leetcode.leetcode;

public class L48_RotateImage {
    public void rotate(int[][] matrix) {
        int size = matrix.length-1;// 3
        for(int i = 0; i < matrix.length-1; i++){ // i = 1
            for (int j = i; j < size-i; j++){ // j = 1
                int tmp = matrix[j][size-i]; // 8
                matrix[j][size-i] = matrix[i][j];

                int tmp2 = matrix[size-i][size-j]; // 8
                matrix[size-i][size-j] = tmp;

                tmp = matrix[size-j][i]; // 4
                matrix[size-j][i] = tmp2;

                matrix[i][j] = tmp;
            }
        }

    }
    public void rotate2(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for (int j = i+1; j < matrix.length; j++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        for(int i = 0; i<matrix.length; i++){
            for (int j = 0; j< matrix.length/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = tmp;
            }
        }

    }
}
