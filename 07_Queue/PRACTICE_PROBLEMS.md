# Queue Practice Problems - Interview Preparation

## Problem list (by difficulty)

### Easy (start here)

1. **Implement Queue using Stacks** — LeetCode #232
   - Pattern: stack simulation / two-stack lazy transfer
   - Time: amortized O(1) enqueue/dequeue; Space: O(n)

2. **Number of Recent Calls** — LeetCode #933
   - Pattern: sliding window with queue maintained by arrival times
   - Time: O(n), Space: O(n)

### Medium (build skills)

1. **Sliding Window Maximum** — LeetCode #239
   - Pattern: monotonic deque; remove out-of-window indices
   - Time: O(n), Space: O(k)

2. **Design Hit Counter** — LeetCode #362
   - Pattern: fixed-size queue with timestamp aggregation
   - Time: O(1) average, Space: O(1) with bounded size approach

### Hard (master level)

1. **Shortest Subarray with Sum at Least K** — LeetCode #862
   - Pattern: prefix sums + monotonic deque for candidate start indices
   - Time: O(n), Space: O(n)

---

## Patterns to master for Queue

1. **Breadth-first Search** — use queue for level order traversal in trees/graphs (e.g., 102, 200).
2. **Sliding Window / Monotonic Queue** — maintain candidates for window min/max, often O(n) (239, 862).
3. **Two-stack queue** — implement queue API via two stacks for amortized O(1) operations.

---

## Interview tips

- State the **definition** of Queue clearly in one sentence, then give one concrete example.
- Always mention **edge cases** before coding (empty input, duplicates, overflow).
- Mention both **time** and **space** complexity and whether they’re worst-case/average-case.
- For functions with inputs, discuss how to handle invalid input in code.
- Practice **explaining** your solution in two minutes without code.

---

**Happy coding**
