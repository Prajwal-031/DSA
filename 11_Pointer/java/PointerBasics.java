/**
 * Pointer Techniques - Java Implementation
 * LeetCode Problems: 167, 344, 125, 11, 15, 141, 42, 76, 25
 */

import java.util.*;

public class PointerBasics {
    
    // ============= TWO SUM II =============
    
    /**
     * LeetCode 167: Two Sum II - Input Array Is Sorted
     * Find two numbers that add up to target in sorted array.
     * 
     * Time: O(n) | Space: O(1)
     * @param numbers sorted array
     * @param target sum to find
     * @return 1-indexed positions [i, j]
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{-1, -1};
    }
    
    // ============= REVERSE STRING =============
    
    /**
     * LeetCode 344: Reverse String
     * Reverse char array in-place.
     * 
     * Time: O(n) | Space: O(1)
     */
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    
    // ============= PALINDROME CHECK =============
    
    /**
     * LeetCode 125: Valid Palindrome
     * Check if string is palindrome (alphanumeric only).
     * 
     * Time: O(n) | Space: O(1)
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    // ============= LINKED LIST CYCLE =============
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    /**
     * LeetCode 141: Linked List Cycle
     * Detect cycle using slow-fast pointer technique.
     * 
     * Time: O(n) | Space: O(1)
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
    
    // ============= CONTAINER WITH WATER =============
    
    /**
     * LeetCode 11: Container With Most Water
     * Find two lines containing maximum water area.
     * 
     * Time: O(n) | Space: O(1)
     * Pattern: Greedy - move pointer with smaller height
     */
    public static int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxWater = Math.max(maxWater, currentArea);
            
            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
    
    // ============= 3SUM =============
    
    /**
     * LeetCode 15: 3Sum
     * Find all unique triplets that sum to zero.
     * 
     * Time: O(n²) | Space: O(1) excluding output
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break; // No triplet with positive sum
            
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            
            int left = i + 1, right = n - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
    
    // ============= TRAPPING RAIN WATER =============
    
    /**
     * LeetCode 42: Trapping Rain Water
     * Calculate trapped rainwater using two-pointer approach.
     * 
     * Time: O(n) | Space: O(1)
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    water += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    water += maxRight - height[right];
                }
                right--;
            }
        }
        
        return water;
    }
    
    // ============= PARTITION =============
    
    /**
     * Partition array around pivot (in-place).
     * Elements < pivot on left, >= pivot on right.
     * 
     * Time: O(n) | Space: O(1)
     * Used in Quicksort
     */
    public static void partition(int[] arr, int pivot) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            while (left < right && arr[left] < pivot) {
                left++;
            }
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }
    
    // ============= REMOVE DUPLICATES =============
    
    /**
     * LeetCode 26: Remove Duplicates From Sorted Array
     * Remove duplicates in-place, return new length.
     * 
     * Time: O(n) | Space: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        
        int writePos = 1;
        
        for (int readPos = 1; readPos < nums.length; readPos++) {
            if (nums[readPos] != nums[readPos - 1]) {
                nums[writePos] = nums[readPos];
                writePos++;
            }
        }
        
        return writePos;
    }
}
