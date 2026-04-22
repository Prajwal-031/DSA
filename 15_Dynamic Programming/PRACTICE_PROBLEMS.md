# Dynamic Programming Practice Problems
## Problem Tracking  
### 
# Dynamic Programming Practice Problems
## Problem Tracking  

### Easy

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| Climbing Stairs | [#70](https://leetcode.com/problems/climbing-stairs/) | 1D DP / Fibonacci | `O(n)` | `O(1)` | Best first DP problem |
| Fibonacci Number | [#509](https://leetcode.com/problems/fibonacci-number/) | Base recurrence | `O(n)` | `O(1)` | Learn bottom-up transitions |
| Min Cost Climbing Stairs | [#746](https://leetcode.com/problems/min-cost-climbing-stairs/) | Cost minimization | `O(n)` | `O(1)` | Same shape as climb stairs with weights |

### Medium

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| House Robber | [#198](https://leetcode.com/problems/house-robber/) | Take / skip DP | `O(n)` | `O(1)` | Great for transition explanations |
| Coin Change | [#322](https://leetcode.com/problems/coin-change/) | Unbounded knapsack | `O(amount * n)` | `O(amount)` | Handles unreachable states |
| Longest Increasing Subsequence | [#300](https://leetcode.com/problems/longest-increasing-subsequence/) | Sequence DP | `O(n^2)` | `O(n)` | Classic interview sequence problem |
| Word Break | [#139](https://leetcode.com/problems/word-break/) | Prefix DP | `O(n^2)` | `O(n)` | Important string DP pattern |
| Unique Paths | [#62](https://leetcode.com/problems/unique-paths/) | Grid DP | `O(m * n)` | `O(m * n)` or `O(n)` | Good entry to 2D DP |

### Hard

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| Edit Distance | [#72](https://leetcode.com/problems/edit-distance/) | 2D string DP | `O(m * n)` | `O(m * n)` | Very common follow-up topic |
| Burst Balloons | [#312](https://leetcode.com/problems/burst-balloons/) | Interval DP | `O(n^3)` | `O(n^2)` | Hard but high-value pattern |
| Longest Common Subsequence | [#1143](https://leetcode.com/problems/longest-common-subsequence/) | 2D sequence DP | `O(m * n)` | `O(m * n)` | Useful for many string variants |

---

## Patterns to master for Dynamic Programming

### Pattern 1: Linear 1D DP

**When to use:** The answer at index `i` depends on only a few earlier states.
**Examples:** LeetCode [#70](https://leetcode.com/problems/climbing-stairs/), [#198](https://leetcode.com/problems/house-robber/)

### Pattern 2: Unbounded Choice DP

**When to use:** You can reuse a number, coin, or action multiple times.
**Examples:** LeetCode [#322](https://leetcode.com/problems/coin-change/)

### Pattern 3: Prefix / Suffix DP

**When to use:** Decide whether prefixes or suffixes are valid, optimal, or countable.
**Examples:** LeetCode [#139](https://leetcode.com/problems/word-break/)

### Pattern 4: Grid DP

**When to use:** Move through rows and columns with local transitions.
**Examples:** LeetCode [#62](https://leetcode.com/problems/unique-paths/), [#64](https://leetcode.com/problems/minimum-path-sum/)

### Pattern 5: 2D String DP

**When to use:** Compare two strings or sequences.
**Examples:** LeetCode [#72](https://leetcode.com/problems/edit-distance/), [#1143](https://leetcode.com/problems/longest-common-subsequence/)

---

## Interview tips

- Say the **state** before you write code.
- Write the **base cases** before the loop or recursion.
- Mention whether your solution is **top-down** or **bottom-up**.
- If you use a large DP table, explain whether it can be compressed.
- For impossible states, use a clear sentinel such as `float("inf")` or a large constant.

---

## Running Tests

### Python (PyTest)

```bash
cd "15_Dynamic Programming/python"
pytest test_dynamic_programming_basics.py -v
pytest test_dynamic_programming_basics.py::test_house_robber_examples -v
```

### Java (JUnit 5)

```bash
cd "15_Dynamic Programming"
mvn test
mvn test -Dtest=DynamicProgrammingBasicsTest#testWordBreak
```

---

## Suggested order

1. Climbing Stairs
2. House Robber
3. Coin Change
4. Word Break
5. Longest Increasing Subsequence
6. Edit Distance
