/**
 * Rotate Array - LeetCode #189
 * =============================
 * Given an integer array nums, rotate the array to the right by k steps.
 * 
 * Example:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 */

import java.util.*;

public class RotateArray {
    
    /**
     * Using Extra Space
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] rotateArrayExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle k > n
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        
        return result;
    }
    
    /**
     * Reverse Method - OPTIMAL (In-place)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Reverse entire array
     * 2. Reverse first k elements
     * 3. Reverse remaining elements
     * 
     * This is the BEST approach for interviews!
     */
    public static void rotateArrayReverse(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle k > n
        
        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);
        
        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }
    
    // Helper method to reverse array portion
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Cyclic Replacement Method
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Moves elements in cycles
     */
    public static void rotateArrayCyclic(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        int start = 0;
        
        while (count < n) {
            int current = start;
            int prev = nums[start];
            
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
            
            start++;
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        
        int[] copy1 = nums1.clone();
        System.out.println("Extra Space: " + Arrays.toString(rotateArrayExtraSpace(copy1, k1)));
        
        int[] copy2 = nums1.clone();
        rotateArrayReverse(copy2, k1);
        System.out.println("Reverse Method: " + Arrays.toString(copy2));
        
        int[] copy3 = nums1.clone();
        rotateArrayCyclic(copy3, k1);
        System.out.println("Cyclic Method: " + Arrays.toString(copy3));
        System.out.println();
        
        // Test Case 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2);
        int[] copy4 = nums2.clone();
        rotateArrayReverse(copy4, k2);
        System.out.println("Reverse Method: " + Arrays.toString(copy4));
        System.out.println();
        
        // Test Case 3 - k > array length
        int[] nums3 = {1, 2};
        int k3 = 3;
        System.out.println("Input: " + Arrays.toString(nums3) + ", k = " + k3);
        int[] copy5 = nums3.clone();
        rotateArrayReverse(copy5, k3);
        System.out.println("Reverse Method: " + Arrays.toString(copy5));
    }
}

