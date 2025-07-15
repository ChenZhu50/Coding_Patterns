package Simulation;
import java.util.*;

public class addingString {
    
    public static String addStrings(String num1, String num2) {
        int digit1, digit2, sum, carry;
        StringBuilder sb = new StringBuilder();

        int i  = num1.length() - 1;
        int j = num2.length() - 1;
        carry = 0;

        while(i >= 0 || j >= 0 || carry >0){
            digit1 = (i >=0)? num1.charAt(i) - '0' : 0;
            digit2 = (j >=0)? num2.charAt(j) - '0' : 0;

            sum = digit1 + digit2 + carry;
            carry = sum/10;
            sb.append(sum%10);

            i--;
            j--;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String test1a = "11", test1b = "123";
        String test2a = "456", test2b = "77";
        String test3a = "0", test3b = "0";
        System.out.println("Test 1: " + addStrings(test1a, test1b)); // Expected: 134
        System.out.println("Test 2: " + addStrings(test2a, test2b)); // Expected: 533
        System.out.println("Test 3: " + addStrings(test3a, test3b)); // Expected: 0
    }
}
