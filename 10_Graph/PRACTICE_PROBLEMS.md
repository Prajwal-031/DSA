# Graph Practice Problems - Interview Preparation

## Problem list (by difficulty)

### Easy (start here)

1. **Number of Islands** — LeetCode #200
   - Pattern: DFS/BFS on 2D grid for connected components
   - Time: O(m*n), Space: O(m*n)

2. **Redundant Connection** — LeetCode #684
   - Pattern: union-find to detect cycle
   - Time: O(n α(n)), Space: O(n)

### Medium (build skills)

1. **Clone Graph** — LeetCode #133
   - Pattern: DFS/BFS with HashMap for node mapping
   - Time: O(V+E), Space: O(V)

2. **Course Schedule II** — LeetCode #210
   - Pattern: topological sort with DFS or Kahn's algorithm
   - Time: O(V+E), Space: O(V)

### Hard (master level)

1. **Network Delay Time** — LeetCode #743
   - Pattern: Dijkstra's shortest path algorithm
   - Time: O((V+E) log V), Space: O(V)

---

## Patterns to master for Graph

1. **DFS/BFS Traversal** — For connected components, pathfinding, reachability (200, 695).
2. **Dijkstra/Shortest Path** — For weighted graphs and minimum cost routes (743, 787).
3. **Topological Sort + Union-Find** — For DAGs and cycle detection (210, 684).

---

## Interview tips

- State the **definition** of Graph clearly in one sentence, then give one concrete example.
- Always mention **edge cases** before coding (empty graph, single node, disconnected).
- For runtime, say **worst case** unless the interviewer asks for average.
- Practice **explaining** your solution in two minutes without code.

---

**Happy coding**

**Happy coding**
