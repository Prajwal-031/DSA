# Dynamic Programming - Complete Guide for Interviews

## What is Dynamic Programming?

**Dynamic Programming (DP)** solves problems by breaking them into overlapping subproblems, storing intermediate answers, and reusing them instead of recomputing work.

You should think about DP when a problem asks for:

- The number of ways to do something
- The maximum or minimum possible value
- The longest or shortest valid structure
- A decision that depends on previous choices

---

## How to recognize a DP problem

1. Define the **state** clearly.
   Example: `dp[i]` = best answer using the first `i` elements.
2. Write the **transition**.
   Example: `dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])`
3. Lock down the **base cases**.
   Example: empty array, one element, `n = 0`, `target = 0`
4. Choose the style:
   - **Memoization**: top-down recursion + cache
   - **Tabulation**: bottom-up table
   - **Space optimization**: keep only the last few states when possible

---

## Core patterns

| Pattern | Idea | Starter Problems |
|---------|------|------------------|
| 1D DP | One index tracks progress | [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/), [198. House Robber](https://leetcode.com/problems/house-robber/) |
| Unbounded knapsack / coin style | Reuse items multiple times | [322. Coin Change](https://leetcode.com/problems/coin-change/) |
| Sequence DP | Compare or extend previous subsequences | [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/) |
| String segmentation | Decide if prefix/suffix is valid | [139. Word Break](https://leetcode.com/problems/word-break/) |
| Grid DP | Move through rows/columns | [62. Unique Paths](https://leetcode.com/problems/unique-paths/), [64. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/) |

---

## Complexity cheat sheet

| Problem shape | Typical time | Typical space |
|---------------|--------------|---------------|
| Fibonacci / climbing style | `O(n)` | `O(1)` to `O(n)` |
| House robber style | `O(n)` | `O(1)` |
| Coin change | `O(amount * coins)` | `O(amount)` |
| LIS (basic DP) | `O(n^2)` | `O(n)` |
| Word break | `O(n^2)` | `O(n)` |

---

## Interview problems (easy to hard)

### Easy

1. [70. Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
2. [509. Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)
3. [746. Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

### Medium

1. [198. House Robber](https://leetcode.com/problems/house-robber/)
2. [322. Coin Change](https://leetcode.com/problems/coin-change/)
3. [300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)
4. [139. Word Break](https://leetcode.com/problems/word-break/)

### Hard

1. [72. Edit Distance](https://leetcode.com/problems/edit-distance/)
2. [312. Burst Balloons](https://leetcode.com/problems/burst-balloons/)
3. [1143. Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)

---

## Files in this section

- [README.md](/c:/Users/prajw/Documents/program/DSA/15_Dynamic%20Programming/README.md)
- [PRACTICE_PROBLEMS.md](/c:/Users/prajw/Documents/program/DSA/15_Dynamic%20Programming/PRACTICE_PROBLEMS.md)
- [python/01_basics.py](/c:/Users/prajw/Documents/program/DSA/15_Dynamic%20Programming/python/01_basics.py)
- [python/test_dynamic_programming_basics.py](/c:/Users/prajw/Documents/program/DSA/15_Dynamic%20Programming/python/test_dynamic_programming_basics.py)
- [java/DynamicProgrammingBasics.java](/c:/Users/prajw/Documents/program/DSA/15_Dynamic%20Programming/java/DynamicProgrammingBasics.java)
- [java/test/DynamicProgrammingBasicsTest.java](/c:/Users/prajw/Documents/program/DSA/15_Dynamic%20Programming/java/test/DynamicProgrammingBasicsTest.java)

---

## Running tests

### Python (PyTest)

```bash
cd "15_Dynamic Programming/python"
pytest test_dynamic_programming_basics.py -v
pytest test_dynamic_programming_basics.py::test_coin_change_unreachable -v
```

### Java (JUnit 5)

```bash
cd "15_Dynamic Programming"
mvn test
mvn test -Dtest=DynamicProgrammingBasicsTest
```

If your repo is not using Maven yet, you can still run `DynamicProgrammingBasicsTest.java` directly from IntelliJ or VS Code once JUnit 5 is available on the classpath.

---

## Learning path

1. Start with `fibonacci` and `climb_stairs` to build intuition.
2. Move to `house_robber` to practice state transitions with decisions.
3. Solve `coin_change` to get comfortable with impossible states and sentinel values.
4. Compare top-down and bottom-up solutions for the same problem.
5. After each solution, ask:
   - What is the state?
   - What is the recurrence?
   - Can I reduce the space?
