/**
 * Unit Tests for Hash Tables - Standalone (No JUnit required)
 * Run with: javac HashTablesBasics.java HashTablesBasicsTest.java && java HashTablesBasicsTest
 */

import java.util.*;

public class HashTablesBasicsTest {
    
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
    
    static void assertEquals(boolean expected, boolean actual, String testName) {
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
    
    // ============= TWO SUM TESTS =============
    
    static void testTwoSumBasic() {
        int[] result = HashTablesBasics.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result, "testTwoSumBasic");
    }
    
    static void testTwoSumDifferentIndices() {
        int[] result = HashTablesBasics.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result, "testTwoSumDifferentIndices");
    }
    
    static void testTwoSumSameElementTwice() {
        int[] result = HashTablesBasics.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result, "testTwoSumSameElementTwice");
    }
    
    static void testTwoSumNoSolution() {
        int[] result = HashTablesBasics.twoSum(new int[]{1, 2, 3}, 10);
        assertArrayEquals(new int[]{-1, -1}, result, "testTwoSumNoSolution");
    }
    
    // ============= CONTAINS DUPLICATE TESTS =============
    
    static void testContainsDuplicateYes() {
        assertTrue(HashTablesBasics.containsDuplicate(new int[]{1, 2, 3, 1}), "testContainsDuplicateYes");
    }
    
    static void testContainsDuplicateNo() {
        assertFalse(HashTablesBasics.containsDuplicate(new int[]{1, 2, 3, 4}), "testContainsDuplicateNo");
    }
    
    static void testContainsDuplicateSingleElement() {
        assertFalse(HashTablesBasics.containsDuplicate(new int[]{1}), "testContainsDuplicateSingleElement");
    }
    
    static void testContainsDuplicateAllSame() {
        assertTrue(HashTablesBasics.containsDuplicate(new int[]{1, 1, 1, 1}), "testContainsDuplicateAllSame");
    }
    
    // ============= VALID ANAGRAM TESTS =============
    
    static void testIsAnagramValid() {
        assertTrue(HashTablesBasics.isAnagram("anagram", "nagaram"), "testIsAnagramValid");
    }
    
    static void testIsAnagramInvalid() {
        assertFalse(HashTablesBasics.isAnagram("rat", "car"), "testIsAnagramInvalid");
    }
    
    static void testIsAnagramSameString() {
        assertTrue(HashTablesBasics.isAnagram("abc", "abc"), "testIsAnagramSameString");
    }
    
    static void testIsAnagramDifferentLengths() {
        assertFalse(HashTablesBasics.isAnagram("ab", "a"), "testIsAnagramDifferentLengths");
    }
    
    // ============= FIRST UNIQUE CHAR TESTS =============
    
    static void testFirstUniqCharBasic() {
        assertEquals(0, HashTablesBasics.firstUniqChar("leetcode"), "testFirstUniqCharBasic");
    }
    
    static void testFirstUniqCharSecond() {
        assertEquals(2, HashTablesBasics.firstUniqChar("loveleetcode"), "testFirstUniqCharSecond");
    }
    
    static void testFirstUniqCharNone() {
        assertEquals(-1, HashTablesBasics.firstUniqChar("aabb"), "testFirstUniqCharNone");
    }
    
    static void testFirstUniqCharSingle() {
        assertEquals(0, HashTablesBasics.firstUniqChar("a"), "testFirstUniqCharSingle");
    }
    
    // ============= GROUP ANAGRAMS TESTS =============
    
    static void testGroupAnagramsBasic() {
        List<List<String>> result = HashTablesBasics.groupAnagrams(
            new String[]{"eat", "tea", "ate", "tan", "nat"}
        );
        assertEquals(2, result.size(), "testGroupAnagramsBasic");
    }
    
    static void testGroupAnagramsSingle() {
        List<List<String>> result = HashTablesBasics.groupAnagrams(new String[]{"a"});
        assertEquals(1, result.size(), "testGroupAnagramsSingle");
    }
    
    // ============= TOP K FREQUENT TESTS =============
    
    static void testTopKFrequentBasic() {
        int[] result = HashTablesBasics.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        Arrays.sort(result);
        assertArrayEquals(new int[]{1, 2}, result, "testTopKFrequentBasic");
    }
    
    static void testTopKFrequentSingle() {
        int[] result = HashTablesBasics.topKFrequent(new int[]{1}, 1);
        assertArrayEquals(new int[]{1}, result, "testTopKFrequentSingle");
    }
    
    // ============= HAPPY NUMBER TESTS =============
    
    static void testIsHappyTrue7() {
        assertTrue(HashTablesBasics.isHappy(7), "testIsHappyTrue7");
    }
    
    static void testIsHappyFalse2() {
        assertFalse(HashTablesBasics.isHappy(2), "testIsHappyFalse2");
    }
    
    static void testIsHappyTrue19() {
        assertTrue(HashTablesBasics.isHappy(19), "testIsHappyTrue19");
    }
    
    static void testIsHappyTrue1() {
        assertTrue(HashTablesBasics.isHappy(1), "testIsHappyTrue1");
    }
    
    // ============= ISOMORPHIC STRINGS TESTS =============
    
    static void testIsIsomorphicValid() {
        assertTrue(HashTablesBasics.isIsomorphic("egg", "add"), "testIsIsomorphicValid");
    }
    
    static void testIsIsomorphicInvalid() {
        assertFalse(HashTablesBasics.isIsomorphic("foo", "bar"), "testIsIsomorphicInvalid");
    }
    
    static void testIsIsomorphicSame() {
        assertTrue(HashTablesBasics.isIsomorphic("abc", "abc"), "testIsIsomorphicSame");
    }
    
    static void testIsIsomorphicDifferentLengths() {
        assertFalse(HashTablesBasics.isIsomorphic("ab", "a"), "testIsIsomorphicDifferentLengths");
    }
    
    // ============= LONGEST CONSECUTIVE TESTS =============
    
    static void testLongestConsecutiveBasic() {
        assertEquals(4, HashTablesBasics.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 
            "testLongestConsecutiveBasic");
    }
    
    static void testLongestConsecutiveEmpty() {
        assertEquals(0, HashTablesBasics.longestConsecutive(new int[]{}), "testLongestConsecutiveEmpty");
    }
    
    static void testLongestConsecutiveSingle() {
        assertEquals(1, HashTablesBasics.longestConsecutive(new int[]{1}), "testLongestConsecutiveSingle");
    }
    
    static void testLongestConsecutiveAll() {
        assertEquals(5, HashTablesBasics.longestConsecutive(new int[]{1, 2, 3, 4, 5}), 
            "testLongestConsecutiveAll");
    }
    
    // ============= INTERSECTION TESTS =============
    
    static void testIntersectionBasic() {
        int[] result = HashTablesBasics.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        Arrays.sort(result);
        assertArrayEquals(new int[]{2}, result, "testIntersectionBasic");
    }
    
    static void testIntersectionMultiple() {
        int[] result = HashTablesBasics.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        Arrays.sort(result);
        assertArrayEquals(new int[]{4, 9}, result, "testIntersectionMultiple");
    }
    
    // ============= RANSOM NOTE TESTS =============
    
    static void testCanConstructInvalid() {
        assertFalse(HashTablesBasics.canConstruct("a", "b"), "testCanConstructInvalid");
    }
    
    static void testCanConstructValid() {
        assertTrue(HashTablesBasics.canConstruct("a", "a"), "testCanConstructValid");
    }
    
    static void testCanConstructMultiple() {
        assertTrue(HashTablesBasics.canConstruct("aa", "aab"), "testCanConstructMultiple");
    }
    
    static void testCanConstructEmpty() {
        assertTrue(HashTablesBasics.canConstruct("", "abc"), "testCanConstructEmpty");
    }
    
    // ============= MAJORITY ELEMENT TESTS =============
    
    static void testMajorityElementBasic() {
        assertEquals(3, HashTablesBasics.majorityElement(new int[]{3, 2, 3}), "testMajorityElementBasic");
    }
    
    static void testMajorityElementSingle() {
        assertEquals(1, HashTablesBasics.majorityElement(new int[]{1}), "testMajorityElementSingle");
    }
    
    // ============= FIND PAIRS TESTS =============
    
    static void testFindPairsBasic() {
        assertEquals(2, HashTablesBasics.findPairs(new int[]{3, 1, 4, 1, 5}, 2), "testFindPairsBasic");
    }
    
    static void testFindPairsNone() {
        assertEquals(0, HashTablesBasics.findPairs(new int[]{1, 2, 3}, 5), "testFindPairsNone");
    }
    
    static void testFindPairsNegativeK() {
        assertEquals(0, HashTablesBasics.findPairs(new int[]{1, 2, 3}, -1), "testFindPairsNegativeK");
    }
    
    // ============= MAIN TEST RUNNER =============
    
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   HASH TABLES - TEST SUITE         ");
        System.out.println("====================================\n");
        
        // Two Sum Tests
        System.out.println("--- Two Sum Tests ---");
        testTwoSumBasic();
        testTwoSumDifferentIndices();
        testTwoSumSameElementTwice();
        testTwoSumNoSolution();
        
        // Contains Duplicate Tests
        System.out.println("\n--- Contains Duplicate Tests ---");
        testContainsDuplicateYes();
        testContainsDuplicateNo();
        testContainsDuplicateSingleElement();
        testContainsDuplicateAllSame();
        
        // Valid Anagram Tests
        System.out.println("\n--- Valid Anagram Tests ---");
        testIsAnagramValid();
        testIsAnagramInvalid();
        testIsAnagramSameString();
        testIsAnagramDifferentLengths();
        
        // First Unique Char Tests
        System.out.println("\n--- First Unique Character Tests ---");
        testFirstUniqCharBasic();
        testFirstUniqCharSecond();
        testFirstUniqCharNone();
        testFirstUniqCharSingle();
        
        // Group Anagrams Tests
        System.out.println("\n--- Group Anagrams Tests ---");
        testGroupAnagramsBasic();
        testGroupAnagramsSingle();
        
        // Top K Frequent Tests
        System.out.println("\n--- Top K Frequent Elements Tests ---");
        testTopKFrequentBasic();
        testTopKFrequentSingle();
        
        // Happy Number Tests
        System.out.println("\n--- Happy Number Tests ---");
        testIsHappyTrue7();
        testIsHappyFalse2();
        testIsHappyTrue19();
        testIsHappyTrue1();
        
        // Isomorphic Strings Tests
        System.out.println("\n--- Isomorphic Strings Tests ---");
        testIsIsomorphicValid();
        testIsIsomorphicInvalid();
        testIsIsomorphicSame();
        testIsIsomorphicDifferentLengths();
        
        // Longest Consecutive Tests
        System.out.println("\n--- Longest Consecutive Tests ---");
        testLongestConsecutiveBasic();
        testLongestConsecutiveEmpty();
        testLongestConsecutiveSingle();
        testLongestConsecutiveAll();
        
        // Intersection Tests
        System.out.println("\n--- Intersection Tests ---");
        testIntersectionBasic();
        testIntersectionMultiple();
        
        // Ransom Note Tests
        System.out.println("\n--- Ransom Note Tests ---");
        testCanConstructInvalid();
        testCanConstructValid();
        testCanConstructMultiple();
        testCanConstructEmpty();
        
        // Majority Element Tests
        System.out.println("\n--- Majority Element Tests ---");
        testMajorityElementBasic();
        testMajorityElementSingle();
        
        // Find Pairs Tests
        System.out.println("\n--- Find Pairs Tests ---");
        testFindPairsBasic();
        testFindPairsNone();
        testFindPairsNegativeK();
        
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

