public class Main {
    public static void main(String[] args) {
        String[] nums = {
            "609",
            "88",
            "962",
            "101",
            "123"
        };

        int i = 0;
        for (String num : nums) {
            System.out.println((i + 1) + ".\tnum: " + num);
            System.out.println("\n\tIs strobogrammatic: " + (isStrobogrammatic(num) ? "true" : "false"));
            System.out.println(new String(new char[100]).replace("\0", "-"));
            i++;
        }
    }
    public static boolean isStrobogrammatic(String num) {
        int front = 0, end = num.length() - 1;
        char left, right;

        while(end > front){
            left = num.charAt(front);
            right = num.charAt(end);
            front++;
            end--;


            if((left == '6' && right == '9')||(left == '9' && right == '6')){
                continue;
            }
            else if ((left == '0' && right == '0') || (left == '1' && right == '1') || (left == '8' && right == '8')) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;    
    }
}
