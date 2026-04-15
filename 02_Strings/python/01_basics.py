"""
Strings - Complete LeetCode Solutions in Python
===============================================
This file contains solutions to common String problems from LeetCode
"""

from typing import List
from collections import defaultdict, Counter

# ============================================
# EASY PROBLEMS
# ============================================

class Solution:
    # 344. Reverse String - Two Pointers
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        Time: O(n), Space: O(1)
        """
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

    # 242. Valid Anagram - Hash Map
    def isAnagram(self, s: str, t: str) -> bool:
        """
        Time: O(n), Space: O(1) - since only 26 letters
        """
        if len(s) != len(t):
            return False

        count = [0] * 26
        for char in s:
            count[ord(char) - ord('a')] += 1
        for char in t:
            count[ord(char) - ord('a')] -= 1
            if count[ord(char) - ord('a')] < 0:
                return False
        return True

    # 387. First Unique Character in a String
    def firstUniqChar(self, s: str) -> int:
        """
        Time: O(n), Space: O(1)
        """
        count = [0] * 26
        for char in s:
            count[ord(char) - ord('a')] += 1

        for i, char in enumerate(s):
            if count[ord(char) - ord('a')] == 1:
                return i
        return -1

# ============================================
# MEDIUM PROBLEMS
# ============================================

    # 3. Longest Substring Without Repeating Characters - Sliding Window
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        Time: O(n), Space: O(min(n, m)) where m is charset size
        """
        char_set = set()
        left = 0
        max_length = 0

        for right in range(len(s)):
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1
            char_set.add(s[right])
            max_length = max(max_length, right - left + 1)

        return max_length

    # 49. Group Anagrams - Hash Map
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        Time: O(n * k log k) where n is number of strings, k is max length
        Space: O(n * k)
        """
        anagram_map = defaultdict(list)

        for s in strs:
            # Sort the string to create a key
            sorted_s = ''.join(sorted(s))
            anagram_map[sorted_s].append(s)

        return list(anagram_map.values())

    # 5. Longest Palindromic Substring - Expand Around Center
    def longestPalindrome(self, s: str) -> str:
        """
        Time: O(n^2), Space: O(1)
        """
        if not s:
            return ""

        def expand_around_center(left: int, right: int) -> str:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1:right]

        longest = ""
        for i in range(len(s)):
            # Odd length palindrome
            odd_palindrome = expand_around_center(i, i)
            if len(odd_palindrome) > len(longest):
                longest = odd_palindrome

            # Even length palindrome
            even_palindrome = expand_around_center(i, i + 1)
            if len(even_palindrome) > len(longest):
                longest = even_palindrome

        return longest

# ============================================
# HARD PROBLEMS
# ============================================

    # 72. Edit Distance - Dynamic Programming
    def minDistance(self, word1: str, word2: str) -> int:
        """
        Time: O(m*n), Space: O(m*n)
        """
        m, n = len(word1), len(word2)

        # dp[i][j] represents min operations to convert word1[0..i-1] to word2[0..j-1]
        dp = [[0] * (n + 1) for _ in range(m + 1)]

        # Base cases
        for i in range(m + 1):
            dp[i][0] = i  # deletions needed
        for j in range(n + 1):
            dp[0][j] = j  # insertions needed

        # Fill the dp table
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    # min of: replace, delete, insert
                    dp[i][j] = 1 + min(
                        dp[i - 1][j - 1],  # replace
                        dp[i - 1][j],      # delete
                        dp[i][j - 1]       # insert
                    )

        return dp[m][n]

# ============================================
# UTILITY FUNCTIONS
# ============================================

def test_reverse_string():
    """Test reverse string function"""
    sol = Solution()

    # Test case 1
    s1 = ["h","e","l","l","o"]
    sol.reverseString(s1)
    assert s1 == ["o","l","l","e","h"], f"Expected ['o','l','l','e','h'], got {s1}"

    # Test case 2
    s2 = ["H","a","n","n","a","h"]
    sol.reverseString(s2)
    assert s2 == ["h","a","n","n","a","H"], f"Expected ['h','a','n','n','a','H'], got {s2}"

    print("✅ All reverse string tests passed!")

def test_valid_anagram():
    """Test valid anagram function"""
    sol = Solution()

    assert sol.isAnagram("anagram", "nagaram") == True, "anagram and nagaram should be anagrams"
    assert sol.isAnagram("rat", "car") == False, "rat and car should not be anagrams"
    assert sol.isAnagram("a", "ab") == False, "a and ab should not be anagrams"

    print("✅ All valid anagram tests passed!")

def test_first_unique_char():
    """Test first unique character function"""
    sol = Solution()

    assert sol.firstUniqChar("leetcode") == 0, "First unique char in leetcode should be at index 0"
    assert sol.firstUniqChar("loveleetcode") == 2, "First unique char in loveleetcode should be at index 2"
    assert sol.firstUniqChar("aabb") == -1, "No unique char in aabb"

    print("✅ All first unique char tests passed!")

def test_longest_substring():
    """Test longest substring without repeating characters"""
    sol = Solution()

    assert sol.lengthOfLongestSubstring("abcabcbb") == 3, "abcabcbb should have longest substring of length 3"
    assert sol.lengthOfLongestSubstring("bbbbb") == 1, "bbbbb should have longest substring of length 1"
    assert sol.lengthOfLongestSubstring("pwwkew") == 3, "pwwkew should have longest substring of length 3"

    print("✅ All longest substring tests passed!")

def test_group_anagrams():
    """Test group anagrams function"""
    sol = Solution()

    result = sol.groupAnagrams(["eat","tea","tan","ate","nat","bat"])
    expected = [["bat"],["nat","tan"],["ate","eat","tea"]]

    # Sort both result and expected for comparison
    result = [sorted(group) for group in result]
    expected = [sorted(group) for group in expected]
    result.sort()
    expected.sort()

    assert result == expected, f"Expected {expected}, got {result}"

    print("✅ All group anagrams tests passed!")

def test_longest_palindrome():
    """Test longest palindromic substring"""
    sol = Solution()

    assert sol.longestPalindrome("babad") in ["bab", "aba"], "babad should return bab or aba"
    assert sol.longestPalindrome("cbbd") == "bb", "cbbd should return bb"
    assert sol.longestPalindrome("a") == "a", "single char should return itself"

    print("✅ All longest palindrome tests passed!")

def test_edit_distance():
    """Test edit distance function"""
    sol = Solution()

    assert sol.minDistance("horse", "ros") == 3, "horse to ros should take 3 operations"
    assert sol.minDistance("intention", "execution") == 5, "intention to execution should take 5 operations"
    assert sol.minDistance("", "a") == 1, "empty to a should take 1 operation"

    print("✅ All edit distance tests passed!")

if __name__ == "__main__":
    print("🧪 Running String Problems Tests...\n")

    test_reverse_string()
    test_valid_anagram()
    test_first_unique_char()
    test_longest_substring()
    test_group_anagrams()
    test_longest_palindrome()
    test_edit_distance()

    print("\n🎉 All String problems tests passed! 🎉")

