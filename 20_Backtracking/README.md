# Backtracking
### Complete Guide for Interviews

## What is Backtracking?

**Backtracking** is a systematic way to iterate through all possible configurations of a search space. It builds candidates incrementally and abandons a candidate ("backtracks") as soon as it determines the candidate cannot possibly be completed to a valid solution.

You should think about backtracking when a problem asks for:

1. All possible combinations, permutations, or subsets
2. A sequence or arrangement satisfying constraints
3. A path through a grid or graph with restrictions
4. A decision tree where choices lead to dead ends

---

## How to recognize a backtracking problem

1. Define the **state** clearly.
   Example: `current_path`, `start_index`, `used[]`, `board[][]`
2. Identify the **choices** at each step.
   Example: pick next number, place queen, add parenthesis
3. Write the **constraints / pruning**.
   Example: skip duplicates, check board validity, prune by target
4. Choose the style:
   - **Subsets**: pick/skip each element
   - **Permutations**: swap and explore, or track used elements
   - **Combinations**: choose k from n with index tracking
   - **Constraint satisfaction**: place and validate (N-Queens, Sudoku)

---

## Core patterns

| Pattern | Idea | Starter Problems |
|---------|------|------------------|
| Subsets | Pick or skip each element | [78. Subsets](https://leetcode.com/problems/subsets/) |
| Permutations | Arrange all elements in every order | [46. Permutations](https://leetcode.com/problems/permutations/) |
| Combination Sum | Reuse elements to reach target | [39. Combination Sum](https://leetcode.com/problems/combination-sum/) |
| Generate Parentheses | Build valid strings with balance rules | [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) |
| N-Queens | Place items with conflict checking | [51. N-Queens](https://leetcode.com/problems/n-queens/) |

---

## Complexity cheat sheet

| Problem shape | Typical time | Typical space |
|---------------|--------------|---------------|
| Subsets of n | `O(n * 2^n)` | `O(n)` recursion depth |
| Permutations of n | `O(n * n!)` | `O(n)` recursion depth |
| Combination sum | `O(n^(target/min))` | `O(target/min)` depth |
| N-Queens | `O(n!)` | `O(n)` board state |

---

## Interview problems (easy to hard)

### Easy

1. [78. Subsets](https://leetcode.com/problems/subsets/)
2. [46. Permutations](https://leetcode.com/problems/permutations/)
3. [77. Combinations](https://leetcode.com/problems/combinations/)

### Medium

1. [39. Combination Sum](https://leetcode.com/problems/combination-sum/)
2. [40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)
3. [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
4. [79. Word Search](https://leetcode.com/problems/word-search/)
5. [131. Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)

### Hard

1. [51. N-Queens](https://leetcode.com/problems/n-queens/)
2. [37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)
3. [140. Word Break II](https://leetcode.com/problems/word-break-ii/)

---

## Files in this section

- [README.md](/c:/Users/prajw/Documents/program/DSA/20_Backtracking/README.md)
- [PRACTICE_PROBLEMS.md](/c:/Users/prajw/Documents/program/DSA/20_Backtracking/PRACTICE_PROBLEMS.md)
- [python/01_basics.py](/c:/Users/prajw/Documents/program/DSA/20_Backtracking/python/01_basics.py)
- [python/test_backtracking_basics.py](/c:/Users/prajw/Documents/program/DSA/20_Backtracking/python/test_backtracking_basics.py)
- [java/BacktrackingBasics.java](/c:/Users/prajw/Documents/program/DSA/20_Backtracking/java/BacktrackingBasics.java)
- [java/test/BacktrackingBasicsTest.java](/c:/Users/prajw/Documents/program/DSA/20_Backtracking/java/test/BacktrackingBasicsTest.java)

---

## Running tests

### Python (PyTest)

```bash
cd "20_Backtracking/python"
pytest test_backtracking_basics.py -v
pytest test_backtracking_basics.py::test_subsets -v
```

### Java (JUnit 5)

```bash
cd "20_Backtracking"
mvn test
mvn test -Dtest=BacktrackingBasicsTest
```

If your repo is not using Maven yet, you can still run `BacktrackingBasicsTest.java` directly from IntelliJ or VS Code once JUnit 5 is available on the classpath.

---

## Learning path

1. Start with `subsets` to build intuition about pick/skip.
2. Move to `permutations` to understand swap/explore and used tracking.
3. Solve `combination_sum` to practice target-driven pruning.
4. Try `generate_parentheses` for constraint-based building.
5. Tackle `n_queens` for board-based constraint checking.
6. After each solution, ask:
   - What is the state at each recursion?
   - How do I prune invalid branches early?
   - Can I sort or use memoization to reduce work?

