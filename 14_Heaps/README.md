# Heaps - Complete Guide for Interviews

## What is Heaps?

A **Heap** is a complete binary tree data structure where every parent node is either greater than (MaxHeap) or smaller than (MinHeap) its children. Used for priority queues, kth largest/smallest, dynamic medians.

**Interview definition**: "Heap maintains the heap property via heapify-up/down in O(log n). Build heap O(n)."

### Key characteristics

- **Purpose**: Fast access to min/max (O(1) peek), insert/extract O(log n).
- **Trade-offs**: O(n) space vs arrays; slower than sorted arrays for some ops but better for dynamic.
- **Types**: MinHeap (smallest root), MaxHeap (largest root).

---

## Core concepts

### 1. Basic operations (implemented in code files)

- `push(val)`: Add leaf + heapify-up O(log n)
- `pop()`: Remove root + heapify-down O(log n)
- `peek()`: Root O(1)
- `build_heap(arr)`: Heapify all O(n)
- `size()`: O(1)

### 2. Time & Space complexities

| Operation    | Time (worst) | Space |
|--------------|--------------|-------|
| push         | O(log n)     | O(1)  |
| pop/heapify  | O(log n)     | O(1)  |
| peek         | O(1)         | O(1)  |
| build_heap   | O(n)         | O(1)  |
| kth largest  | O(n log k)   | O(k)  |

### 3. Common patterns

1. **k-largest/smallest**: MaxHeap/MinHeap of size k ([215](https://leetcode.com/problems/kth-largest-element-in-an-array/))
2. **Running median**: Two heaps ([295](https://leetcode.com/problems/find-median-from-data-stream/))
3. **Merge k sorted**: MinHeap of list heads ([23](https://leetcode.com/problems/merge-k-sorted-lists/))
4. **Keywords**: "kth", "priority", "median", "merge lists", "least/greatest"

**Edge cases**: Empty heap, single element, all equal, duplicates.

See `python/01_basics.py` (heapq), `java/HeapsBasics.java` (PriorityQueue) for code.

---

## Interview problems (easy to hard)

**See [PRACTICE_PROBLEMS.md](PRACTICE_PROBLEMS.md) for detailed analysis.**

### Easy

1. **[703. Kth Largest in Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)** - MinHeap size k
2. **[1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)** - MaxHeap simulate collisions

### Medium

1. **[215. Kth Largest in Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)** - Quickselect or MinHeap
2. **[295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)** - Max(left) + Min(right) heaps

### Hard

1. **[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)** - MinHeap of heads

---

---

## Learning path

1. Write the core API or algorithm from memory on paper.
2. Code it in Python and Java without looking at notes.
3. Solve two easy problems, then one medium, then revisit failures.
4. Drill one hard problem slowly; focus on proof of correctness.

See `python/01_basics.py` and `java/HeapsBasics.java` for starter files generated with this topic.
