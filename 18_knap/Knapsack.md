# 0/1 Knapsack - NP-Complete Dynamic Programming

## Problem Statement
Given:
- `n` items, each with `weight[i]` and `value[i]`
- Knapsack capacity `W`

Find subset of items maximizing total value where total weight ≤ `W`.

**NP-Complete**: Optimal substructure + overlapping subproblems solved via DP.

## Approach
```
dp[i][w] = max value using first i items with capacity w

dp[i][w] = max( dp[i-1][w] ,                     // exclude item i
                dp[i-1][w-weight[i]] + value[i] ) // include item i
```

## Complexity
- Time: **O(nW)**
- Space: **O(nW)**

## Example
```
weights = [10,20,30]
values = [60,100,120]  
W = 50

Optimal: items 1 & 2 → value=160, weight=30
```

**DP grows exponentially with W** → pseudo-polynomial time.
True NP-hard nature shown with arbitrary precision weights.
