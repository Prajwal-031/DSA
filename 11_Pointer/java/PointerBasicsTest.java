/**
 * Unit Tests for Pointer Techniques - Standalone (No JUnit required)
 * Run with: javac PointerBasics.java PointerBasicsTest.java && java PointerBasicsTest
 */

import java.util.*;

public class PointerBasicsTest {
    
    static int totalTests = 0;
    static int passedTests = 0;
    static int failedTests = 0;
    
    // ============= TEST ASSERTIONS =============
    
    static void assertEquals(int expected, int actual, String testName) {
        totalTests++;
        if (expected == actual) {
            passedTests++;
            System.out.println("✓ PASS: " + testName);
        } else {
            failedTests++;
            System.out.println("✗ FAIL: " + testName);
            System.out.println("  Expected: " + expected + ", Got: " + actual);
        }
    }
    
    static void assertArrayEquals(int[] expected, int[] actual, String testName) {
        totalTests++;
        if (Arrays.equals(expected, actual)) {
            passedTests++;
            System.out.println("✓ PASS: " + testName);
        } else {
            failedTests++;
            System.out.println("✗ FAIL: " + testName);
            System.out.println("  Expected: " + Arrays.toString(expected) + ", Got: " + Arrays.toString(actual));
        }
    }
    
    static void assertArrayEquals(char[] expected, char[] actual, String testName) {
        totalTests++;
        if (Arrays.equals(expected, actual)) {
            passedTests++;
            System.out.println("✓ PASS: " + testName);
        } else {
            failedTests++;
            System.out.println("✗ FAIL: " + testName);
            System.out.println("  Expected: " + Arrays.toString(expected) + ", Got: " + Arrays.toString(actual));
        }
    }
    
    static void assertTrue(boolean condition, String testName) {
        totalTests++;
        if (condition) {
            passedTests++;
            System.out.println("✓ PASS: " + testName);
        } else {
            failedTests++;
            System.out.println("✗ FAIL: " + testName);
            System.out.println("  Expected: true, Got: false");
        }
    }
    
    static void assertFalse(boolean condition, String testName) {
        totalTests++;
        if (!condition) {
            passedTests++;
            System.out.println("✓ PASS: " + testName);
        } else {
            failedTests++;
            System.out.println("✗ FAIL: " + testName);
            System.out.println("  Expected: false, Got: true");
        }
    }
    
    // ============= TWO SUM II TESTS =============
    
