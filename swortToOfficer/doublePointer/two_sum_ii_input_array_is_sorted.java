package doublePointer;

public class two_sum_ii_input_array_is_sorted {
    public static void main(String[] args) {
        // Example usage
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    // Placeholder for the answer method
    public static int[] twoSum(int[] numbers, int target) {
        // TODO: Implement the two-pointer solution here
        //use two pointer to solve the problem
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if(numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
