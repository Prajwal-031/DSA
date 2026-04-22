"""
Travelling Salesman Problem - Interview prep (Python)
====================================================

Greedy nearest neighbor approximation: O(n^2), simple, practical.
"""

from __future__ import annotations
from typing import List, Tuple
import math

INF = 1e9


class TravellingSalesmanBasics:
    \"\"\"Core TSP greedy approximation and basics.\"\"\"
    
    TOPIC = "Travelling Salesman Problem"

    @staticmethod
    def describe() -> str:
        return (
            "TSP: shortest tour/path visiting all nodes once. "
            "Greedy nearest neighbor: from current, pick closest unvisited. O(n^2)"
        )

    @staticmethod
    def checklist() -> List[str]:
        return [
            "Model as dist[][] matrix (n x n)",
            "Handle INF disconnected",
            "Start from node 0, track visited set",
            "Close tour: return to start",
            "Approx ratio: greedy ≤ 2*OPT typically",
        ]

    @staticmethod
    def nearest_neighbor(dist: List[List[float]]) -> Tuple[List[int], float]:
        """
        Greedy TSP approximation.
        dist[i][j]: distance/cost from i to j (symmetric assumed).
        Returns (tour_path, total_cost). Raises if disconnected.
        
        Example: square cities [[0,10,15,20],[10,0,35,25],[15,35,0,30],[20,25,30,0]]
        """
        n = len(dist)
        if n == 0:
            return [], 0.0
        
        visited = [False] * n
        tour = [0]
        visited[0] = True
        total_cost = 0.0
        
        current = 0
        for _ in range(n - 1):
            next_city = -1
            min_dist = INF
            
            for city in range(n):
                if not visited[city] and dist[current][city] < min_dist:
                    min_dist = dist[current][city]
                    next_city = city
            
            if next_city == -1 or min_dist == INF:
                raise ValueError("Graph disconnected; no TSP tour")
            
            tour.append(next_city)
            visited[next_city] = True
            total_cost += min_dist
            current = next_city
        
        # Close tour
        close_dist = dist[current][0]
        if close_dist == INF:
            raise ValueError("Cannot return to start")
        total_cost += close_dist
        
        return tour, total_cost

    @staticmethod
    def has_hamiltonian_path(dist: List[List[float]]) -> bool:
        """
        Simple greedy check if Hamiltonian path exists (not exact!).
        """
        try:
            path, _ = TravellingSalesmanBasics.nearest_neighbor(dist)
            return len(path) == len(dist)
        except ValueError:
            return False


def main() -> None:
    print(TravellingSalesmanBasics.describe())
    print("\\nChecklist:")
    for item in TravellingSalesmanBasics.checklist():
        print(" -", item)

    # Example: 4 cities square-ish distances
    dist_matrix = [
        [0, 10, 15, 20],
        [10, 0, 35, 25],
        [15, 35, 0, 30],
        [20, 25, 30, 0]
    ]
    
    tour, cost = TravellingSalesmanBasics.nearest_neighbor(dist_matrix)
    print(f"\\nExample TSP (nearest neighbor):")
    print(f"Tour: {tour + [tour[0]]} (cost: {cost:.1f})")
    
    print(f"Has Hamiltonian path: {TravellingSalesmanBasics.has_hamiltonian_path(dist_matrix)}")


if __name__ == &#x27;__main__&#x27;:
    main()

