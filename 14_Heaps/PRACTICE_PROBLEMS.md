# Heaps Practice Problems - Interview Preparation

## Problem list (by difficulty)

### Easy (start here)

1. **[703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)**  
   - Pattern: MinHeap of size k (track largest k elements)  
   - Time: O(log k) per add · Space: O(k)

2. **[1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)**  
   - Pattern: MaxHeap simulate priority smashing  
   - Time: O(n log n) · Space: O(n)

### Medium (build skills)

1. **[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)**  
   - Pattern: MinHeap size k or quickselect  
   - Time: O(n log k) heap / O(n) avg quickselect · Space: O(k)

2. **[295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)**  
   - Pattern: MaxHeap (lower half) + MinHeap (upper half), balance sizes  
   - Time: O(log n) per add · Space: O(n)

### Hard (master level)

1. **[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)**  
   - Pattern: MinHeap of k list heads, pop + push next  
   - Time: O(nk log k) n total nodes · Space: O(k)

---

## Patterns to master for Heaps

1. **kth largest/smallest** — Min/Max heap size k, add/poll to maintain.
2. **Dynamic median** — Partition data with two balanced heaps.
3. **Priority simulation** — Heap models natural priority (stones, tasks).
4. **Merge k sorted** — Heap reduces comparisons to log k.

---

## Interview tips

- **Definition**: Complete binary tree satisfying heap property. Array-based: parent i, children 2i+1/2i+2.
- **Edge cases**: k=1, k=n, empty lists, all equal values.
- **Complexity**: Always state worst-case log n, mention amortized if relevant.
- **Code aloud**: Explain heapify before coding.

**Run tests**: `pytest python/01_basics.py` | Compile Java + `mvn test` or IDE run.

See [README.md](README.md) for guide + code samples.
