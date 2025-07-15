package Simulation;
import java.util.*;

public class zigzag_conversion {
    
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        boolean goDown = false;
        int currRow = 0;

        //for each row create a stringBuilder
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        //main function
        for(char c: s.toCharArray()){
            rows[currRow].append(c);
            if(currRow == 0 || currRow == numRows -1){
                goDown = !goDown;
            }
            currRow += goDown ? 1:-1;
        }

        //combine each rows
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows){
            if(row != null) result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String test1 = "PAYPALISHIRING";
        int numRows1 = 3;
        String test2 = "PAYPALISHIRING";
        int numRows2 = 4;
        String test3 = "A";
        int numRows3 = 1;
        String expected1 = "PAHNAPLSIIGYIR";
        String expected2 = "PINALSIGYAHRPI";
        String expected3 = "A";
        String result1 = convert(test1, numRows1);
        String result2 = convert(test2, numRows2);
        String result3 = convert(test3, numRows3);
        System.out.println("Test 1: " + result1 + " | Correct? " + result1.equals(expected1));
        System.out.println("Test 2: " + result2 + " | Correct? " + result2.equals(expected2));
        System.out.println("Test 3: " + result3 + " | Correct? " + result3.equals(expected3));
    }
}
