# Travelling Salesman Problem (TSP)
### Complete Guide for Interviews

## What is TSP?

The **Travelling Salesman Problem** asks for the shortest possible route visiting each city exactly once and returning to the origin (tour) or not (path). It's NP-hard - no efficient exact algorithm exists for large n.

**Greedy approximation** (nearest neighbor): From current city, always visit closest unvisited neighbor. O(n²), 25-50% over optimal typically.

**Think TSP when:**
- Graph distances between all pairs of nodes
- Visit each exactly once, minimize total distance
- Approximation OK (no "exact" needed)
- n ≤ 20 for exact DP (Held-Karp O(n²2ⁿ))

---

## Core patterns

| Pattern | Idea | Starter Problems |
|---------|------|------------------|
| Nearest neighbor greedy | Always pick closest unvisited | General TSP approx, LC #943 |
| Minimum spanning tree approx | MST + extra edges | Christofides algorithm (1.5x approx) |
| Dynamic programming exact | Held-Karp: dp[mask][city] = min cost to visit mask ending at city | LC #847 (bitmask DP on graph) |

---

## Complexity cheat sheet

| Approach | Time | Space | Approx ratio |
|----------|------|-------|--------------|
| Nearest neighbor | O(n²) | O(n) | ≤ 50% over optimal (worst) |
| Christofides | O(n³) | O(n²) | ≤ 1.5x optimal |
| Held-Karp DP | O(n²2ⁿ) | O(n2ⁿ) | Exact |

---

## Interview problems (easy to medium)

### Easy/Medium
1. [Minimum Cost to Make at Least One Valid Path (#2435)](https://leetcode.com/problems/min-cost-to-make-at-least-one-valid-path-in-a-grid/) - Related grid TSP feel
2. [Shortest Path Visiting All Nodes (#847)](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) - Held-Karp style
3. [Find the Shortest Superstring (#943)** - TSP on strings

### Hard
1. Exact TSP implementations
2. k-TSP variants

---

## Files in this section
- [README.md](README.md)
- [PRACTICE_PROBLEMS.md](PRACTICE_PROBLEMS.md)
- [python/01_basics.py](python/01_basics.py)
- [python/test_travelling_salesman_basics.py](python/test_travelling_salesman_basics.py)
- [java/TravellingSalesmanBasics.java](java/TravellingSalesmanBasics.java)

---

## Running tests

### Python
```bash
cd "19_TravellingSalesman/python"
pytest test_travelling_salesman_basics.py -v
python 01_basics.py
```

### Java
```bash
cd "19_TravellingSalesman/java"
javac TravellingSalesmanBasics.java
java TravellingSalesmanBasics
```

---

## Learning path
1. Understand nearest_neighbor on small complete graphs
2. Prove greedy exchange argument (why swapping improves or equals)
3. Compare greedy vs brute-force on n=4-5 cities
4. Extend to asymmetric distances
5. Learn when DP becomes feasible (n≤16 typically)
