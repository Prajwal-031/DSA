# Hash Tables Practice Problems - Interview Preparation

## Problem Tracking

### Easy ⭐

| Problem | LeetCode | Difficulty | Status | Pattern | Time | Space |
|---------|----------|------------|--------|---------|------|-------|
| Two Sum | [#1](https://leetcode.com/problems/two-sum/) | Easy | ✅ | Hash map lookup | O(n) | O(n) |
| Contains Duplicate | [#217](https://leetcode.com/problems/contains-duplicate/) | Easy | ✅ | Set deduplication | O(n) | O(n) |
| Valid Anagram | [#242](https://leetcode.com/problems/valid-anagram/) | Easy | ✅ | Frequency count | O(n) | O(1) |
| First Unique Character | [#387](https://leetcode.com/problems/first-unique-character-in-a-string/) | Easy | ✅ | Frequency + iterate | O(n) | O(1) |

### Medium 🟡

| Problem | LeetCode | Difficulty | Status | Pattern | Time | Space |
|---------|----------|------------|--------|---------|------|-------|
| Group Anagrams | [#49](https://leetcode.com/problems/group-anagrams/) | Medium | ✅ | Sorted key grouping | O(n*k log k) | O(n*k) |
| Top K Frequent Elements | [#347](https://leetcode.com/problems/top-k-frequent-elements/) | Medium | ✅ | Heap + hash | O(n log k) | O(n) |
| Happy Number | [#202](https://leetcode.com/problems/happy-number/) | Easy | ✅ | Cycle detection | O(log n) | O(1) |
| Isomorphic Strings | [#205](https://leetcode.com/problems/isomorphic-strings/) | Easy | ✅ | Character mapping | O(n) | O(1) |

### Hard 🔴

| Problem | LeetCode | Difficulty | Status | Pattern | Time | Space |
|---------|----------|------------|--------|---------|------|-------|
| LRU Cache | [#146](https://leetcode.com/problems/lru-cache/) | Hard | ⏳ | HashMap + DoublyLinkedList | O(1) | O(capacity) |
| Longest Consecutive | [#128](https://leetcode.com/problems/longest-consecutive-elements/) | Hard | ✅ | Set + smart iteration | O(n) | O(n) |
| LFU Cache | [#460](https://leetcode.com/problems/lfu-cache/) | Hard | ⏳ | HashMap + MinHeap | O(1) | O(capacity) |

---

## Key Patterns to Master

### Pattern 1: Two Sum (Hash Map for Complement)
**Use when:** Need to find pairs with specific sum/property
**Example:** LeetCode 1
```
1. Create empty hash map
2. For each element, check if complement (target - element) exists
3. If yes, return pair; if no, add element to map
```

### Pattern 2: Frequency Counting
**Use when:** Need to count occurrences or find duplicates
**Example:** LeetCode 387, 242
```
1. Create hash map for counts
2. Iterate and count all elements
3. Query by frequency or find unique
```

### Pattern 3: Grouping by Key
**Use when:** Need to group similar elements
**Example:** LeetCode 49 (anagrams)
```
1. For each element, compute group key (e.g., sorted string)
2. Add to hash map with key
3. Return grouped results
```

### Pattern 4: Cycle Detection
**Use when:** Need to detect loops or cycles
**Example:** LeetCode 202 (happy number)
```
1. Store seen values
2. Follow transformation rules
3. Detect when value repeats (cycle found)
```

### Pattern 5: Character/String Mapping
**Use when:** Need pattern matching or isomorphic detection
**Example:** LeetCode 205
```
1. Map each char in first string to char in second
2. Ensure mapping is consistent and bijective
3. Return true if valid mapping
```

---

## Running Tests

### Python (PyTest)
```bash
cd python
pytest test_01_basics.py -v
pytest test_01_basics.py::TestTwoSum -v  # Run specific class
```

### Java (Standalone - No JUnit needed)
```bash
cd java
javac HashTablesBasics.java HashTablesBasicsTest.java
java HashTablesBasicsTest
```

---

## Interview Tips

1. **Define clearly** — "Hash Table maps keys to values with O(1) average lookup"
2. **Edge cases** — Empty input, duplicates, single element, large numbers
3. **Always state worst-case** — O(n) collision handling, not just O(1) average
4. **Follow-ups** — Custom hash function? Resize when load factor > 0.75? Handle negative keys?
5. **Space trade-off** — Often O(n) space to achieve O(n) time instead of O(n²)

---

## Resources

- **Hash Function Visualization:** https://www.cs.usfca.edu/~galles/visualization/ClosedHashing.html
- **LeetCode Discuss:** Read top global solutions for optimal approaches
- **Practice Tips:** Solve without hash table first (brute force), then optimize
