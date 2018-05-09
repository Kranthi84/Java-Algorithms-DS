package com.kranthi.sorting;

public class C_Prob11_6 {

    public static boolean searchMatrix(int[][] matrix, int sElement) {
        int row = 0;
        int column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] > sElement) {
                column--;
            } else if (matrix[row][column] < sElement) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
