# Tree - Complete Guide for Interviews

## What is Tree?

**Tree** is a core topic in data structures and algorithms. In interviews you are expected to know its definition, typical operations, time and space costs, and common patterns that show up in coding problems.

### Key characteristics

- **Purpose** — Hierarchical data structure for efficient search, insertion, deletion; models relationships like file systems or hierarchies.
- **Trade-offs** — Balanced trees (e.g., BST) offer O(log n) operations vs. unbalanced O(n); recursion common but can cause stack overflow.
- **Patterns** — DFS (pre/in/post-order), BFS, recursion, divide-and-conquer.

---

## Core concepts

### 1. Basic operations

- insert (add node)
- delete (remove node)
- search (find node by value)
- traverse (inorder, preorder, postorder, level-order)
- height/depth (max depth, node depth)

### 2. Time complexities (fill in for your topic)

| Operation | Time (typical) | Time (worst) | Space (auxiliary) |
|-----------|----------------|--------------|-------------------|
| Insert (BST) | O(log n) | O(n) | O(1) |
| Delete (BST) | O(log n) | O(n) | O(1) |
| Search (BST) | O(log n) | O(n) | O(1) |
| Traverse | O(n) | O(n) | O(h) recursion |
| Max Depth | O(n) | O(n) | O(h) recursion |

### 3. Common patterns

1. **Recognition** — "tree", "binary tree", "root", "left/right child", hierarchical data.
2. **Implementation** — Recursive for DFS, iterative with stack/queue; handle null nodes.
3. **Optimization** — Use BFS for level-order, DFS for path problems; memoization for repeated subproblems.

---

## Interview problems (easy to hard)

### Easy

1. [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) — LeetCode #104
2. [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) — LeetCode #226

### Medium

1. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) — LeetCode #94
2. [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/) — LeetCode #101

### Hard

1. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) — LeetCode #124
2. [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) — LeetCode #236

2. Extension or real-world style follow-up

---

## Learning path

1. Write the core API or algorithm from memory on paper.
2. Code it in Python and Java without looking at notes.
3. Solve two easy problems, then one medium, then revisit failures.
4. Drill one hard problem slowly; focus on proof of correctness.

See `python/01_basics.py` and `java/TreeBasics.java` for starter files generated with this topic.
