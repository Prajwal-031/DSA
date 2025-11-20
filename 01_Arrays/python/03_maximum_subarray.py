"""
Maximum Subarray - LeetCode #53 (Kadane's Algorithm)
======================================================
Given an integer array nums, find the contiguous subarray 
(containing at least one number) which has the largest sum 
and return its sum.

Example:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
"""

def max_subarray_brute_force(nums):
    """
    Brute Force Approach
    Time Complexity: O(n³) or O(n²) with optimization
    Space Complexity: O(1)
    """
    max_sum = float('-inf')
    n = len(nums)
    
    for i in range(n):
        for j in range(i, n):
            current_sum = sum(nums[i:j+1])
            max_sum = max(max_sum, current_sum)
    
    return max_sum


def max_subarray_optimized_brute_force(nums):
    """
    Optimized Brute Force
    Time Complexity: O(n²)
    Space Complexity: O(1)
    """
    max_sum = float('-inf')
    n = len(nums)
    
    for i in range(n):
        current_sum = 0
        for j in range(i, n):
            current_sum += nums[j]
            max_sum = max(max_sum, current_sum)
    
    return max_sum


def max_subarray_kadane(nums):
    """
    Kadane's Algorithm - OPTIMAL SOLUTION
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    This is the BEST approach for interviews!
    
    Algorithm:
    1. Keep track of maximum sum ending at current position
    2. If current sum becomes negative, reset it to 0
    3. Update global maximum at each step
    """
    max_sum = nums[0]
    current_sum = nums[0]
    
    for i in range(1, len(nums)):
        # Either extend previous subarray or start new one
        current_sum = max(nums[i], current_sum + nums[i])
        max_sum = max(max_sum, current_sum)
    
    return max_sum


def max_subarray_kadane_with_indices(nums):
    """
    Kadane's Algorithm with indices tracking
    Returns both the maximum sum and the subarray indices
    """
    max_sum = nums[0]
    current_sum = nums[0]
    start = 0
    end = 0
    temp_start = 0
    
    for i in range(1, len(nums)):
        if current_sum < 0:
            current_sum = nums[i]
            temp_start = i
        else:
            current_sum += nums[i]
        
        if current_sum > max_sum:
            max_sum = current_sum
            start = temp_start
            end = i
    
    return max_sum, start, end


# Test cases
if __name__ == "__main__":
    # Test Case 1
    nums1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    print(f"Input: {nums1}")
    print(f"Brute Force: {max_subarray_brute_force(nums1)}")
    print(f"Optimized Brute Force: {max_subarray_optimized_brute_force(nums1)}")
    print(f"Kadane's Algorithm: {max_subarray_kadane(nums1)}")
    max_sum, start, end = max_subarray_kadane_with_indices(nums1)
    print(f"Subarray: {nums1[start:end+1]} (indices {start} to {end})")
    print()
    
    # Test Case 2
    nums2 = [1]
    print(f"Input: {nums2}")
    print(f"Kadane's Algorithm: {max_subarray_kadane(nums2)}")
    print()
    
    # Test Case 3
    nums3 = [5, 4, -1, 7, 8]
    print(f"Input: {nums3}")
    print(f"Kadane's Algorithm: {max_subarray_kadane(nums3)}")
    print()
    
    # Test Case 4 - All negative
    nums4 = [-2, -1, -3]
    print(f"Input: {nums4}")
    print(f"Kadane's Algorithm: {max_subarray_kadane(nums4)}")

