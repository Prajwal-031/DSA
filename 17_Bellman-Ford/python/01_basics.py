#!/usr/bin/env python3
'''Bellman-Ford Basics - Shortest paths with negative weights.'''

from typing import List, Tuple, Dict
from math import inf

class NegativeCycleError(Exception):
    '''Raised when negative cycle detected.'''

def bellman_ford(n: int, edges: List[Tuple[int, int, int]], source: int = 0) -> Dict[int, float]:
    '''
    Compute shortest paths from source using Bellman-Ford.
    
    Args:
        n: Number of vertices (0 to n-1)
        edges: List of (u, v, w) where edge u->v weight w
        source: Starting vertex
    
    Returns:
        dict {vertex: dist}
    
    Raises:
        NegativeCycleError: If negative cycle reachable from source
    '''
    dist = {i: inf for i in range(n)}
    dist[source] = 0.0
    
    # Relax |V|-1 times
    for _ in range(n - 1):
        updated = False
        for u, v, w in edges:
            if dist[u] != inf and dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                updated = True
        if not updated:
            break  # Early termination optimization
    
    # Check for negative cycle
    for u, v, w in edges:
        if dist[u] != inf and dist[u] + w < dist[v]:
            raise NegativeCycleError('Negative cycle detected')
    
    return dist

if __name__ == '__main__':
    # Standard example graph with negative edge
    edges = [
        (0,1,6), (0,2,7),
        (1,2,5), (1,3,-4), (1,4,-14),
        (2,3,-8), (2,4,-2),
        (3,4,9)
    ]
    n = 5
    
    try:
        distances = bellman_ford(n, edges, 0)
        print('Distances from 0:', {k: v for k, v in distances.items() if v != inf})
    except NegativeCycleError as e:
        print(e)

    # Negative cycle example
    neg_edges = [(0,1,-1), (1,0,-1)]
    try:
        bellman_ford(2, neg_edges, 0)
    except NegativeCycleError as e:
        print(e)

