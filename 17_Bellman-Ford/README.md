# 17_Bellman-Ford Algorithm

## Overview
The Bellman-Ford algorithm computes the shortest paths from a single source vertex to all other vertices in a weighted directed graph. It can handle **negative weight edges** (unlike Dijkstra's) and can **detect negative weight cycles**.

## Algorithm Steps
1. Initialize distances: dist[source] = 0, dist[others] = ∞
2. Relax all edges |V|-1 times: for each edge (u, v, w), if dist[u] + w < dist[v], update dist[v]
3. Check for negative cycle: Relax edges once more. If any distance updates, negative cycle exists.

## Complexity
- **Time**: O(V * E)
- **Space**: O(V)

## Pseudocode
```
//Bellman-Ford Algorithm
function bellman_ford(graph, source):
    dist = [float('inf')] * V
    dist[source] = 0
    
    for _ in range(V - 1):
        for u, v, w in edges:
            if dist[u] != inf and dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
    
    # Check negative cycle
    for u, v, w in edges:
        if dist[u] != inf and dist[u] + w < dist[v]:
            raise ValueError("Negative cycle detected")
    
    return dist
```

## When to use
- Graphs with negative weights
- Negative cycle detection needed

## Implementations
- [Python](./python/01_basics.py)
- [Java](./java/BellmanFordBasics.java)

See [PRACTICE_PROBLEMS.md](./PRACTICE_PROBLEMS.md) for problems.

