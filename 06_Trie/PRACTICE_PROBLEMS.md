# Trie Practice Problems - Interview Preparation

## Problem list (by difficulty)

### Easy (start here)

1. **[Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)** - LeetCode 208  
   - Pattern: core trie API (`insert/search/startsWith`)  
   - Time: O(L) per op, Space: O(total chars)

2. **[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)** - LeetCode 14  
   - Pattern: trie traversal of shared prefixes (sorting approach also common)  
   - Time: O(total chars), Space: O(total chars) with trie

### Medium (build skills)

1. **[Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)** - LeetCode 211  
   - Pattern: trie + DFS for wildcard `.`  
   - Time: add O(L), search O(26^k) worst with k wildcards

2. **[Replace Words](https://leetcode.com/problems/replace-words/)** - LeetCode 648  
   - Pattern: shortest root lookup with trie  
   - Time: O(total sentence chars), Space: O(total root chars)

3. **[Map Sum Pairs](https://leetcode.com/problems/map-sum-pairs/)** - LeetCode 677  
   - Pattern: trie + prefix sum accumulation  
   - Time: insert O(L), sum O(P)

### Hard (master level)

1. **[Word Search II](https://leetcode.com/problems/word-search-ii/)** - LeetCode 212  
   - Pattern: trie + grid DFS + pruning visited paths  
   - Time: depends on board/words; pruning is key

2. **[Maximum XOR of Two Numbers in an Array](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)** - LeetCode 421  
   - Pattern: bitwise trie (0/1 branches)  
   - Time: O(32n), Space: O(32n)

---

## Patterns to master

1. **Prefix traversal**  
   - Walk character-by-character; fail early when child is missing.

2. **Trie + DFS backtracking**  
   - Use trie node state to cut invalid branches early.

3. **Bitwise trie**  
   - For XOR maximization, prefer opposite bit at each level.

---

## Interview tips

- Start by defining trie as a **prefix tree** and mention `O(L)` operations.
- Clarify node design: `children` map/array + `isEnd` flag.
- In Java, discuss `HashMap<Character, Node>` vs fixed array (`Node[26]`) tradeoff.
- For wildcard search, explain DFS branching and pruning clearly.

---

**Happy coding**
