# Linklist - Complete Guide for Interviews

## What is Linklist?

**LinkedList** is a core topic in data structures and algorithms. In interviews you are expected to know its definition, typical operations, time and space costs, and common patterns that show up in coding problems.

### Key characteristics

- **Purpose** — Dynamic data structure for efficient insertions/deletions, especially in the middle; no fixed size like arrays.
- **Trade-offs** — O(1) insert/delete at known positions vs O(n) access; extra space for pointers.
- **Patterns** — Two pointers, fast/slow for cycles, reversal, merging.

---

## Core concepts

### 1. Basic operations

- insert (at head, tail, or position)
- delete (by value or position)
- search (traverse to find)
- traverse (iterate through nodes)
- reverse (in-place or with stack)

### 2. Time complexities (fill in for your topic)

| Operation | Time (typical) | Time (worst) | Space (auxiliary) |
|-----------|----------------|--------------|-------------------|
| Insert at head | O(1) | O(1) | O(1) |
| Insert at tail | O(1) | O(1) | O(1) |
| Delete at head | O(1) | O(1) | O(1) |
| Search | O(n) | O(n) | O(1) |
| Traverse | O(n) | O(n) | O(1) |

### 3. Common patterns

1. **Recognition** — "linked list", "nodes with next pointers", cycle detection, reversal.
2. **Implementation** — Iterative (two pointers) or recursive; handle null checks.
3. **Optimization** — Dummy head for simplicity, fast/slow pointers for cycles.

---

## Interview problems (easy to hard)

### Easy

1. [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) — LeetCode #206
2. [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) — LeetCode #21

### Medium

1. [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) — LeetCode #141
2. [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) — LeetCode #142

### Hard

1. [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) — LeetCode #23
2. [Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/) — LeetCode #138 (advanced with random pointers)

2. Extension or real-world style follow-up

---

## Learning path

1. Write the core API or algorithm from memory on paper.
2. Code it in Python and Java without looking at notes.
3. Solve two easy problems, then one medium, then revisit failures.
4. Drill one hard problem slowly; focus on proof of correctness.

See `python/01_basics.py` and `java/LinklistBasics.java` for starter files generated with this topic.
