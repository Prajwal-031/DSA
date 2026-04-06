"""
Graph - Interview prep (Python)
================================
Real graph functionality and problem patterns.
"""

from __future__ import annotations

from collections import defaultdict, deque


class Graph:
    def __init__(self) -> None:
        self.adj: dict[int, list[int]] = defaultdict(list)

    def add_edge(self, u: int, v: int) -> None:
        self.adj[u].append(v)
        self.adj[v].append(u)

    def dfs(self, node: int, visited: set[int] | None = None) -> list[int]:
        if visited is None:
            visited = set()
        result = []
        if node in visited:
            return result
        visited.add(node)
        result.append(node)
        for neighbor in self.adj[node]:
            result.extend(self.dfs(neighbor, visited))
        return result

    def bfs(self, start: int) -> list[int]:
        visited = {start}
        q = deque([start])
        result = []
        while q:
            node = q.popleft()
            result.append(node)
            for neighbor in self.adj[node]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    q.append(neighbor)
        return result


def num_islands(grid: list[list[str]]) -> int:
    islands = 0
    for i in range(len(grid)):
        for j in range(len(grid[i])):
            if grid[i][j] == '1':
                dfs_island(grid, i, j)
                islands += 1
    return islands


def dfs_island(grid: list[list[str]], i: int, j: int) -> None:
    if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[i]) or grid[i][j] == '0':
        return
    grid[i][j] = '0'
    dfs_island(grid, i + 1, j)
    dfs_island(grid, i - 1, j)
    dfs_island(grid, i, j + 1)
    dfs_island(grid, i, j - 1)


def main() -> None:
    g = Graph()
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(1, 2)
    g.add_edge(2, 3)
    print("DFS from 0:", g.dfs(0))
    print("BFS from 0:", g.bfs(0))

    grid = [['1', '1', '0', '0'], ['1', '0', '0', '1'], ['0', '0', '1', '1']]
    print("Number of islands:", num_islands(grid))


if __name__ == "__main__":
    main()