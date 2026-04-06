# Graph - Complete Guide for Interviews

## What is Graph?

**Graph** is a core topic in data structures and algorithms. In interviews you are expected to know its definition, typical operations, time and space costs, and common patterns that show up in coding problems.

### Key characteristics

- **Purpose** — Model networks, relationships, and connectivity; solve pathfinding, connectivity, and flow problems.
- **Trade-offs** — Adjacency list O(V+E) vs adjacency matrix O(V²); DFS/BFS linear but may need visited set.
- **Patterns** — DFS/BFS for traversal, union-find for connectivity, Dijkstra/Bellman-Ford for shortest paths.

---

## Core concepts

### 1. Basic operations

- add vertex / add edge
- traverse (DFS, BFS)
- find connected components
- detect cycle
- shortest path (unweighted: BFS; weighted: Dijkstra)

### 2. Time complexities (fill in for your topic)

| Operation | Time (typical) | Time (worst) | Space (auxiliary) |
|-----------|----------------|--------------|-------------------|
| DFS/BFS | O(V+E) | O(V+E) | O(V) visited |
| Dijkstra (min-heap) | O((V+E) log V) | O((V+E) log V) | O(V) dist |
| Floyd-Warshall | O(V³) | O(V³) | O(V²) |
| Union-Find | O(α(n)) | O(α(n)) | O(V) parent |

### 3. Common patterns

1. **Recognition** — "nodes", "edges", "connections", "path", "network", "reachable".
2. **Implementation** — Adjacency list (dict/map), visited set, recursive/iterative DFS, queue for BFS.
3. **Optimization** — Union-Find for connectivity, Dijkstra for shortest paths, topological sort for DAGs.

---

## Interview problems (easy to hard)

### Easy

1. [Number of Islands](https://leetcode.com/problems/number-of-islands/) — LeetCode #200
2. [Merge Connected Components](https://leetcode.com/problems/redundant-connection/) — LeetCode #684

### Medium

1. [Clone Graph](https://leetcode.com/problems/clone-graph/) — LeetCode #133
2. [Topological Sort](https://leetcode.com/problems/course-schedule-ii/) — LeetCode #210

### Hard

1. [Network Delay Time](https://leetcode.com/problems/network-delay-time/) — LeetCode #743 (Dijkstra)
2. [Minimum Cost to Connect All Cities](https://leetcode.com/problems/connecting-cities-with-minimum-cost/) — MST variant
2. Extension or real-world style follow-up

---

## Learning path

1. Write the core API or algorithm from memory on paper.
2. Code it in Python and Java without looking at notes.
3. Solve two easy problems, then one medium, then revisit failures.
4. Drill one hard problem slowly; focus on proof of correctness.

See `python/01_basics.py` and `java/GraphBasics.java` for starter files generated with this topic.
