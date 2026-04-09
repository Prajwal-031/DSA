# Hash Tables - Complete Guide for Interviews

## What is Hash Table?

**Hash Table** is a data structure that implements an associative array—a structure that maps keys to values using a **hash function**. It's one of the most fundamental DS in interviews for optimization, deduplication, counting, and fast lookups.

### Key characteristics

- **Purpose** — Fast lookups (O(1) avg), counting frequencies, deduplication, grouping
- **Trade-offs** — O(1) average lookup vs. O(n) worst-case; extra space overhead
- **Patterns** — Two pointers with hash, frequency counting, grouping by property, caching

---

## Core concepts

### 1. Basic operations

- **Insert/Update** — Add or modify key-value pair
- **Delete** — Remove key-value pair
- **Lookup** — Retrieve value by key
- **Iteration** — Traverse all keys or values
- **Collision Handling** — Chaining or open addressing

### 2. Time complexities

| Operation | Time (average) | Time (worst) | Space | Use Case |
|-----------|---|---|---|---|
| Insert | O(1) | O(n) | O(n) | Add elements |
| Delete | O(1) | O(n) | — | Remove duplicates |
| Lookup | O(1) | O(n) | — | Find/verify presence |
| Update | O(1) | O(n) | — | Frequency counting |
| Traverse | O(n) | O(n) | — | Iterate all items |

### 3. Common patterns

1. **Frequency Counting** — Count occurrences of elements; find duplicates or majorities
2. **Deduplication** — Store seen elements in set; detect duplicates O(1)
3. **Grouping** — Group elements by property (anagrams, class, etc.)
4. **Two-pass Pattern** — First pass: populate hash table; Second pass: lookup/compare
5. **Character Mapping** — Map characters/strings to indices for pattern matching

---

## Interview problems

### Easy ⭐

1. **[LeetCode 1 - Two Sum](https://leetcode.com/problems/two-sum/)** | Hash map, one pass | O(n) time, O(n) space
2. **[LeetCode 217 - Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)** | Set lookup | O(n) time, O(n) space
3. **[LeetCode 242 - Valid Anagram](https://leetcode.com/problems/valid-anagram/)** | Frequency count | O(n) time, O(1) space (26 letters)
4. **[LeetCode 387 - First Unique Character](https://leetcode.com/problems/first-unique-character-in-a-string/)** | Frequency + iterate | O(n) time, O(1) space

### Medium 🟡

1. **[LeetCode 49 - Group Anagrams](https://leetcode.com/problems/group-anagrams/)** | Sort key grouping | O(n*k log k) time, O(n*k) space
2. **[LeetCode 347 - Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)** | Heap + hash | O(n log k) time, O(n) space
3. **[LeetCode 202 - Happy Number](https://leetcode.com/problems/happy-number/)** | Cycle detection | O(log n) time, O(1) space
4. **[LeetCode 205 - Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)** | Character mapping | O(n) time, O(1) space (26 letters)

### Hard 🔴

1. **[LeetCode 146 - LRU Cache](https://leetcode.com/problems/lru-cache/)** | HashMap + DoublyLinkedList | O(1) all ops, O(capacity) space
2. **[LeetCode 128 - Longest Consecutive](https://leetcode.com/problems/longest-consecutive-elements/)** | Set + smart iteration | O(n) time, O(n) space
3. **[LeetCode 460 - LFU Cache](https://leetcode.com/problems/lfu-cache/)** | HashMap + MinHeap | O(1) all ops, O(capacity) space

---

## Core patterns explained

### Pattern 1: Frequency Counting
```
Goal: Count element occurrences
Steps:
1. Create hash map
2. Iterate and increment counts
3. Query for specific frequencies
Example: LeetCode 387 (First Unique Char)
```

### Pattern 2: Deduplication
```
Goal: Find duplicates or unique elements
Steps:
1. Use set for O(1) lookup
2. Check if element seen
3. Return duplicates or unique
Example: LeetCode 217 (Contains Duplicate)
```

### Pattern 3: Grouping by Property
```
Goal: Group elements by common property
Steps:
1. Create hash map of groups
2. Sort/transform key for grouping
3. Aggregate elements
Example: LeetCode 49 (Group Anagrams)
```

### Pattern 4: Two-pass Algorithm
```
Goal: First collect info, then use for decisions
Steps:
1. First pass: populate hash table
2. Second pass: perform lookups/comparisons
Example: LeetCode 1 (Two Sum)
```

---

## Learning path

1. **Master basics** — Understand hash function, collisions, lookup/insert/delete
2. **Easy problems** — LeetCode 1, 217, 242, 387 (15-20 min each)
3. **Medium problems** — LeetCode 49, 347, 202, 205 (25-35 min each)
4. **Hard problems** — LeetCode 146, 128, 460 (45+ min each)
5. **Practice variants** — Solve follow-ups with space/time optimizations

See [python/hash_tables_basics.py](python/hash_tables_basics.py) and [java/HashTablesBasics.java](java/HashTablesBasics.java) for full implementations.
See `python/test_01_basics.py` and `java/HashTablesBasicsTest.java` for comprehensive unit tests.

---

## Resources

- **Visualization:** https://www.cs.usfca.edu/~galles/visualization/ClosedHashing.html
- **LeetCode Discuss:** Read top solutions for collision handling variants
- **Follow-ups:** Always ask about load factor, resize strategy, custom hash function
