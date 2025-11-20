/**
 * Two Sum Problem - LeetCode #1
 * ==============================
 * Given an array of integers nums and an integer target, 
 * return indices of the two numbers such that they add up to target.
 * 
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

import java.util.*;

public class TwoSum {
    
    /**
     * Brute Force Approach
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
    /**
     * Optimal Approach using Hash Map
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * This is the BEST approach for interviews!
     */
    public static int[] twoSumOptimal(int[] nums, int target) {
        // HashMap to store {value: index}
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in map
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            
            // Store current number and its index
            numMap.put(nums[i], i);
        }
        
        return new int[]{};
    }
    
    /**
     * Two Pointers Approach (for sorted array)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Note: This assumes array is sorted
     */
    public static int[] twoSumSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            
            if (currentSum == target) {
                return new int[]{left, right};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{};
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.print("Brute Force: ");
        printArray(twoSumBruteForce(nums1, target1));
        System.out.print("Optimal: ");
        printArray(twoSumOptimal(nums1, target1));
        System.out.println();
        
        // Test Case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.print("Brute Force: ");
        printArray(twoSumBruteForce(nums2, target2));
        System.out.print("Optimal: ");
        printArray(twoSumOptimal(nums2, target2));
        System.out.println();
        
        // Test Case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.print("Brute Force: ");
        printArray(twoSumBruteForce(nums3, target3));
        System.out.print("Optimal: ");
        printArray(twoSumOptimal(nums3, target3));
        System.out.println();
        
        // Test Case 4 - Sorted array
        int[] nums4 = {2, 7, 11, 15};
        int target4 = 9;
        System.out.println("Sorted Array: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.print("Two Pointers: ");
        printArray(twoSumSortedArray(nums4, target4));
    }
}

