"""
Pointer Techniques - Python Implementation
LeetCode Problems: 167, 344, 125, 11, 15, 141, 42, 76, 25
"""

# ============= TWO POINTER BASICS =============

def two_sum_sorted(arr, target):
    """
    LeetCode 167: Two Sum II - Input Array Is Sorted
    Find two numbers that add up to target in sorted array.
    
    Time: O(n) | Space: O(1)
    Pattern: Two pointers from opposite ends
    """
    left, right = 0, len(arr) - 1
    
    while left < right:
        current_sum = arr[left] + arr[right]
        if current_sum == target:
            return [left + 1, right + 1]  # 1-indexed
        elif current_sum < target:
            left += 1
        else:
            right -= 1
    
    return []


def reverse_string(s):
    """
    LeetCode 344: Reverse String
    Reverse array in-place using two pointers.
    
    Time: O(n) | Space: O(1)
    Pattern: Two pointers converging from ends
    """
    left, right = 0, len(s) - 1
    
    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1
    
    return s


def is_palindrome(s):
    """
    LeetCode 125: Valid Palindrome
    Check if string is palindrome (alphanumeric only, case-insensitive).
    
    Time: O(n) | Space: O(1)
    Pattern: Two pointers with filtering
    """
    left, right = 0, len(s) - 1
    
    while left < right:
        # Skip non-alphanumeric from left
        while left < right and not s[left].isalnum():
            left += 1
        # Skip non-alphanumeric from right
        while left < right and not s[right].isalnum():
            right -= 1
        
        # Compare characters (case-insensitive)
        if s[left].lower() != s[right].lower():
            return False
        
        left += 1
        right -= 1
    
    return True


# ============= SLOW-FAST POINTER =============

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def has_cycle(head):
    """
    LeetCode 141: Linked List Cycle
    Detect if linked list has cycle using slow-fast pointer.
    
    Time: O(n) | Space: O(1)
    Pattern: Slow pointer moves 1 step, fast moves 2 steps
    If they meet -> cycle exists
    """
    if not head or not head.next:
        return False
    
    slow = head
    fast = head.next
    
    while slow != fast:
        if not fast or not fast.next:
            return False
        slow = slow.next
        fast = fast.next.next
    
    return True


# ============= CONTAINER WITH WATER =============

def max_area(heights):
    """
    LeetCode 11: Container With Most Water
    Find two lines that contain maximum water area.
    
    Time: O(n) | Space: O(1)
    Pattern: Two pointers, greedy approach
    Move the pointer with smaller height (it limits area)
    """
    max_water = 0
    left, right = 0, len(heights) - 1
    
    while left < right:
        width = right - left
        current_height = min(heights[left], heights[right])
        current_area = width * current_height
        max_water = max(max_water, current_area)
        
        # Move the pointer with smaller height
        if heights[left] < heights[right]:
            left += 1
        else:
            right -= 1
    
    return max_water


# ============= 3SUM PROBLEM =============

def three_sum(nums):
    """
    LeetCode 15: 3Sum
    Find all unique triplets that sum to zero.
    
    Time: O(n²) | Space: O(1) excluding output
    Pattern: Sort + two pointers for each element
    """
    nums.sort()
    result = []
    n = len(nums)
    
    for i in range(n - 2):
        if nums[i] > 0:  # No triplet with positive sum
            break
        
        if i > 0 and nums[i] == nums[i - 1]:  # Skip duplicates
            continue
        
        left, right = i + 1, n - 1
        target = -nums[i]
        
        while left < right:
            current_sum = nums[left] + nums[right]
            if current_sum == target:
                result.append([nums[i], nums[left], nums[right]])
                
                # Skip duplicates
                while left < right and nums[left] == nums[left + 1]:
                    left += 1
                while left < right and nums[right] == nums[right - 1]:
                    right -= 1
                
                left += 1
                right -= 1
            elif current_sum < target:
                left += 1
            else:
                right -= 1
    
    return result


# ============= TRAPPING RAIN WATER (HARD) =============

def trap_rain_water(height):
    """
    LeetCode 42: Trapping Rain Water
    Calculate trapped rainwater using two-pointer approach.
    
    Time: O(n) | Space: O(1)
    Pattern: Two pointers tracking max heights
    Water at pos = min(max_left, max_right) - height[pos]
    """
    if not height or len(height) < 3:
        return 0
    
    left, right = 0, len(height) - 1
    max_left, max_right = 0, 0
    water = 0
    
    while left < right:
        if height[left] < height[right]:
            if height[left] >= max_left:
                max_left = height[left]
            else:
                water += max_left - height[left]
            left += 1
        else:
            if height[right] >= max_right:
                max_right = height[right]
            else:
                water += max_right - height[right]
            right -= 1
    
    return water


# ============= PARTITION (IN-PLACE) =============

def partition(arr, pivot):
    """
    Partition array around pivot (in-place).
    Elements < pivot on left, >= pivot on right.
    
    Time: O(n) | Space: O(1)
    Pattern: Two pointers meeting in middle
    Used in Quicksort
    """
    left, right = 0, len(arr) - 1
    
    while left < right:
        while left < right and arr[left] < pivot:
            left += 1
        while left < right and arr[right] >= pivot:
            right -= 1
        
        if left < right:
            arr[left], arr[right] = arr[right], arr[left]
    
    return arr


# ============= REMOVE DUPLICATES =============

def remove_duplicates(arr):
    """
    LeetCode 26: Remove Duplicates From Sorted Array
    Remove duplicates in-place, return length of array.
    
    Time: O(n) | Space: O(1)
    Pattern: Two pointers (write & read)
    """
    if len(arr) < 2:
        return len(arr)
    
    write_pos = 1
    
    for read_pos in range(1, len(arr)):
        if arr[read_pos] != arr[read_pos - 1]:
            arr[write_pos] = arr[read_pos]
            write_pos += 1
    
    return write_pos
