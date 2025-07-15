package Simulation;
import java.util.*;

public class spiral_matrix {
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>(); 
        }
        //set the border
        int top = 0;
        int bottom = matrix.length-1;
        int left =0;
        int right = matrix[0].length-1;
        int direction = 0;
        List<Integer> result = new ArrayList<>();


        while(top <= bottom && left <= right ){
            if(direction == 0){
                for(int i = left; i <= right; i ++){
                    result.add(matrix[top][i]);
                }
                top ++;
                direction = (direction + 1) % 4;
            }

             else if(direction == 1){
                for(int i =top; i <= bottom; i++){
                    result.add(matrix[i][right]);
                }
                direction = (direction + 1) % 4;
                right--;
            }

            else if(direction == 2){
               for(int i = right; i >= left; i--){
                    result.add(matrix[bottom][i]);
               }
               bottom --;
               direction = (direction + 1) % 4;
            }

            else if(direction == 3){
                for(int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                direction = (direction + 1) % 4;
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> expected1 = Arrays.asList(1,2,3,6,9,8,7,4,5);

        int[][] test2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9,10,11,12}
        };
        List<Integer> expected2 = Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7);

        int[][] test3 = {
            {1}
        };
        List<Integer> expected3 = Arrays.asList(1);

        List<Integer> result1 = spiralOrder(test1);
        List<Integer> result2 = spiralOrder(test2);
        List<Integer> result3 = spiralOrder(test3);
        System.out.println("Test 1: " + result1 + " | Correct? " + result1.equals(expected1));
        System.out.println("Test 2: " + result2 + " | Correct? " + result2.equals(expected2));
        System.out.println("Test 3: " + result3 + " | Correct? " + result3.equals(expected3));
    }
}
