package doublePointer;
import java.util.Arrays;
import java.util.Scanner;



public class reverseWordInAString {
    public static void main(String[] args) {
        // Example: "the sky is blue" -> "blue is sky the"
        String s = "the sky is blue";
        String reversed = reverseWords(s);
        System.out.println("Reversed: '" + reversed + "'");
    }

    public static String reverseWords(String s) {
        //use two pointers to reverse the words
        Scanner scanner = new Scanner(System.in);
        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr));
        int length = arr.length;

        //reverse the whole string
        reverse(arr, 0, length - 1);
        System.out.println(Arrays.toString(arr));

        int i = 0;
        
        while(i < length) {
            scanner.nextLine();
            System.out.println("pass scanner");

            System.out.println("current length is "+ length);
            System.out.println("current i is " + i);
            System.out.println(Arrays.toString(arr));

            System.out.println("before we finding the space, i is " + i);
            while(i < length && arr[i] == ' ') {
                System.out.println("we are finding the space");
                i++;
                System.out.println("we find the space, and current i is " + i);
            }
            System.out.println("before reverse the word, i is " + i);
            int start = i;
            while (i< length && arr[i] != ' ') {
                i++;
                System.out.println(" when you reverse word, here is i " + i);
            };
            int end = i-1;
            reverse(arr, start, end);
            System.out.println("after reverse the array become" + Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));

        //remove the extra spaces
        StringBuilder sb = new StringBuilder();
        i = 0;
        while(i < length) {
            while(i < length && arr[i] == ' ') {
                i++;
            }
            if (i >= length) break;
            if(sb.length() > 0) sb.append(' ');
            while(i < length && arr[i] != ' ') {
                sb.append(arr[i++]);
            }
        }
        return sb.toString();
    }
    public static void reverse(char[] arr, int j, int i) {
        while(j < i) {
            char temp = arr[j];
            arr[j++] = arr[i]; //这部分内容是先给arr[j] 赋值，再 ++
            arr[i--] = temp;
        }
    }
}
