# Queue - Complete Guide for Interviews

## What is Queue?

**Queue** is a core topic in data structures and algorithms. In interviews you are expected to know its definition, typical operations, time and space costs, and common patterns that show up in coding problems.

### Key characteristics

- **Purpose** — Understand what problem Queue is designed to solve (ordering, lookup, optimization, etc.).
- **Trade-offs** — How choosing Queue affects time vs. space compared to alternatives.
- **Patterns** — Recognize when a problem statement maps to standard Queue techniques.

---

## Core concepts

### 1. Basic operations

- enqueue (insert at back)
- dequeue (remove and return front)
- peek / front (read front without removal)
- isEmpty, size
- support for circular buffer / ring buffer in fixed-capacity use cases

### 2. Time complexities (fill in for your topic)

| Operation | Time (typical) | Time (worst) | Space (auxiliary) |
|-----------|----------------|--------------|-------------------|
| Enqueue | O(1) | O(1) | O(1) |
| Dequeue | O(1) | O(1) | O(1) |
| Peek | O(1) | O(1) | O(1) |
| Size | O(1) | O(1) | O(1) |

### 3. Common patterns

1. **Recognition** — "first in first out", process stream in time order, breadth-first traversal, rate-limiting or scheduling.
2. **Implementation** — use built-in Queue, deque, or custom circular buffer/linked list.
3. **Optimization** — maintain monotonic deque for sliding max/min; compact window state to O(k) or O(1) in special cases.

1. **Recognition** — Keywords or constraints that suggest using Queue.
2. **Implementation** — Iterative vs recursive; edge cases (empty input, single element).
3. **Optimization** — Pruning, memoization, two pointers, auxiliary structures, etc.

---

## Interview problems (easy to hard)

### Easy

1. [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/) — LeetCode #232
2. [Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/) — LeetCode #933

### Medium

1. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) — LeetCode #239
2. [Design Hit Counter](https://leetcode.com/problems/design-hit-counter/) — LeetCode #362

### Hard

1. [Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) — LeetCode #862
2. [Swim in Rising Water](https://leetcode.com/problems/swim-in-rising-water/) — LeetCode #778 (queue + BFS + priority queue)

---

## Learning path

1. Write the core API or algorithm from memory on paper.
2. Code it in Python and Java without looking at notes.
3. Solve two easy problems, then one medium, then revisit failures.
4. Drill one hard problem slowly; focus on proof of correctness.

See `python/01_basics.py` and `java/QueueBasics.java` for starter files generated with this topic.
