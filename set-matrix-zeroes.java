/** https://leetcode.com/problems/set-matrix-zeroes/ */
class Solution {
    public static void main(String[] args) {
        int[][] input = {
                { 1, 2, 3, 4 },
                { 5, 0, 7, 8 },
                { 0, 10, 11, 12 },
                { 13, 14, 15, 0 }
        };
        setZeroes(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    public static void setZeroes(int[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        boolean originRow = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        originRow = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                    matrix[0][j] = 0;
                }
            }
        }
        // zero out the columns keeping the first row as reference
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < columns; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // zero out the rows keeping the first column as reference
        for (int j = 1; j < columns; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // if any of the 0th index of row is zero
        // zero out the 1st column
        if (matrix[0][0] == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
        // if the origin element is was initially zero
        // then zero out the entire row
        if (originRow) {
            for (int j = 0; j < columns; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
