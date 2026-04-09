/**
 * Hash Tables - Java Implementation
 * LeetCode Problems: 1, 217, 242, 387, 49, 347, 202, 205, 128
 */

import java.util.*;

public class HashTablesBasics {
    
    // ============= TWO SUM =============
    
    /**
     * LeetCode 1: Two Sum
     * Find two numbers that add up to target.
     * 
     * Time: O(n) | Space: O(n)
     * @param nums array of integers
     * @param target sum to find
     * @return indices of two numbers
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
    
    // ============= CONTAINS DUPLICATE =============
    
    /**
     * LeetCode 217: Contains Duplicate
     * Check if array has duplicate elements.
     * 
     * Time: O(n) | Space: O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        
        return false;
    }
    
    // ============= VALID ANAGRAM =============
    
    /**
     * LeetCode 242: Valid Anagram
     * Check if two strings are anagrams.
     * 
     * Time: O(n) | Space: O(1) - max 26 letters
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] charCount = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // ============= FIRST UNIQUE CHARACTER =============
    
    /**
     * LeetCode 387: First Unique Character in a String
     * Find first character that appears only once.
     * 
     * Time: O(n) | Space: O(1) - max 26 letters
     */
    public static int firstUniqChar(String s) {
        int[] charCount = new int[26];
        
        // Count frequencies
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Find first unique
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    // ============= GROUP ANAGRAMS =============
    
    /**
     * LeetCode 49: Group Anagrams
     * Group strings that are anagrams of each other.
     * 
     * Time: O(n*k log k) | Space: O(n*k)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String word : strs) {
            // Create canonical form (sorted characters)
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
    
    // ============= TOP K FREQUENT ELEMENTS =============
    
    /**
     * LeetCode 347: Top K Frequent Elements
     * Find k most frequent elements.
     * 
     * Time: O(n log k) | Space: O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Min heap to keep top k
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a) - freqMap.get(b)
        );
        
        for (int num : freqMap.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] result = new int[k];
        int i = 0;
        while (!heap.isEmpty()) {
            result[i++] = heap.poll();
        }
        
        return result;
    }
    
    // ============= HAPPY NUMBER =============
    
    /**
     * LeetCode 202: Happy Number
     * Check if number eventually reaches 1.
     * 
     * Time: O(log n) | Space: O(1)
     */
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
        }
        
        return n == 1;
    }
    
    private static int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
    
    // ============= ISOMORPHIC STRINGS =============
    
    /**
     * LeetCode 205: Isomorphic Strings
     * Check if strings have bijective character mapping.
     * 
     * Time: O(n) | Space: O(1)
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // Check s -> t mapping
            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) {
                    return false;
                }
            } else {
                sToT.put(sChar, tChar);
            }
            
            // Check t -> s mapping (bijective)
            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) {
                    return false;
                }
            } else {
                tToS.put(tChar, sChar);
            }
        }
        
        return true;
    }
    
    // ============= LONGEST CONSECUTIVE =============
    
    /**
     * LeetCode 128: Longest Consecutive Elements
     * Find longest consecutive sequence length.
     * 
     * Time: O(n) | Space: O(n)
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : numSet) {
            // Only start from sequence beginning
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
    
    // ============= INTERSECTION =============
    
    /**
     * LeetCode 349: Intersection of Two Arrays
     * Find common elements in two arrays.
     * 
     * Time: O(n + m) | Space: O(min(n, m))
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }
        
        int[] arr = new int[result.size()];
        int i = 0;
        for (int num : result) {
            arr[i++] = num;
        }
        
        return arr;
    }
    
    // ============= RANSOM NOTE =============
    
    /**
     * LeetCode 383: Ransom Note
     * Check if ransom note can be built from magazine.
     * 
     * Time: O(n) | Space: O(1)
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }
        
        return true;
    }
    
    // ============= MAJORITY ELEMENT =============
    
    /**
     * LeetCode 169: Majority Element
     * Find element appearing more than n/2 times.
     * 
     * Time: O(n) | Space: O(n)
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorityCount = nums.length / 2;
        
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > majorityCount) {
                return num;
            }
        }
        
        return -1;
    }
    
    // ============= FIND PAIRS WITH K DIFFERENCE =============
    
    /**
     * Find number of unique pairs with difference k.
     * 
     * Time: O(n) | Space: O(n)
     */
    public static int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int count = 0;
        for (int num : numSet) {
            if (numSet.contains(num + k)) {
                count++;
            }
        }
        
        return count;
    }
}