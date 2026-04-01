# Stack - Complete Guide for Interviews

## What is a Stack?

A **stack** is a linear data structure that follows **Last-In-First-Out (LIFO)**: the last element added is the first one removed. Think of a stack of plates—you only add or remove from the **top**.

### Key characteristics

- **LIFO ordering** — `pop` removes what was most recently `push`ed
- **Restricted access** — typically only the top is visible (`peek`)
- **Sequential processing** — great for nested structure, undo, DFS, and “most recent” tracking

---

## Core concepts

### 1. Basic operations

| Operation | Meaning |
|-----------|---------|
| **push(x)** | Add `x` to the top |
| **pop()** | Remove and return the top element |
| **peek() / top()** | View the top without removing |
| **isEmpty()** | Whether the stack has no elements |
| **size()** | Number of elements |

In Python, `list` with `append`/`pop` works; `collections.deque` is also common. In Java, `Deque` / `ArrayDeque` is preferred over legacy `Stack` for performance and API clarity.

### 2. Time complexities

| Operation | Time | Space (per op) |
|-----------|------|----------------|
| push | O(1) | O(1) |
| pop | O(1) | O(1) |
| peek | O(1) | O(1) |
| Overall for n pushes | — | O(n) total space |

### 3. Common patterns

1. **Matching / nesting** — parentheses, brackets, tags (`Valid Parentheses`)
2. **Monotonic stack** — keep stack increasing or decreasing to find next greater/smaller element
3. **Auxiliary stack** — track min/max alongside main stack (`Min Stack`)
4. **DFS** — explicit stack instead of recursion (tree/graph)
5. **Undo / backtracking** — push state, pop to revert

---

## Interview problems (easy → hard)

### Easy

1. **Valid Parentheses** — balanced `()`, `[]`, `{}`
2. **Implement Stack using Queues** — simulate LIFO with FIFO structures

### Medium

1. **Min Stack** — O(1) push, pop, and `getMin`
2. **Daily Temperatures** — next warmer day (monotonic stack)
3. **Decode String** — nested repetition with stack
4. **Asteroid Collision** — simulate collisions on a line

### Hard

1. **Largest Rectangle in Histogram** — monotonic stack + areas
2. **Trapping Rain Water** — can use stack variant (two pointers also common)

---

## Learning path

1. Implement push/pop/peek on paper and in code
2. Solve 2–3 easy “matching” problems
3. Learn **monotonic stack** with one medium (e.g. Daily Temperatures)
4. Try one hard histogram / area problem when comfortable

See `python/01_basics.py` and `java/StackBasics.java` for minimal working examples.
