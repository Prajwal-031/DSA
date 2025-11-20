"""
Rotate Array - LeetCode #189
=============================
Given an integer array nums, rotate the array to the right by k steps.

Example:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
"""

def rotate_array_extra_space(nums, k):
    """
    Using Extra Space
    Time Complexity: O(n)
    Space Complexity: O(n)
    """
    n = len(nums)
    k = k % n  # Handle k > n
    result = [0] * n
    
    for i in range(n):
        result[(i + k) % n] = nums[i]
    
    return result


def rotate_array_reverse(nums, k):
    """
    Reverse Method - OPTIMAL (In-place)
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Algorithm:
    1. Reverse entire array
    2. Reverse first k elements
    3. Reverse remaining elements
    
    This is the BEST approach for interviews!
    """
    n = len(nums)
    k = k % n  # Handle k > n
    
    # Helper function to reverse array portion
    def reverse(arr, start, end):
        while start < end:
            arr[start], arr[end] = arr[end], arr[start]
            start += 1
            end -= 1
    
    # Step 1: Reverse entire array
    reverse(nums, 0, n - 1)
    
    # Step 2: Reverse first k elements
    reverse(nums, 0, k - 1)
    
    # Step 3: Reverse remaining elements
    reverse(nums, k, n - 1)
    
    return nums


def rotate_array_cyclic(nums, k):
    """
    Cyclic Replacement Method
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Moves elements in cycles
    """
    n = len(nums)
    k = k % n
    count = 0
    start = 0
    
    while count < n:
        current = start
        prev = nums[start]
        
        while True:
            next_idx = (current + k) % n
            nums[next_idx], prev = prev, nums[next_idx]
            current = next_idx
            count += 1
            
            if start == current:
                break
        
        start += 1
    
    return nums


# Test cases
if __name__ == "__main__":
    # Test Case 1
    nums1 = [1, 2, 3, 4, 5, 6, 7]
    k1 = 3
    print(f"Input: {nums1}, k = {k1}")
    print(f"Extra Space: {rotate_array_extra_space(nums1.copy(), k1)}")
    print(f"Reverse Method: {rotate_array_reverse(nums1.copy(), k1)}")
    print(f"Cyclic Method: {rotate_array_cyclic(nums1.copy(), k1)}")
    print()
    
    # Test Case 2
    nums2 = [-1, -100, 3, 99]
    k2 = 2
    print(f"Input: {nums2}, k = {k2}")
    print(f"Reverse Method: {rotate_array_reverse(nums2.copy(), k2)}")
    print()
    
    # Test Case 3 - k > array length
    nums3 = [1, 2]
    k3 = 3
    print(f"Input: {nums3}, k = {k3}")
    print(f"Reverse Method: {rotate_array_reverse(nums3.copy(), k3)}")

