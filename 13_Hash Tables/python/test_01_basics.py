"""
Unit Tests for Hash Tables - PyTest
Run with: pytest test_01_basics.py -v
"""

import pytest
from hash_tables_basics import (
    two_sum, contains_duplicate, is_anagram, first_unique_char,
    group_anagrams, top_k_frequent, is_happy, is_isomorphic,
    longest_consecutive, intersection, can_construct, majority_element,
    find_pairs
)
    


# ============= TWO SUM TESTS =============

class TestTwoSum:
    def test_basic(self):
        assert two_sum([2, 7, 11, 15], 9) == [0, 1]
    
    def test_different_indices(self):
        assert two_sum([3, 2, 4], 6) == [1, 2]
    
    def test_same_element_twice(self):
        assert two_sum([3, 3], 6) == [0, 1]
    
    def test_no_solution(self):
        assert two_sum([1, 2, 3], 10) == []


# ============= CONTAINS DUPLICATE TESTS =============

class TestContainsDuplicate:
    def test_has_duplicate(self):
        assert contains_duplicate([1, 2, 3, 1]) == True
    
    def test_no_duplicate(self):
        assert contains_duplicate([1, 2, 3, 4]) == False
    
    def test_single_element(self):
        assert contains_duplicate([1]) == False
    
    def test_all_same(self):
        assert contains_duplicate([1, 1, 1, 1]) == True


# ============= VALID ANAGRAM TESTS =============

class TestIsAnagram:
    def test_valid_anagram(self):
        assert is_anagram("anagram", "nagaram") == True
    
    def test_invalid_anagram(self):
        assert is_anagram("rat", "car") == False
    
    def test_same_string(self):
        assert is_anagram("abc", "abc") == True
    
    def test_different_lengths(self):
        assert is_anagram("ab", "a") == False
    
    def test_empty_strings(self):
        assert is_anagram("", "") == True


# ============= FIRST UNIQUE CHARACTER TESTS =============

class TestFirstUniqueChar:
    def test_basic(self):
        assert first_unique_char("leetcode") == 0
    
    def test_second_unique(self):
        assert first_unique_char("loveleetcode") == 2
    
    def test_no_unique(self):
        assert first_unique_char("aabb") == -1
    
    def test_single_char(self):
        assert first_unique_char("a") == 0
    
    def test_all_unique(self):
        assert first_unique_char("abcd") == 0


# ============= GROUP ANAGRAMS TESTS =============

class TestGroupAnagrams:
    def test_basic(self):
        result = group_anagrams(["eat", "tea", "ate", "eat", "tan", "ate", "nat"])
        assert len(result) == 2
        # Verify grouping (order may vary)
        # Should have groups: ["eat", "tea", "ate", "eat", "ate"] and ["tan", "nat"]
        all_words = []
        for group in result:
            all_words.extend(group)
        assert sorted(all_words) == sorted(["eat", "tea", "ate", "eat", "tan", "ate", "nat"])
    
    def test_single_word(self):
        result = group_anagrams(["a"])
        assert len(result) == 1
    
    def test_all_unique(self):
        result = group_anagrams(["ab", "cd", "ef"])
        assert len(result) == 3
    
    def test_empty_list(self):
        result = group_anagrams([])
        assert len(result) == 0


# ============= TOP K FREQUENT TESTS =============

class TestTopKFrequent:
    def test_basic(self):
        result = top_k_frequent([1, 1, 1, 2, 2, 3], 2)
        assert sorted(result) == [1, 2]
    
    def test_single_element(self):
        result = top_k_frequent([1], 1)
        assert result == [1]
    
    def test_k_equals_count(self):
        result = top_k_frequent([1, 2, 3], 3)
        assert sorted(result) == [1, 2, 3]
    
    def test_multiple_same_freq(self):
        result = top_k_frequent([4, 1, 1, 1, 2, 2, 3], 2)
        # Top 2 are 1 (freq 3) and 2 (freq 2)
        assert sorted(result) == [1, 2]


