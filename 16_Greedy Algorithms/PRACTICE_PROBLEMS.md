# Greedy Algorithms Practice Problems
## Problem Tracking

### Easy

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| Assign Cookies | [#455](https://leetcode.com/problems/assign-cookies/) | Sort + two pointers | `O(n log n + m log m)` | `O(1)` to `O(n + m)` | Match smallest cookie that satisfies each child |
| Best Time to Buy and Sell Stock | [#121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Track best previous price | `O(n)` | `O(1)` | Greedy local minimum before selling |
| Best Time to Buy and Sell Stock II | [#122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Add positive gains | `O(n)` | `O(1)` | Every upward step can be captured |
| Lemonade Change | [#860](https://leetcode.com/problems/lemonade-change/) | Preserve useful bills | `O(n)` | `O(1)` | Prefer giving `$10 + $5` before three `$5` bills |
| Is Subsequence | [#392](https://leetcode.com/problems/is-subsequence/) | Two pointers scan | `O(n)` | `O(1)` | Advance longer string only when match found |
| Minimum Subsequence in Non-Increasing Order | [#1403](https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/) | Prefix sum + sort reverse | `O(n log n)` | `O(1)` | Greedily take largest until sum >= half |
| Largest Perimeter Triangle | [#976](https://leetcode.com/problems/largest-perimeter-triangle/) | Sort descending check | `O(n log n)` | `O(1)` | Largest valid triangle from largest sides first |

### Medium

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| Jump Game | [#55](https://leetcode.com/problems/jump-game/) | Farthest reachable index | `O(n)` | `O(1)` | Stop when index is beyond reach |
| Jump Game II | [#45](https://leetcode.com/problems/jump-game-ii/) | Level-style coverage | `O(n)` | `O(1)` | Each jump expands the current range |
| Non-overlapping Intervals | [#435](https://leetcode.com/problems/non-overlapping-intervals/) | Earliest finish time | `O(n log n)` | `O(1)` to `O(n)` | Keep intervals that end earliest |
| Minimum Arrows to Burst Balloons | [#452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/) | Interval overlap | `O(n log n)` | `O(1)` to `O(n)` | One arrow covers the current overlap group |
| Partition Labels | [#763](https://leetcode.com/problems/partition-labels/) | Last occurrence boundary | `O(n)` | `O(1)` | Close a partition when current index reaches boundary |
| Boats to Save People | [#881](https://leetcode.com/problems/boats-to-save-people/) | Two pointer pairing | `O(n log n)` | `O(1)` to `O(n)` | Pair lightest with heaviest when possible |
| Merge Intervals | [#56](https://leetcode.com/problems/merge-intervals/) | Sort by start, merge overlap | `O(n log n)` | `O(n)` | Extend current interval if overlaps next |
| Meeting Rooms II | [#253](https://leetcode.com/problems/meeting-rooms-ii/) | Min-heap end times | `O(n log n)` | `O(n)` | Free room when earliest meeting ends |
| Gas Station | [#134](https://leetcode.com/problems/gas-station/) | Accumulate deficit, reset start | `O(n)` | `O(1)` | Unique solution or impossible |

### Hard

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| Candy | [#135](https://leetcode.com/problems/candy/) | Two directional passes | `O(n)` | `O(n)` | Local constraints from left and right |
| Minimum Number of Refueling Stops | [#871](https://leetcode.com/problems/minimum-number-of-refueling-stops/) | Max-heap fallback | `O(n log n)` | `O(n)` | Defer choosing fuel until you must |
| Course Schedule III | [#630](https://leetcode.com/problems/course-schedule-iii/) | Sort deadlines + max-heap | `O(n log n)` | `O(n)` | Replace longest course when over deadline |
| Remove K Digits | [#402](https://leetcode.com/problems/remove-k-digits/) | Monotonic stack | `O(n)` | `O(n)` | Remove peaks to minimize lexicographical value |

---

## Patterns to master for Greedy Algorithms

### Pattern 1: Sort by the right key

**When to use:** The problem is about choosing non-conflicting items, minimizing removals, or scheduling.
**Examples:** LeetCode [#435](https://leetcode.com/problems/non-overlapping-intervals/), [#452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/), [#56](https://leetcode.com/problems/merge-intervals/)

### Pattern 2: Farthest reach

**When to use:** You can extend coverage across an array or line.
**Examples:** LeetCode [#55](https://leetcode.com/problems/jump-game/), [#45](https://leetcode.com/problems/jump-game-ii/), [#134](https://leetcode.com/problems/gas-station/)

### Pattern 3: Pair extremes

**When to use:** Sorting plus smallest/largest pairing can prove an exchange argument.
**Examples:** LeetCode [#455](https://leetcode.com/problems/assign-cookies/), [#881](https://leetcode.com/problems/boats-to-save-people/), [#976](https://leetcode.com/problems/largest-perimeter-triangle/)

### Pattern 4: Accumulate safe gains

**When to use:** Every positive local improvement contributes independently to the final answer.
**Examples:** LeetCode [#122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

### Pattern 5: Heap for delayed choice

**When to use:** You scan in order, but the best previous candidate should be chosen only when needed.
**Examples:** LeetCode [#871](https://leetcode.com/problems/minimum-number-of-refueling-stops/), [#630](https://leetcode.com/problems/course-schedule-iii/), [#402](https://leetcode.com/problems/remove-k-digits/)

---

## Interview tips

- Always explain the **greedy choice** and why it is safe.
- Sort intentionally; say why the chosen ordering helps.
- Try to disprove your own rule with a small counterexample.
- If greedy fails because future choices change earlier decisions, consider DP.
- Keep edge cases ready: empty input, one element, already optimal, impossible target, and ties.

---

## Suggested order

1. Best Time to Buy and Sell Stock II
2. Assign Cookies
3. Jump Game
4. Jump Game II
5. Non-overlapping Intervals
6. Minimum Number of Refueling Stops
7. Merge Intervals
8. Gas Station
9. Remove K Digits
