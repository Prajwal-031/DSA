# Greedy Algorithms
### Complete Guide for Interviews

## What is a Greedy Algorithm?

A **greedy algorithm** builds the answer one local choice at a time, always picking the option that looks best right now.

Greedy works only when the local best choice can be proven to lead to a global optimum. In interviews, the code is often short, but the proof is the important part.

You should think about greedy when a problem asks for:

- The minimum or maximum number of actions
- Scheduling, intervals, or choosing compatible items
- Pairing or ordering items after sorting
- Making change, jumps, or coverage decisions
- Optimizing with a repeated local rule

---

## How to recognize a greedy problem

1. Look for a **local decision**.
   Example: choose the interval that ends earliest.
2. Sort or prioritize the input so the best local choice becomes clear.
   Example: sort meetings by end time.
3. Prove that the local choice is safe.
   Example: picking the earliest ending meeting leaves the most room for future meetings.
4. Check whether a counterexample breaks the rule.
   If the local rule fails, the problem may need dynamic programming or backtracking.

---

## Core patterns

| Pattern | Idea | Starter Problems |
|---------|------|------------------|
| Interval scheduling | Sort by end time, keep compatible intervals | [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/), [452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) |
| Jump and coverage | Track the farthest reachable index/range | [55. Jump Game](https://leetcode.com/problems/jump-game/), [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/) |
| Two arrays / pairing | Sort both sides and match smallest useful item | [455. Assign Cookies](https://leetcode.com/problems/assign-cookies/), [881. Boats to Save People](https://leetcode.com/problems/boats-to-save-people/) |
| Profit accumulation | Add every positive local gain | [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) |
| Heap-assisted greedy | Repeatedly choose current best candidate | [871. Minimum Number of Refueling Stops](https://leetcode.com/problems/minimum-number-of-refueling-stops/) |

---

## Complexity cheat sheet

| Problem shape | Typical time | Typical space |
|---------------|--------------|---------------|
| Single scan greedy | `O(n)` | `O(1)` |
| Sort then greedy scan | `O(n log n)` | `O(1)` to `O(n)` depending on sorting |
| Two pointer pairing | `O(n log n)` | `O(1)` to `O(n)` |
| Heap greedy | `O(n log n)` | `O(n)` |

---

## Interview problems (easy to hard)

### Easy

1. [455. Assign Cookies](https://leetcode.com/problems/assign-cookies/)
2. [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
3. [860. Lemonade Change](https://leetcode.com/problems/lemonade-change/)
4. [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/)
5. [1403. Minimum Subsequence in Non-Increasing Order](https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/)
6. [976. Largest Perimeter Triangle](https://leetcode.com/problems/largest-perimeter-triangle/)

### Medium

1. [55. Jump Game](https://leetcode.com/problems/jump-game/)
2. [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/)
3. [435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
4. [452. Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
5. [763. Partition Labels](https://leetcode.com/problems/partition-labels/)
6. [56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)
7. [253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)
8. [881. Boats to Save People](https://leetcode.com/problems/boats-to-save-people/)
9. [134. Gas Station](https://leetcode.com/problems/gas-station/)

### Hard

1. [135. Candy](https://leetcode.com/problems/candy/)
2. [871. Minimum Number of Refueling Stops](https://leetcode.com/problems/minimum-number-of-refueling-stops/)
3. [630. Course Schedule III](https://leetcode.com/problems/course-schedule-iii/)
4. [402. Remove K Digits](https://leetcode.com/problems/remove-k-digits/)

---

## Files in this section

- [README.md](/c:/Users/prajw/Documents/program/DSA/16_Greedy%20Algorithms/README.md)
- [PRACTICE_PROBLEMS.md](/c:/Users/prajw/Documents/program/DSA/16_Greedy%20Algorithms/PRACTICE_PROBLEMS.md)
- [python/01_basics.py](/c:/Users/prajw/Documents/program/DSA/16_Greedy%20Algorithms/python/01_basics.py)
- [python/test_greedy_algorithms_basics.py](/c:/Users/prajw/Documents/program/DSA/16_Greedy%20Algorithms/python/test_greedy_algorithms_basics.py)
- [java/GreedyAlgorithmsBasics.java](/c:/Users/prajw/Documents/program/DSA/16_Greedy%20Algorithms/java/GreedyAlgorithmsBasics.java)

---

## Running tests

### Python

```bash
cd "16_Greedy Algorithms/python"
pytest test_greedy_algorithms_basics.py -v
python 01_basics.py
```

### Java

```bash
cd "16_Greedy Algorithms/java"
javac GreedyAlgorithmsBasics.java
java GreedyAlgorithmsBasics
```

---

## Learning path

1. Start with `max_profit_unlimited_transactions` to see the simplest greedy rule.
2. Solve `assign_cookies` to practice sorting and matching.
3. Move to `can_jump` and `minimum_jumps` for reachability and coverage.
4. Solve `erase_overlap_intervals` to learn interval scheduling.
5. For every greedy solution, say the safe-choice reason before writing code.