# ============= HAPPY NUMBER TESTS =============

class TestIsHappy:
    def test_happy_number_7(self):
        assert is_happy(7) == True
    
    def test_unhappy_number_2(self):
        assert is_happy(2) == False
    
    def test_happy_number_19(self):
        assert is_happy(19) == True
    
    def test_single_digit_1(self):
        assert is_happy(1) == True
    
    def test_small_unhappy(self):
        assert is_happy(4) == False


# ============= ISOMORPHIC STRINGS TESTS =============

class TestIsIsomorphic:
    def test_valid_isomorphic(self):
        assert is_isomorphic("egg", "add") == True
    
    def test_invalid_isomorphic(self):
        assert is_isomorphic("foo", "bar") == False
    
    def test_same_string(self):
        assert is_isomorphic("abc", "abc") == True
    
    def test_different_lengths(self):
        # This should return False due to length check
        assert is_isomorphic("ab", "a") == False
    
    def test_bidirectional_mapping(self):
        assert is_isomorphic("badc", "baba") == False


# ============= LONGEST CONSECUTIVE TESTS =============

class TestLongestConsecutive:
    def test_basic(self):
        assert longest_consecutive([100, 4, 200, 1, 3, 2]) == 4
    
    def test_empty(self):
        assert longest_consecutive([]) == 0
    
    def test_single_element(self):
        assert longest_consecutive([1]) == 1
    
    def test_all_consecutive(self):
        assert longest_consecutive([1, 2, 3, 4, 5]) == 5
    
    def test_unordered(self):
        assert longest_consecutive([9, 1,4, 7, 3,2,8,5,6]) == 9


# ============= INTERSECTION TESTS =============

class TestIntersection:
    def test_basic(self):
        result = intersection([1, 2, 2, 1], [2, 2])
        assert sorted(result) == [2]
    
    def test_multiple_common(self):
        result = intersection([4, 9, 5], [9, 4, 9, 8, 4])
        assert sorted(result) == [4, 9]
    
    def test_no_intersection(self):
        result = intersection([1, 2], [3, 4])
        assert len(result) == 0
    
    def test_empty_array(self):
        result = intersection([], [1, 2, 3])
        assert len(result) == 0


# ============= RANSOM NOTE TESTS =============

class TestCanConstruct:
    def test_valid_ransom_note(self):
        assert can_construct("a", "b") == False
    
    def test_valid_construction(self):
        assert can_construct("a", "a") == True
    
    def test_partial_match(self):
        assert can_construct("aa", "ab") == False
    
    def test_multiple_letters(self):
        assert can_construct("aa", "aab") == True
    
    def test_empty_ransom_note(self):
        assert can_construct("", "abc") == True


# ============= MAJORITY ELEMENT TESTS =============

class TestMajorityElement:
    def test_basic(self):
        assert majority_element([3, 2, 3]) == 3
    
    def test_single_element(self):
        assert majority_element([1]) == 1
    
    def test_large_majority(self):
        result = majority_element([2, 2, 1, 1, 1, 2, 2])
        assert result == 2


# ============= FIND PAIRS TESTS =============

class TestFindPairs:
    def test_basic(self):
        assert find_pairs([3, 1, 4, 1, 5], 2) == 2
    
    def test_no_pairs(self):
        assert find_pairs([1, 2, 3], 5) == 0
    
    def test_negative_k(self):
        assert find_pairs([1, 2, 3], -1) == 0
    
    def test_zero_difference(self):
        # For [1, 1, 2, 2] with k=0, pairs are (1,1) and (2,2) = 2 pairs
        assert find_pairs([1, 1, 2, 2], 0) == 2
    
    def test_duplicates(self):
        # For [1, 3, 1, 5, 4] with k=0, set is {1, 3, 4, 5}
        # Each number has itself in the set, so count = 4
        assert find_pairs([1, 3, 1, 5, 4], 0) == 4

