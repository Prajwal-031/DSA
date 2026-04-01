# Stack Practice Problems - Interview Preparation

## Problem list (by difficulty)

### Easy (start here)

1. **[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)** — LeetCode 20  
   - Pattern: stack for matching brackets  
   - Time: O(n), Space: O(n)

2. **[Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)** — LeetCode 225  
   - Pattern: two queues or one queue with rotation  
   - Time: push O(n) or pop O(n) depending on design, Space: O(n)

### Medium (build skills)

1. **[Min Stack](https://leetcode.com/problems/min-stack/)** — LeetCode 155  
   - Pattern: auxiliary stack (or store pairs `(value, minSoFar)`)  
   - Time: O(1) per op, Space: O(n)

2. **[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)** — LeetCode 739  
   - Pattern: monotonic decreasing stack + indices  
   - Time: O(n), Space: O(n)

3. **[Decode String](https://leetcode.com/problems/decode-string/)** — LeetCode 394  
   - Pattern: two stacks (repeat count + partial string) or one stack of frames  
   - Time: O(n), Space: O(n)

4. **[Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)** — LeetCode 735  
   - Pattern: simulate collisions with stack  
   - Time: O(n), Space: O(n)

### Hard (master level)

1. **[Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)** — LeetCode 84  
   - Pattern: monotonic stack + width from indices  
   - Time: O(n), Space: O(n)

2. **[Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)** — LeetCode 42  
   - Pattern: stack variant or two pointers (both common)  
   - Time: O(n), Space: O(n) for stack approach

---

## Patterns to master

1. **Bracket / nesting stacks**  
   - Push opening symbols; on closing, match top or fail.

2. **Monotonic stack**  
   - Maintain increasing or decreasing order; pop while condition breaks to find boundaries.

3. **Two-stack or auxiliary min**  
   - Main data + parallel stack for aggregates (min, max, frequency).

---

## Interview tips

- Say **LIFO** and give one real example (undo, call stack, DFS).
- For **O(1)** min stack, mention storing `(value, currentMin)` pairs or a second stack of mins.
- Draw **histogram** or **temperature** problems—monotonic stack clicks faster with a picture.
- Mention Java: prefer **`Deque<Integer> stack = new ArrayDeque<>()`** over legacy `Stack` class.

---

**Happy coding**
