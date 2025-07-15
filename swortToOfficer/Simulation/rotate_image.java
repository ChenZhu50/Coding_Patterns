package Simulation;
import java.util.*;

public class rotate_image {
    public static void rotate(int[][] matrix) {
        //edge case
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        //initial temp
        int temp = 0;

        //transpose a matrix:
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j< matrix[0].length; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //rotate the row
        for(int[] row : matrix){
            int left = 0, right = matrix[0].length -1;
            while(left < right){
                temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test1 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int[][] expected1 = {
            {7,4,1},
            {8,5,2},
            {9,6,3}
        };

        int[][] test2 = {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        int[][] expected2 = {
            {15,13,2,5},
            {14,3,4,1},
            {12,6,8,9},
            {16,7,10,11}
        };

        int[][] result1 = deepCopy(test1);
        int[][] result2 = deepCopy(test2);
        rotate(result1);
        rotate(result2);
        System.out.println("Test 1: " + Arrays.deepToString(result1) + " | Correct? " + Arrays.deepEquals(result1, expected1));
        System.out.println("Test 2: " + Arrays.deepToString(result2) + " | Correct? " + Arrays.deepEquals(result2, expected2));
    }

    // Helper method to deep copy a 2D array
    private static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
}
