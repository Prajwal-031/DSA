/**
 * Strings - Complete LeetCode Solutions in Java
 * =============================================
 * This file contains solutions to common String problems from LeetCode
 */

import java.util.*;

public class StringsBasics {

    // ============================================
    // EASY PROBLEMS
    // ============================================

    /**
     * 344. Reverse String - Two Pointers
     * Time: O(n), Space: O(1)
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 242. Valid Anagram - Hash Map
     * Time: O(n), Space: O(1) - since only 26 letters
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 387. First Unique Character in a String
     * Time: O(n), Space: O(1)
     */
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // ============================================
    // MEDIUM PROBLEMS
    // ============================================

    /**
     * 3. Longest Substring Without Repeating Characters - Sliding Window
     * Time: O(n), Space: O(min(n, m)) where m is charset size
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * 49. Group Anagrams - Hash Map
     * Time: O(n * k log k) where n is number of strings, k is max length
     * Space: O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Sort the string to create a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    /**
     * 5. Longest Palindromic Substring - Expand Around Center
     * Time: O(n^2), Space: O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindrome
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // ============================================
    // HARD PROBLEMS
    // ============================================

    /**
     * 72. Edit Distance - Dynamic Programming
     * Time: O(m*n), Space: O(m*n)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // dp[i][j] represents min operations to convert word1[0..i-1] to word2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // deletions needed
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // insertions needed
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // min of: replace, delete, insert
                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j - 1], // replace
                        Math.min(dp[i - 1][j], dp[i][j - 1]) // delete, insert
                    );
                }
            }
        }

        return dp[m][n];
    }

    // ============================================
    // TEST METHODS
    // ============================================

    public static void testReverseString() {
        StringsBasics solution = new StringsBasics();

        // Test case 1
        char[] s1 = {'h','e','l','l','o'};
        solution.reverseString(s1);
        assert Arrays.equals(s1, new char[]{'o','l','l','e','h'}) : "Test 1 failed";

        // Test case 2
        char[] s2 = {'H','a','n','n','a','h'};
        solution.reverseString(s2);
        assert Arrays.equals(s2, new char[]{'h','a','n','n','a','H'}) : "Test 2 failed";

        System.out.println("✅ Reverse string tests passed!");
    }

    public static void testValidAnagram() {
        StringsBasics solution = new StringsBasics();

        assert solution.isAnagram("anagram", "nagaram") : "anagram test failed";
        assert !solution.isAnagram("rat", "car") : "rat/car test failed";
        assert !solution.isAnagram("a", "ab") : "a/ab test failed";

        System.out.println("✅ Valid anagram tests passed!");
    }

    public static void testFirstUniqueChar() {
        StringsBasics solution = new StringsBasics();

        assert solution.firstUniqChar("leetcode") == 0 : "leetcode test failed";
        assert solution.firstUniqChar("loveleetcode") == 2 : "loveleetcode test failed";
        assert solution.firstUniqChar("aabb") == -1 : "aabb test failed";

        System.out.println("✅ First unique char tests passed!");
    }

    public static void testLongestSubstring() {
        StringsBasics solution = new StringsBasics();

        assert solution.lengthOfLongestSubstring("abcabcbb") == 3 : "abcabcbb test failed";
        assert solution.lengthOfLongestSubstring("bbbbb") == 1 : "bbbbb test failed";
        assert solution.lengthOfLongestSubstring("pwwkew") == 3 : "pwwkew test failed";

        System.out.println("✅ Longest substring tests passed!");
    }

    public static void testGroupAnagrams() {
        StringsBasics solution = new StringsBasics();

        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = solution.groupAnagrams(input);

        // Convert to sets for comparison (order doesn't matter)
        Set<Set<String>> resultSet = new HashSet<>();
        for (List<String> group : result) {
            resultSet.add(new HashSet<>(group));
        }

        Set<Set<String>> expectedSet = new HashSet<>();
        expectedSet.add(new HashSet<>(Arrays.asList("bat")));
        expectedSet.add(new HashSet<>(Arrays.asList("nat","tan")));
        expectedSet.add(new HashSet<>(Arrays.asList("ate","eat","tea")));

        assert resultSet.equals(expectedSet) : "Group anagrams test failed";

        System.out.println("✅ Group anagrams tests passed!");
    }

    public static void testLongestPalindrome() {
        StringsBasics solution = new StringsBasics();

        String result1 = solution.longestPalindrome("babad");
        assert result1.equals("bab") || result1.equals("aba") : "babad test failed";

        assert solution.longestPalindrome("cbbd").equals("bb") : "cbbd test failed";
        assert solution.longestPalindrome("a").equals("a") : "single char test failed";

        System.out.println("✅ Longest palindrome tests passed!");
    }

    public static void testEditDistance() {
        StringsBasics solution = new StringsBasics();

        assert solution.minDistance("horse", "ros") == 3 : "horse/ros test failed";
        assert solution.minDistance("intention", "execution") == 5 : "intention/execution test failed";
        assert solution.minDistance("", "a") == 1 : "empty/a test failed";

        System.out.println("✅ Edit distance tests passed!");
    }

    public static void main(String[] args) {
        System.out.println("🧪 Running String Problems Tests...\n");

        testReverseString();
        testValidAnagram();
        testFirstUniqueChar();
        testLongestSubstring();
        testGroupAnagrams();
        testLongestPalindrome();
        testEditDistance();

        System.out.println("\n🎉 All String problems tests passed! 🎉");
    }
}

