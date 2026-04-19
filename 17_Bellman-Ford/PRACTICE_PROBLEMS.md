# Bellman-Ford Practice Problems

## Problem 1: Cheapest Flights Within K Stops (Negative Weights Variant)
**Difficulty**: Medium  
**Description**: There are n cities connected by m flights with prices (some negative due to discounts). Find the cheapest price from `src` to `dst` with at most `k` stops. Use Bellman-Ford modeling stops as layers or direct.  
**Input**: n, flights = [[from, to, price], ...], src, dst, k  
**Example**:  
```
n = 3, flights = [[0,1,-100],[1,2,100],[0,2,500]], src=0, dst=2, k=1
Output: -100 + 100 = 0 (via 0->1->2)
```

## Problem 2: Negative Cycle Detection
**Difficulty**: Medium  
**Description**: Given a graph with weights, detect if there is a negative weight cycle reachable from source. Return any vertex in the cycle or -1.  
**Input**: n, edges = [[u,v,w], ...], source  
**Example**: Cycle 0->1->0 with total -1 weight.

**Hints**: After V-1 relaxations, one more pass to find updatable edge; backtrack with parent.

*Solve in `python/01_basics.py` extensions.*

