"""
Product of Array Except Self - LeetCode #238
=============================================
Given an integer array nums, return an array answer such that 
answer[i] is equal to the product of all the elements of nums 
except nums[i].

Constraints:
- Cannot use division operator
- Must be O(n) time complexity
- Space complexity should be O(1) excluding output array

Example:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
"""

def product_except_self_brute_force(nums):
    """
    Brute Force (with division - not allowed in problem)
    Time Complexity: O(n)
    Space Complexity: O(1)
    Note: This uses division, which violates constraints
    """
    total_product = 1
    zero_count = 0
    
    for num in nums:
        if num == 0:
            zero_count += 1
        else:
            total_product *= num
    
    result = []
    for num in nums:
        if zero_count > 1:
            result.append(0)
        elif zero_count == 1:
            result.append(total_product if num == 0 else 0)
        else:
            result.append(total_product // num)
    
    return result


def product_except_self_two_arrays(nums):
    """
    Using Left and Right Product Arrays
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Algorithm:
    1. Create left array: product of all elements to the left
    2. Create right array: product of all elements to the right
    3. Multiply left[i] * right[i] for each position
    """
    n = len(nums)
    left = [1] * n
    right = [1] * n
    
    # Fill left array
    for i in range(1, n):
        left[i] = left[i - 1] * nums[i - 1]
    
    # Fill right array
    for i in range(n - 2, -1, -1):
        right[i] = right[i + 1] * nums[i + 1]
    
    # Calculate result
    result = []
    for i in range(n):
        result.append(left[i] * right[i])
    
    return result


def product_except_self_optimal(nums):
    """
    Optimal Solution - Single Pass
    Time Complexity: O(n)
    Space Complexity: O(1) excluding output array
    
    This is the BEST approach for interviews!
    
    Algorithm:
    1. First pass: Calculate left products and store in result
    2. Second pass: Multiply with right products using a variable
    """
    n = len(nums)
    result = [1] * n
    
    # First pass: Calculate left products
    left_product = 1
    for i in range(n):
        result[i] = left_product
        left_product *= nums[i]
    
    # Second pass: Multiply with right products
    right_product = 1
    for i in range(n - 1, -1, -1):
        result[i] *= right_product
        right_product *= nums[i]
    
    return result


# Test cases
if __name__ == "__main__":
    # Test Case 1
    nums1 = [1, 2, 3, 4]
    print(f"Input: {nums1}")
    print(f"Two Arrays: {product_except_self_two_arrays(nums1)}")
    print(f"Optimal: {product_except_self_optimal(nums1)}")
    print()
    
    # Test Case 2
    nums2 = [-1, 1, 0, -3, 3]
    print(f"Input: {nums2}")
    print(f"Two Arrays: {product_except_self_two_arrays(nums2)}")
    print(f"Optimal: {product_except_self_optimal(nums2)}")
    print()
    
    # Test Case 3
    nums3 = [2, 3, 4, 5]
    print(f"Input: {nums3}")
    print(f"Optimal: {product_except_self_optimal(nums3)}")

