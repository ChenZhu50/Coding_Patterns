package Simulation;
import java.util.*;

public class string_to_integer {
    public static int myAtoi(String s) {
        int i = 0, result = 0, sign = 1;

        //skip all the space
        while(i < s.length() && s.charAt(i) == ' ') i++;

        //checking only one of the sign(if more then one, we return 0)
        if(i<s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }

        //building result
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(result >(Integer.MAX_VALUE-digit) / 10){
                return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }

            result = result * 10 + digit;

            i++;
        }
        return result*sign;
    }

    public static void main(String[] args) {
        String test1 = "42";
        int expected1 = 42;
        String test2 = "   -42";
        int expected2 = -42;
        String test3 = "4193 with words";
        int expected3 = 4193;
        String test4 = "words and 987";
        int expected4 = 0;
        String test5 = "-91283472332";
        int expected5 = -2147483648; // Integer.MIN_VALUE

        int result1 = myAtoi(test1);
        int result2 = myAtoi(test2);
        int result3 = myAtoi(test3);
        int result4 = myAtoi(test4);
        int result5 = myAtoi(test5);
        System.out.println("Test 1: " + result1 + " | Correct? " + (result1 == expected1));
        System.out.println("Test 2: " + result2 + " | Correct? " + (result2 == expected2));
        System.out.println("Test 3: " + result3 + " | Correct? " + (result3 == expected3));
        System.out.println("Test 4: " + result4 + " | Correct? " + (result4 == expected4));
        System.out.println("Test 5: " + result5 + " | Correct? " + (result5 == expected5));
    }
}