    static void testTwoSumBasic() {
        int[] result = PointerBasics.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{1, 2}, result, "testTwoSumBasic");
    }
    
    static void testTwoSumDifferentNumbers() {
        int[] result = PointerBasics.twoSum(new int[]{2, 3, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result, "testTwoSumDifferentNumbers");
    }
    
    static void testTwoSumNoSolution() {
        int[] result = PointerBasics.twoSum(new int[]{1, 2, 3}, 10);
        assertArrayEquals(new int[]{-1, -1}, result, "testTwoSumNoSolution");
    }
    
    static void testTwoSumLargeNumbers() {
        int[] result = PointerBasics.twoSum(new int[]{1, 2, 3, 100}, 103);
        assertArrayEquals(new int[]{3, 4}, result, "testTwoSumLargeNumbers");
    }
    
    // ============= REVERSE STRING TESTS =============
    
    static void testReverseStringBasic() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        PointerBasics.reverseString(s);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s, "testReverseStringBasic");
    }
    
    static void testReverseStringSingleChar() {
        char[] s = {'a'};
        PointerBasics.reverseString(s);
        assertArrayEquals(new char[]{'a'}, s, "testReverseStringSingleChar");
    }
    
    static void testReverseStringTwoChars() {
        char[] s = {'a', 'b'};
        PointerBasics.reverseString(s);
        assertArrayEquals(new char[]{'b', 'a'}, s, "testReverseStringTwoChars");
    }
    
    static void testReverseStringEmpty() {
        char[] s = {};
        PointerBasics.reverseString(s);
        assertArrayEquals(new char[]{}, s, "testReverseStringEmpty");
    }
    
    // ============= PALINDROME TESTS =============
    
    static void testIsPalindromeValid() {
        assertTrue(PointerBasics.isPalindrome("A man, a plan, a canal: Panama"), "testIsPalindromeValid");
    }
    
    static void testIsPalindromeInvalid() {
        assertFalse(PointerBasics.isPalindrome("race a car"), "testIsPalindromeInvalid");
    }
    
    static void testIsPalindromeSingleChar() {
        assertTrue(PointerBasics.isPalindrome("a"), "testIsPalindromeSingleChar");
    }
    
    static void testIsPalindromeSpacesAndPunctuation() {
        assertFalse(PointerBasics.isPalindrome("0P"), "testIsPalindromeSpacesAndPunctuation");
    }
    
    static void testIsPalindromeNumbers() {
        assertTrue(PointerBasics.isPalindrome("a.b,A,b,a"), "testIsPalindromeNumbers");
    }
    
    // ============= LINKED LIST CYCLE TESTS =============
    
    static void testHasCycleNo() {
        PointerBasics.ListNode head = new PointerBasics.ListNode(1);
        head.next = new PointerBasics.ListNode(2);
        head.next.next = new PointerBasics.ListNode(3);
        assertFalse(PointerBasics.hasCycle(head), "testHasCycleNo");
    }
    
    static void testHasCycleYes() {
        PointerBasics.ListNode head = new PointerBasics.ListNode(3);
        PointerBasics.ListNode node2 = new PointerBasics.ListNode(2);
        PointerBasics.ListNode node3 = new PointerBasics.ListNode(0);
        PointerBasics.ListNode node4 = new PointerBasics.ListNode(-4);
        
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle
        
        assertTrue(PointerBasics.hasCycle(head), "testHasCycleYes");
    }
    
    static void testHasCycleSingleNode() {
        PointerBasics.ListNode head = new PointerBasics.ListNode(1);
        assertFalse(PointerBasics.hasCycle(head), "testHasCycleSingleNode");
    }
    
    static void testHasCycleSelfLoop() {
        PointerBasics.ListNode head = new PointerBasics.ListNode(1);
        head.next = head;
        assertTrue(PointerBasics.hasCycle(head), "testHasCycleSelfLoop");
    }
    
    static void testHasCycleNull() {
        assertFalse(PointerBasics.hasCycle(null), "testHasCycleNull");
    }
    
    // ============= CONTAINER WITH WATER TESTS =============
    
    static void testMaxAreaBasic() {
        int result = PointerBasics.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        assertEquals(49, result, "testMaxAreaBasic");
    }
    
    static void testMaxAreaSimple() {
        int result = PointerBasics.maxArea(new int[]{1, 1});
        assertEquals(1, result, "testMaxAreaSimple");
    }
    
    static void testMaxAreaAllSameHeight() {
        int result = PointerBasics.maxArea(new int[]{5, 5, 5, 5});
        assertEquals(15, result, "testMaxAreaAllSameHeight");
    }
    
    static void testMaxAreaIncreasingHeights() {
        int result = PointerBasics.maxArea(new int[]{1, 2, 3, 4, 5});
        assertEquals(8, result, "testMaxAreaIncreasingHeights");
    }
    
    // ============= 3SUM TESTS =============
    
    static void testThreeSumBasic() {
        List<List<Integer>> result = PointerBasics.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, result.size(), "testThreeSumBasic");
    }
    
    static void testThreeSumNoTriplet() {
        List<List<Integer>> result = PointerBasics.threeSum(new int[]{0, 1, 1});
        assertEquals(0, result.size(), "testThreeSumNoTriplet");
    }
    
    static void testThreeSumAllZeros() {
        List<List<Integer>> result = PointerBasics.threeSum(new int[]{0, 0, 0, 0});
        assertEquals(1, result.size(), "testThreeSumAllZeros");
    }
    
    static void testThreeSumNegativeNumbers() {
        List<List<Integer>> result = PointerBasics.threeSum(new int[]{-2, 0, 1, 1, 2});
        assertEquals(2, result.size(), "testThreeSumNegativeNumbers");
    }
    
    // ============= TRAPPING RAIN WATER TESTS =============
    
    static void testTrapBasic() {
        int result = PointerBasics.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        assertEquals(6, result, "testTrapBasic");
    }
    
    static void testTrapNoTrap() {
        int result = PointerBasics.trap(new int[]{1, 2, 3});
        assertEquals(0, result, "testTrapNoTrap");
    }
    
    static void testTrapValley() {
        int result = PointerBasics.trap(new int[]{4, 2, 0, 3, 2, 5});
        assertEquals(9, result, "testTrapValley");
    }
    
    static void testTrapEmpty() {
        int result = PointerBasics.trap(new int[]{});
        assertEquals(0, result, "testTrapEmpty");
    }
    
    static void testTrapSingleElement() {
        int result = PointerBasics.trap(new int[]{5});
        assertEquals(0, result, "testTrapSingleElement");
    }
    
    // ============= REMOVE DUPLICATES TESTS =============
    
    static void testRemoveDuplicatesBasic() {
        int[] arr = {1, 1, 2};
        int length = PointerBasics.removeDuplicates(arr);
        assertEquals(2, length, "testRemoveDuplicatesBasic");
    }
    
    static void testRemoveDuplicatesNoDuplicates() {
        int[] arr = {1, 2, 3};
        int length = PointerBasics.removeDuplicates(arr);
        assertEquals(3, length, "testRemoveDuplicatesNoDuplicates");
    }
    
    static void testRemoveDuplicatesAllDuplicates() {
        int[] arr = {1, 1, 1, 1};
        int length = PointerBasics.removeDuplicates(arr);
        assertEquals(1, length, "testRemoveDuplicatesAllDuplicates");
    }
    
    static void testRemoveDuplicatesSingleElement() {
        int[] arr = {1};
        int length = PointerBasics.removeDuplicates(arr);
        assertEquals(1, length, "testRemoveDuplicatesSingleElement");
    }
    
    // ============= MAIN TEST RUNNER =============
    
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   POINTER TECHNIQUES - TEST SUITE    ");
        System.out.println("====================================\n");
        
        // Two Sum II Tests
        System.out.println("--- Two Sum II Tests ---");
        testTwoSumBasic();
        testTwoSumDifferentNumbers();
        testTwoSumNoSolution();
        testTwoSumLargeNumbers();
        
        // Reverse String Tests
        System.out.println("\n--- Reverse String Tests ---");
        testReverseStringBasic();
        testReverseStringSingleChar();
        testReverseStringTwoChars();
        testReverseStringEmpty();
        
        // Palindrome Tests
        System.out.println("\n--- Palindrome Tests ---");
        testIsPalindromeValid();
        testIsPalindromeInvalid();
        testIsPalindromeSingleChar();
        testIsPalindromeSpacesAndPunctuation();
        testIsPalindromeNumbers();
        
        // Linked List Cycle Tests
        System.out.println("\n--- Linked List Cycle Tests ---");
        testHasCycleNo();
        testHasCycleYes();
        testHasCycleSingleNode();
        testHasCycleSelfLoop();
        testHasCycleNull();
        
        // Container with Water Tests
        System.out.println("\n--- Container with Water Tests ---");
        testMaxAreaBasic();
        testMaxAreaSimple();
        testMaxAreaAllSameHeight();
        testMaxAreaIncreasingHeights();
        
        // 3Sum Tests
        System.out.println("\n--- 3Sum Tests ---");
        testThreeSumBasic();
        testThreeSumNoTriplet();
        testThreeSumAllZeros();
        testThreeSumNegativeNumbers();
        
        // Trapping Rain Water Tests
        System.out.println("\n--- Trapping Rain Water Tests ---");
        testTrapBasic();
        testTrapNoTrap();
        testTrapValley();
        testTrapEmpty();
        testTrapSingleElement();
        
        // Remove Duplicates Tests
        System.out.println("\n--- Remove Duplicates Tests ---");
        testRemoveDuplicatesBasic();
        testRemoveDuplicatesNoDuplicates();
        testRemoveDuplicatesAllDuplicates();
        testRemoveDuplicatesSingleElement();
        
        // Summary
        System.out.println("\n====================================");
        System.out.println("   TEST SUMMARY");
        System.out.println("====================================");
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed: " + passedTests + " ✓");
        System.out.println("Failed: " + failedTests + " ✗");
        System.out.println("Success Rate: " + (totalTests > 0 ? (passedTests * 100 / totalTests) : 0) + "%");
        System.out.println("====================================\n");
        
        if (failedTests > 0) {
            System.exit(1);
        }
    }
}