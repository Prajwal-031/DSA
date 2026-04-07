"""
Unit Tests for Pointer Techniques - PyTest
Run with: pytest test_01_basics.py -v
"""

import pytest
from basics_01 import (
    two_sum_sorted, reverse_string, is_palindrome, has_cycle, ListNode,
    max_area, three_sum, trap_rain_water, partition, remove_duplicates
)


# ============= TWO SUM II TESTS =============

class TestTwoSumSorted:
    def test_basic(self):
        assert two_sum_sorted([2, 7, 11, 15], 9) == [1, 2]
    
    def test_different_numbers(self):
        assert two_sum_sorted([2, 3, 4], 6) == [1, 2]
    
    def test_no_solution(self):
        assert two_sum_sorted([1, 2, 3], 10) == []
    
    def test_large_numbers(self):
        assert two_sum_sorted([1, 2, 3, 100], 103) == [3, 4]


# ============= REVERSE STRING TESTS =============

class TestReverseString:
    def test_basic(self):
        s = ['h', 'e', 'l', 'l', 'o']
        reverse_string(s)
        assert s == ['o', 'l', 'l', 'e', 'h']
    
    def test_single_char(self):
        s = ['a']
        reverse_string(s)
        assert s == ['a']
    
    def test_two_chars(self):
        s = ['a', 'b']
        reverse_string(s)
        assert s == ['b', 'a']
    
    def test_empty(self):
        s = []
        reverse_string(s)
        assert s == []


# ============= PALINDROME TESTS =============

class TestIsPalindrome:
    def test_valid_palindrome(self):
        assert is_palindrome("A man, a plan, a canal: Panama") == True
    
    def test_invalid_palindrome(self):
        assert is_palindrome("race a car") == False
    
    def test_single_char(self):
        assert is_palindrome("a") == True
    
    def test_spaces_and_punctuation(self):
        assert is_palindrome("0P") == False
    
    def test_numbers(self):
        assert is_palindrome("a.b,A,b,a") == True


# ============= LINKED LIST CYCLE TESTS =============

class TestHasCycle:
    def test_no_cycle(self):
        head = ListNode(1)
        head.next = ListNode(2)
        head.next.next = ListNode(3)
        assert has_cycle(head) == False
    
    def test_with_cycle(self):
        head = ListNode(3)
        node2 = ListNode(2)
        node3 = ListNode(0)
        node4 = ListNode(-4)
        head.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node2  # Cycle back to node2
        assert has_cycle(head) == True
    
    def test_single_node_no_cycle(self):
        head = ListNode(1)
        assert has_cycle(head) == False
    
    def test_self_cycle(self):
        head = ListNode(1)
        head.next = head
        assert has_cycle(head) == True
    
    def test_empty(self):
        assert has_cycle(None) == False


# ============= CONTAINER WITH WATER TESTS =============

class TestMaxArea:
    def test_basic(self):
        assert max_area([1, 8, 6, 2, 5, 4, 8, 3, 7]) == 49
    
    def test_simple(self):
        assert max_area([1, 1]) == 1
    
    def test_all_same_height(self):
        assert max_area([5, 5, 5, 5]) == 15
    
    def test_increasing_heights(self):
        assert max_area([1, 2, 3, 4, 5]) == 8


# ============= 3SUM TESTS =============

class TestThreeSum:
    def test_basic(self):
        result = three_sum([-1, 0, 1, 2, -1, -4])
        assert sorted(result) == [[-1, -1, 2], [-1, 0, 1]]
    
    def test_no_triplet(self):
        assert three_sum([0, 1, 1]) == []
    
    def test_all_zeros(self):
        assert three_sum([0, 0, 0, 0]) == [[0, 0, 0]]
    
    def test_negative_numbers(self):
        result = three_sum([-2, 0, 1, 1, 2])
        assert sorted(result) == [[-2, 0, 2], [-2, 1, 1]]


# ============= TRAPPING RAIN WATER TESTS =============

class TestTrapRainWater:
    def test_basic(self):
        assert trap_rain_water([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]) == 6
    
    def test_no_trap(self):
        assert trap_rain_water([1, 2, 3]) == 0
    
    def test_valley(self):
        assert trap_rain_water([4, 2, 0, 3, 2, 5]) == 9
    
    def test_empty(self):
        assert trap_rain_water([]) == 0
    
    def test_single_element(self):
        assert trap_rain_water([5]) == 0


# ============= PARTITION TESTS =============

class TestPartition:
    def test_basic(self):
        arr = [3, 1, 4, 1, 5, 9, 2, 6]
        partition(arr, 5)
        # Elements < 5 on left, >= 5 on right
        left_part = [x for x in arr if x < 5]
        right_part = [x for x in arr if x >= 5]
        assert len(left_part) + len(right_part) == len(arr)
    
    def test_all_less_than_pivot(self):
        arr = [1, 2, 3]
        partition(arr, 5)
        assert all(x < 5 for x in arr)
    
    def test_all_greater_than_pivot(self):
        arr = [5, 6, 7]
        partition(arr, 3)
        assert all(x >= 3 for x in arr)


# ============= REMOVE DUPLICATES TESTS =============

class TestRemoveDuplicates:
    def test_basic(self):
        arr = [1, 1, 2]
        length = remove_duplicates(arr)
        assert length == 2
        assert arr[:length] == [1, 2]
    
    def test_no_duplicates(self):
        arr = [1, 2, 3]
        length = remove_duplicates(arr)
        assert length == 3
    
    def test_all_duplicates(self):
        arr = [1, 1, 1, 1]
        length = remove_duplicates(arr)
        assert length == 1
        assert arr[:length] == [1]
    
    def test_single_element(self):
        arr = [1]
        length = remove_duplicates(arr)
        assert length == 1
