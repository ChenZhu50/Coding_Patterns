package Simulation;
import java.util.*;

public class spiral_matrix_II {
    public static int[][] generateMatrix(int n) {
        int top = 0, bottom = n-1, left = 0, right = n-1;
        int [][] result = new int[n][n];
        int direction = 0;
        int numbers = 1;
        

        while(top <= bottom && left <= right ){
            System.out.println("spiral_matrix_II");
            if(direction == 0){
                System.out.println("spiral_matrix_II");
                for(int i = left; i <= right; i++){
                    result[top][i] = numbers;
                    numbers++;
                    System.out.println("spiral_matrix_II");
                }
                top++;
                direction = (direction+1) % 4;
            }

            else if(direction == 1){
                for(int i = top; i<= bottom; i++){
                    result[i][right] = numbers;
                    numbers++;
                }
                right--;
                direction = (direction+1) % 4;
            }

            else if(direction == 2){
                for(int i = right; i >=left; i--){
                    result[bottom][i] = numbers;
                    numbers++;
                }
                bottom --;
                direction = (direction+1) % 4;
            }

            else if(direction == 3){
                for(int i = bottom; i >= top; i--){
                    result[i][left] = numbers;
                    numbers++;
                }
                left++;
                direction = (direction+1) % 4;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] expected1 = {
            {1,2,3},
            {8,9,4},
            {7,6,5}
        };
        int n2 = 1;
        int[][] expected2 = {
            {1}
        };
        int n3 = 4;
        int[][] expected3 = {
            {1,2,3,4},
            {12,13,14,5},
            {11,16,15,6},
            {10,9,8,7}
        };

        int[][] result1 = generateMatrix(n1);
        int[][] result2 = generateMatrix(n2);
        int[][] result3 = generateMatrix(n3);
        System.out.println("Test 1: " + Arrays.deepToString(result1) + " | Correct? " + Arrays.deepEquals(result1, expected1));
        System.out.println("Test 2: " + Arrays.deepToString(result2) + " | Correct? " + Arrays.deepEquals(result2, expected2));
        System.out.println("Test 3: " + Arrays.deepToString(result3) + " | Correct? " + Arrays.deepEquals(result3, expected3));
    }
}
