"""
Hash Tables - Python Implementation
LeetCode Problems: 1, 217, 242, 387, 49, 347, 202, 205, 128
"""

from typing import List, Dict, Set, Tuple
from collections import Counter, defaultdict
import heapq


# ============= TWO SUM =============

def two_sum(nums: List[int], target: int) -> List[int]:
    """
    LeetCode 1: Two Sum
    Find two numbers that add up to target.
    
    Time: O(n) | Space: O(n)
    Pattern: Hash map for complement lookup
    """
    seen = {}
    
    for i, num in enumerate(nums):
        complement = target - num
        if complement in seen:
            return [seen[complement], i]
        seen[num] = i
    
    return []


# ============= CONTAINS DUPLICATE =============

def contains_duplicate(nums: List[int]) -> bool:
    """
    LeetCode 217: Contains Duplicate
    Check if array has duplicate elements.
    
    Time: O(n) | Space: O(n)
    Pattern: Set for O(1) deduplication check
    """
    seen = set()
    
    for num in nums:
        if num in seen:
            return True
        seen.add(num)
    
    return False


# ============= VALID ANAGRAM =============

def is_anagram(s: str, t: str) -> bool:
    """
    LeetCode 242: Valid Anagram
    Check if two strings are anagrams (same chars, different order).
    
    Time: O(n) | Space: O(1) - max 26 lowercase letters
    Pattern: Character frequency counting
    """
    if len(s) != len(t):
        return False
    
    char_count = Counter(s)
    
    for char in t:
        if char not in char_count:
            return False
        char_count[char] -= 1
        if char_count[char] < 0:
            return False
    
    return True


# ============= FIRST UNIQUE CHARACTER =============

def first_unique_char(s: str) -> int:
    """
    LeetCode 387: First Unique Character in a String
    Find first character that appears only once.
    
    Time: O(n) | Space: O(1) - max 26 letters
    Pattern: Frequency count + iterate to find unique
    """
    char_count = Counter(s)
    
    for i, char in enumerate(s):
        if char_count[char] == 1:
            return i
    
    return -1


# ============= GROUP ANAGRAMS =============

def group_anagrams(strs: List[str]) -> List[List[str]]:
    """
    LeetCode 49: Group Anagrams
    Group strings that are anagrams of each other.
    
    Time: O(n*k log k) where k = avg string length | Space: O(n*k)
    Pattern: Use sorted string as grouping key
    """
    anagram_groups = defaultdict(list)
    
    for word in strs:
        # Sort characters to create canonical form
        key = ''.join(sorted(word))
        anagram_groups[key].append(word)
    
    return list(anagram_groups.values())


# ============= TOP K FREQUENT ELEMENTS =============

def top_k_frequent(nums: List[int], k: int) -> List[int]:
    """
    LeetCode 347: Top K Frequent Elements
    Find k most frequent elements.
    
    Time: O(n log k) | Space: O(n)
    Pattern: Frequency count + min heap for top k
    """
    # Count frequencies
    freq_map = Counter(nums)
    
    # Use min heap to keep only top k
    heap = []
    
    for num, freq in freq_map.items():
        heapq.heappush(heap, (freq, num))
        if len(heap) > k:
            heapq.heappop(heap)
    
    return [num for freq, num in heap]


# ============= HAPPY NUMBER =============

def is_happy(n: int) -> bool:
    """
    LeetCode 202: Happy Number
    Determine if number eventually reaches 1 using sum of squares of digits.
    
    Time: O(log n) | Space: O(1)
    Pattern: Cycle detection with hash set
    """
    def get_next(number: int) -> int:
        total_sum = 0
        while number > 0:
            digit = number % 10
            total_sum += digit * digit
            number //= 10
        return total_sum
    
    seen = set()
    
    while n != 1 and n not in seen:
        seen.add(n)
        n = get_next(n)
    
    return n == 1


# ============= ISOMORPHIC STRINGS =============

def is_isomorphic(s: str, t: str) -> bool:
    """
    LeetCode 205: Isomorphic Strings
    Check if strings are isomorphic (character bijective mapping).
    
    Time: O(n) | Space: O(1) - max 26 letters
    Pattern: Character-to-character mapping validation
    """
    if len(s) != len(t):
        return False
    
    s_to_t = {}
    t_to_s = {}
    
    for s_char, t_char in zip(s, t):
        # Check s -> t mapping
        if s_char in s_to_t:
            if s_to_t[s_char] != t_char:
                return False
        else:
            s_to_t[s_char] = t_char
        
        # Check t -> s mapping (ensure bijective)
        if t_char in t_to_s:
            if t_to_s[t_char] != s_char:
                return False
        else:
            t_to_s[t_char] = s_char
    
    return True


# ============= LONGEST CONSECUTIVE =============

def longest_consecutive(nums: List[int]) -> int:
    """
    LeetCode 128: Longest Consecutive Elements
    Find length of longest consecutive elements sequence.
    
    Time: O(n) | Space: O(n)
    Pattern: Set for O(1) lookup + smart iteration (only check sequence starts)
    """
    if not nums:
        return 0
    
    num_set = set(nums)
    longest_streak = 0
    
    for num in num_set:
        # Only start counting from sequence beginnings
        if num - 1 not in num_set:
            current_num = num
            current_streak = 1
            
            while current_num + 1 in num_set:
                current_num += 1
                current_streak += 1
            
            longest_streak = max(longest_streak, current_streak)
    
    return longest_streak


# ============= INTERSECTION OF TWO ARRAYS =============

def intersection(nums1: List[int], nums2: List[int]) -> List[int]:
    """
    LeetCode 349: Intersection of Two Arrays
    Find common elements in two arrays.
    
    Time: O(n + m) | Space: O(min(n, m))
    Pattern: Store smaller array in set, iterate larger
    """
    set1 = set(nums1)
    set2 = set(nums2)
    
    return list(set1 & set2)


# ============= RANSOM NOTE =============

def can_construct(ransom_note: str, magazine: str) -> bool:
    """
    LeetCode 383: Ransom Note
    Check if ransom note can be constructed from magazine letters.
    
    Time: O(n) | Space: O(1) - max 26 letters
    Pattern: Character frequency availability check
    """
    char_count = Counter(magazine)
    
    for char in ransom_note:
        if char not in char_count or char_count[char] == 0:
            return False
        char_count[char] -= 1
    
    return True


# ============= MAJORITY ELEMENT =============

def majority_element(nums: List[int]) -> int:
    """
    LeetCode 169: Majority Element
    Find element appearing more than n/2 times.
    
    Time: O(n) | Space: O(n)
    Pattern: Frequency counting + find max
    """
    count_map = Counter(nums)
    return max(count_map, key=count_map.get)


# ============= TWO POINTER + HASH (FIND PAIRS) =============

def find_pairs(nums: List[int], k: int) -> int:
    """
    Find number of unique pairs with difference k.
    
    Time: O(n) | Space: O(n)
    Pattern: Hash set + two-pass for unique pairs
    """
    if k < 0:
        return 0
    
    num_set = set(nums)
    count = 0
    
    for num in num_set:
        if num + k in num_set:
            count += 1
    
    return count