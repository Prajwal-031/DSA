/**
 * Maximum Subarray - LeetCode #53 (Kadane's Algorithm)
 * =====================================================
 * Given an integer array nums, find the contiguous subarray 
 * (containing at least one number) which has the largest sum 
 * and return its sum.
 * 
 * Example:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

import java.util.*;

public class MaximumSubarray {
    
    /**
     * Brute Force Approach
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static int maxSubarrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
    
    /**
     * Kadane's Algorithm - OPTIMAL SOLUTION
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * This is the BEST approach for interviews!
     * 
     * Algorithm:
     * 1. Keep track of maximum sum ending at current position
     * 2. If current sum becomes negative, reset it to 0
     * 3. Update global maximum at each step
     */
    public static int maxSubarrayKadane(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend previous subarray or start new one
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    /**
     * Kadane's Algorithm with indices tracking
     * Returns both the maximum sum and the subarray indices
     */
    public static class Result {
        int maxSum;
        int start;
        int end;
        
        Result(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }
    
    public static Result maxSubarrayKadaneWithIndices(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        
        return new Result(maxSum, start, end);
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Brute Force: " + maxSubarrayBruteForce(nums1));
        System.out.println("Kadane's Algorithm: " + maxSubarrayKadane(nums1));
        Result result1 = maxSubarrayKadaneWithIndices(nums1);
        System.out.println("Subarray: indices " + result1.start + " to " + result1.end);
        System.out.println();
        
        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Kadane's Algorithm: " + maxSubarrayKadane(nums2));
        System.out.println();
        
        // Test Case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Kadane's Algorithm: " + maxSubarrayKadane(nums3));
        System.out.println();
        
        // Test Case 4 - All negative
        int[] nums4 = {-2, -1, -3};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Kadane's Algorithm: " + maxSubarrayKadane(nums4));
    }
}

