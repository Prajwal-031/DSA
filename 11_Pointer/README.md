# Pointer - Complete Guide for Interviews

## What is Pointer?

**Pointer** is a fundamental technique in coding interviews used to solve problems efficiently by maintaining references to one or more positions in a data structure. Common patterns include **two-pointer**, **slow-fast pointer**, and **pointer manipulation in linked lists**.

### Key characteristics

- **Purpose** — Optimize space by avoiding extra data structures; solve in single or multiple passes.
- **Trade-offs** — O(1) auxiliary space vs. careful index/reference management.
- **Patterns** — Two-pointer, sliding window, cycle detection, merging sorted arrays, partition.

---

## Core concepts

### 1. Basic operations

- **Two Pointer Traversal** — Start from opposite ends, move toward center
- **Slow-Fast Pointer** — Detect cycles, find middle element
- **Pointer Sorting** — Partition (quicksort), merge operations
- **In-place Modification** — Remove duplicates, rearrange elements
- **Linked List Operations** — Reverse, detect cycle, find intersection

### 2. Time complexities

| Operation | Time (typical) | Space (auxiliary) | Use Case |
|-----------|---|---|---|
| Two-pointer search | O(n) | O(1) | Sorted array, container with water |
| Slow-fast cycle detect | O(n) | O(1) | Linked list cycle detection |
| Partition (in-place) | O(n) | O(1) | Quicksort, Dutch flag problem |
| Sliding window | O(n) | O(1) | Subarray/substring problems |
| Remove duplicates | O(n) | O(1) | Array modification |

### 3. Common patterns

1. **Two Pointers** — Start from both ends, converge to center
2. **Slow-Fast Pointers** — One moves 1 step, other moves 2 steps (cycle detection)
3. **Sliding Window** — Fixed/variable window with two pointers
4. **Partition** — Rearrange elements around pivot
5. **Runner Technique** — Second pointer at 2x speed of first

---

## Interview problems

### Easy ⭐

1. **[LeetCode 167 - Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)** | Sorted array, two pointers from ends
2. **[LeetCode 344 - Reverse String](https://leetcode.com/problems/reverse-string/)** | In-place reversal with two pointers
3. **[LeetCode 125 - Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)** | Two pointers, string validation

### Medium 🟡

1. **[LeetCode 11 - Container With Most Water](https://leetcode.com/problems/container-with-most-water/)** | Greedy two-pointer approach, O(n) time
2. **[LeetCode 15 - 3Sum](https://leetcode.com/problems/3sum/)** | Sorted array + two pointers to find triplets
3. **[LeetCode 141 - Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)** | Slow-fast pointer detection, O(n) time

### Hard 🔴

1. **[LeetCode 42 - Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)** | Two pointers with max heights, O(n) optimal
2. **[LeetCode 76 - Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)** | Sliding window with two pointers, O(n+m)
3. **[LeetCode 25 - Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)** | Linked list pointer manipulation

---

## Learning path

1. **Master basics** — Understand two-pointer & slow-fast concepts
2. **Easy problems** — LeetCode 167, 344, 125 (20 min each)
3. **Medium problems** — LeetCode 11, 15, 141 (30 min each)
4. **Hard problems** — LeetCode 42, 76, 25 (45+ min each)
5. **Practice variants** — Solve follow-ups and edge cases

See `python/01_basics.py` and `java/PointerBasics.java` for implementations.
See `python/test_01_basics.py` and `java/PointerBasicsTest.java` for unit tests.
