package Q4_Next_Palindrome_using_same_Digits;


public class Main {
    public static void main(String[] args) {
        String[] testCases = {"12321", "89798"};

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(i + 1 + ".\t Original palindrome: '" + testCases[i] + "'");
            String nextPalindrome = findNextPalindrome(testCases[i]);
            System.out.println("\t Next greater palindrome: '" + nextPalindrome + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    /**
     * @param numStr
     * @return
     */
    public static String findNextPalindrome(String numStr){
        char[] chars = numStr.toCharArray();
        int halfLength = chars.length / 2;
        int mid = chars.length % 2 == 0 ? -1 : chars.length / 2; // 保存中间字符的索引，如果有的话
    
        if(chars.length == 1) return ""; // 处理长度为1的情况
    
        // 获取左半部分的字符数组
        char[] leftHalf = new char[halfLength];
        System.arraycopy(chars, 0, leftHalf, 0, halfLength);
    
        int i, j;
        for(i = halfLength - 1; i > 0; i--){
            if(leftHalf[i - 1] < leftHalf[i]) break;
        }
    
        if(i == 0) return ""; // 没有找到可交换的位置，返回空字符串
    
        // 找到要交换的最小的、比leftHalf[i-1]大的数字
        for(j = halfLength - 1; j >= i; j--){
            if(leftHalf[j] > leftHalf[i - 1]) break;
        }
    
        // 交换字符
        char temp = leftHalf[i - 1];
        leftHalf[i - 1] = leftHalf[j];
        leftHalf[j] = temp;
    
        // 反转i之后的部分
        for(j = halfLength - 1; i < j; i++, j--){
            temp = leftHalf[i];
            leftHalf[i] = leftHalf[j];
            leftHalf[j] = temp;
        }
    
        // 构建新的回文字符串
        StringBuilder sb = new StringBuilder();
        sb.append(leftHalf);
        if(mid != -1) sb.append(chars[mid]); // 如果是奇数长度，添加中间的字符
        for(i = halfLength - 1; i >= 0; i--){
            sb.append(leftHalf[i]);
        }
    
        // 检查是否比原始字符串大
        String nextPalindrome = sb.toString();
        return nextPalindrome.compareTo(numStr) > 0 ? nextPalindrome : "";
    }
    
}
