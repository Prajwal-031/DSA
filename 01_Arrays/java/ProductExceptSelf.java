/**
 * Product of Array Except Self - LeetCode #238
 * =============================================
 * Given an integer array nums, return an array answer such that 
 * answer[i] is equal to the product of all the elements of nums 
 * except nums[i].
 * 
 * Constraints:
 * - Cannot use division operator
 * - Must be O(n) time complexity
 * - Space complexity should be O(1) excluding output array
 * 
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */

import java.util.*;

public class ProductExceptSelf {
    
    /**
     * Using Left and Right Product Arrays
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Algorithm:
     * 1. Create left array: product of all elements to the left
     * 2. Create right array: product of all elements to the right
     * 3. Multiply left[i] * right[i] for each position
     */
    public static int[] productExceptSelfTwoArrays(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Fill left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        // Fill right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        // Calculate result
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        
        return result;
    }
    
    /**
     * Optimal Solution - Single Pass
     * Time Complexity: O(n)
     * Space Complexity: O(1) excluding output array
     * 
     * This is the BEST approach for interviews!
     * 
     * Algorithm:
     * 1. First pass: Calculate left products and store in result
     * 2. Second pass: Multiply with right products using a variable
     */
    public static int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // First pass: Calculate left products
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        // Second pass: Multiply with right products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Two Arrays: " + Arrays.toString(productExceptSelfTwoArrays(nums1)));
        System.out.println("Optimal: " + Arrays.toString(productExceptSelfOptimal(nums1)));
        System.out.println();
        
        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Two Arrays: " + Arrays.toString(productExceptSelfTwoArrays(nums2)));
        System.out.println("Optimal: " + Arrays.toString(productExceptSelfOptimal(nums2)));
        System.out.println();
        
        // Test Case 3
        int[] nums3 = {2, 3, 4, 5};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Optimal: " + Arrays.toString(productExceptSelfOptimal(nums3)));
    }
}

