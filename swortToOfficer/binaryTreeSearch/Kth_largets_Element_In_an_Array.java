package binaryTreeSearch;

import java.util.*;

public class Kth_largets_Element_In_an_Array {
    Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int ans = quick_select(nums, 0 , length ,length -k);
        return ans;
    }

    private int quick_select(int[] nums, int left, int right, int k){
        if(left == right) return nums[left];
        int pivot_index = partition(nums, left, right);
        if(pivot_index == k) return nums[pivot_index];
        else if(pivot_index < k) return quick_select(nums, pivot_index + 1, right, k);
        else return quick_select(nums, left, pivot_index -1, k);
    }

    private int partition(int[] nums, int left, int right){
        //随机选择一个index作为pivot，这样大概率不会进入最坏的情况中。
        int pivot_index = left+ rand.nextInt(right - left + 1);
        int pivot = nums[pivot_index];

        //把pivot放到最后，这样可以方便前面交换。
        swap(nums, pivot_index, right);
        //因为每次调用partition的时候left不一定一样，所以我们定义从哪开始
        int sorted_index = left;

        //只要当前这个值比pivot小，我们就让其去左边，这样就会让pivot的下标一定正确。
        for(int i = left; i< right; i++){
            if(nums[i] <= pivot){
                swap(nums, sorted_index, i);
                sorted_index++;
            }
        }
        //因为sorted_index 如果遇到比当前pivot大的话是不会动的，所以pivot的正确位置一定在这个点。
        swap(nums, sorted_index, right);
        return sorted_index;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // Test cases: {input array, k, expected output}
        Object[][] testCases = {
            {new int[]{3,2,1,5,6,4}, 2, 5}, // kth = 2, output = 5
            {new int[]{3,2,3,1,2,4,5,5,6}, 4, 4}, // kth = 4, output = 4
            {new int[]{1}, 1, 1}, // kth = 1, output = 1
            {new int[]{2,1}, 2, 1}, // kth = 2, output = 1
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = (int[]) testCases[i][0];
            int k = (int) testCases[i][1];
            int expected = (int) testCases[i][2];
            Kth_largets_Element_In_an_Array result = new Kth_largets_Element_In_an_Array();
            int ans = result.findKthLargest(arr, k);
            System.out.println("Test case " + (i+1) + ": Input = " + Arrays.toString(arr) + ", k = " + k);
            System.out.println("Output: " + ans + ", Expected: " + expected + ", Pass: " + (ans == expected));
            System.out.println();
        }
    }
}
