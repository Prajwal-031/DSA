\PRACTICE_PROBLEMS.md
# Pointer Practice Problems

## Problem Tracking

### Easy ⭐

| Problem | LeetCode | Difficulty | Status | Notes |
|---------|----------|------------|--------|-------|
| Two Sum II | [#167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) | Easy | ✅ | Two pointers from ends |
| Reverse String | [#344](https://leetcode.com/problems/reverse-string/) | Easy | ✅ | In-place reversal |
| Valid Palindrome | [#125](https://leetcode.com/problems/valid-palindrome/) | Easy | ✅ | Filter & compare |

### Medium 🟡

| Problem | LeetCode | Difficulty | Status | Notes |
|---------|----------|------------|--------|-------|
| Container With Most Water | [#11](https://leetcode.com/problems/container-with-most-water/) | Medium | ✅ | Greedy, O(n) |
| 3Sum | [#15](https://leetcode.com/problems/3sum/) | Medium | ✅ | Sort + two pointers |
| Linked List Cycle | [#141](https://leetcode.com/problems/linked-list-cycle/) | Easy | ✅ | Slow-fast pointer |
| Remove Duplicates | [#26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Easy | ✅ | Write pointer |
| Valid Parentheses | [#20](https://leetcode.com/problems/valid-parentheses/) | Easy | ⏳ | Stack pattern |

### Hard 🔴

| Problem | LeetCode | Difficulty | Status | Notes |
|---------|----------|------------|--------|-------|
| Trapping Rain Water | [#42](https://leetcode.com/problems/trapping-rain-water/) | Hard | ✅ | Two pointers with heights |
| Minimum Window Substring | [#76](https://leetcode.com/problems/minimum-window-substring/) | Hard | ⏳ | Sliding window |
| Reverse Nodes in k-Group | [#25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | Hard | ⏳ | Linked list manipulation |

---

## Key Patterns to Master

### Pattern 1: Two Pointers (Convergence)
**When to use:** Sorted arrays, find pairs, partitioning
**Example:** LeetCode 167, 11, 15

### Pattern 2: Slow-Fast Pointers
**When to use:** Cycle detection, find middle/kth element
**Example:** LeetCode 141, 202

### Pattern 3: Sliding Window
**When to use:** Subarray/substring optimization
**Example:** LeetCode 76, 3, 438

### Pattern 4: In-Place Modification
**When to use:** Remove/rearrange elements with O(1) space
**Example:** LeetCode 26, 27, 80

---

## Running Tests

### Python (PyTest)
```bash
cd python
pytest test_01_basics.py -v
pytest test_01_basics.py::TestTwoSumSorted -v  # Run specific class
```

### Java (JUnit)
```bash
cd java
mvn test
mvn test -Dtest=PointerBasicsTest#testTwoSumBasic  # Run specific test
```

---

## Resources

- **Visualizations:** https://visualgo.net/en
- **LC Discuss:** Read top solutions for each problem
- **Follow-ups:** Always ask for adjacent/pointer-based variants
