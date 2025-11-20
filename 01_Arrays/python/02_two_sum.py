"""
Two Sum Problem - LeetCode #1
==============================
Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
"""

def two_sum_brute_force(nums, target):
    """
    Brute Force Approach
    Time Complexity: O(n²)
    Space Complexity: O(1)
    """
    n = len(nums)
    for i in range(n):
        for j in range(i + 1, n):
            if nums[i] + nums[j] == target:
                return [i, j]
    return []


def two_sum_optimal(nums, target):
    """
    Optimal Approach using Hash Map
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    This is the BEST approach for interviews!
    """
    # Dictionary to store {value: index}
    num_map = {}
    
    for i, num in enumerate(nums):
        complement = target - num
        
        # Check if complement exists in map
        if complement in num_map:
            return [num_map[complement], i]
        
        # Store current number and its index
        num_map[num] = i
    
    return []


def two_sum_sorted_array(nums, target):
    """
    Two Pointers Approach (for sorted array)
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Note: This assumes array is sorted
    """
    left, right = 0, len(nums) - 1
    
    while left < right:
        current_sum = nums[left] + nums[right]
        
        if current_sum == target:
            return [left, right]
        elif current_sum < target:
            left += 1
        else:
            right -= 1
    
    return []


# Test cases
if __name__ == "__main__":
    # Test Case 1
    nums1 = [2, 7, 11, 15]
    target1 = 9
    print(f"Input: nums = {nums1}, target = {target1}")
    print(f"Brute Force: {two_sum_brute_force(nums1, target1)}")
    print(f"Optimal: {two_sum_optimal(nums1, target1)}")
    print()
    
    # Test Case 2
    nums2 = [3, 2, 4]
    target2 = 6
    print(f"Input: nums = {nums2}, target = {target2}")
    print(f"Brute Force: {two_sum_brute_force(nums2, target2)}")
    print(f"Optimal: {two_sum_optimal(nums2, target2)}")
    print()
    
    # Test Case 3
    nums3 = [3, 3]
    target3 = 6
    print(f"Input: nums = {nums3}, target = {target3}")
    print(f"Brute Force: {two_sum_brute_force(nums3, target3)}")
    print(f"Optimal: {two_sum_optimal(nums3, target3)}")
    print()
    
    # Test Case 4 - Sorted array
    nums4 = [2, 7, 11, 15]
    target4 = 9
    print(f"Sorted Array: nums = {nums4}, target = {target4}")
    print(f"Two Pointers: {two_sum_sorted_array(nums4, target4)}")

