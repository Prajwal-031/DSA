# Travelling Salesman Practice Problems

## Problem Tracking

### Medium (Greedy Approx)

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| TSP Nearest Neighbor | N/A | Greedy closest unvisited | `O(n^2)` | `O(n)` | Start anywhere; tour closes to origin. Good 25% approx typically |
| Reconstruct Itinerary | [#332](https://leetcode.com/problems/reconstruct-itinerary/) | Hierholzer + greedy sort | `O(E log k)` | `O(V)` | Eulerian path variant; greedy next smallest |
| Shortest Path Visiting All Nodes | [#847](https://leetcode.com/problems/shortest-path-visiting-all-nodes/) | Bitmask DP | `O(V! / 2^V * V)` | `O(V * 2^V)` | Held-Karp exact for small V≤12 |

### Hard

| Problem | LeetCode | Pattern | Time | Space | Notes |
|---------|----------|---------|------|-------|-------|
| Find the Shortest Superstring | [#943](https://leetcode.com/problems/find-the-shortest-superstring/) | TSP on string overlaps | `O(n^2 2^n)` | `O(n 2^n)` | DP[mask][i] min cost to cover mask ending i |
| Minimum Cost to Connect All Points | [#1584] | MST greedy | `O(n^2 log n)` | `O(n^2)` | Prim/Kruskal for TSP preprocessing |

---

## Patterns to master

### Pattern 1: Nearest Neighbor Greedy
**When:** Symmetric distances, approx OK.  
Sort unvisited by dist from current.

### Pattern 2: Bitmask DP Exact
**When:** n≤16, exact needed.  
`dp[mask][city]`

---
Travelling Salesman Practice Problems

## Interview tips
- Always draw 4-city graph; trace greedy vs optimal
- Explain approx ratio: greedy ≤2*OPT - edge cases
- For coding: use INF=1e9 for missing edges
- Edge cases: n=1 (0), disconnected (impossible), self-loops=0
- Prove greedy "relative optimality" with exchange
