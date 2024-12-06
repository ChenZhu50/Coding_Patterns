package Q3_Minimum_Number_of_Moves_to_Make_Palindrome;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ccxx", "arcacer", "w", "ooooooo", "eggeekgbbeg");

        for (int i = 0; i < strings.size(); ++i) {
            System.out.println((i + 1) + ".\ts: " + strings.get(i));
            System.out.println("\tMoves: " + minMovesToMakePalindrome(strings.get(i)));
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
         /*
         todo: 1. 初始化moves为0
         todo: 2. 初始化两个指针，一个指向字符串的头部，一个指向字符串的尾部
         todo：3. 使用while循环，只要i>j，就一直循环
         todo：4. 在内部循环中，从j处从后往前查找，找到一个和i处相同的字符
         todo：5. 如果找到了，交换相邻的字符到其右侧，直到达到j的位置，同时moves++
         todo：6. 如果没有找到，增加需要的moves来讲i处的字符移到j处
         todo：7. 当我们完成了所有对的修改，将i指针向前移动，j指针向后移动
         todo：8. 返回moves
         */

    public static int minMovesToMakePalindrome(String s) {
        return 0;
    }
}
