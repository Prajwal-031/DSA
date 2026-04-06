/**
 * Graph - Interview prep (Java)
 * =============================
 * Real graph examples and algorithm patterns.
 */
import java.util.*;

public class GraphBasics {

    private static final String TOPIC = "Graph";

    public static String describe() {
        return "Topic: " + TOPIC + ". Includes adjacency list, DFS, BFS, and example problems.";
    }

    public static String[] checklist() {
        return new String[] {
            "Definition and when to use Graph",
            "Core operations and complexities",
            "Two easy + two medium problems solved",
            "One hard attempted with analysis"
        };
    }

    public static void main(String[] args) {
        System.out.println(describe());
        for (String item : checklist()) {
            System.out.println(" - " + item);
        }

        demoDFS();
        demoBFS();
        demoNumberOfIslands();
    }

    // Adjacency list graph representation
    static class Graph {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        void addEdge(int u, int v) {
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    private static void demoDFS() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.print("DFS from 0: ");
        Set<Integer> visited = new HashSet<>();
        dfs(0, g, visited);
        System.out.println();
    }

    static void dfs(int node, Graph g, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : g.adj.getOrDefault(node, new ArrayList<>())) {
            dfs(neighbor, g, visited);
        }
    }

    private static void demoBFS() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.print("BFS from 0: ");
        bfs(0, g);
    }

    static void bfs(int start, Graph g) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int neighbor : g.adj.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Number of Islands - LeetCode #200
    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfsIsland(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    static void dfsIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfsIsland(grid, i + 1, j);
        dfsIsland(grid, i - 1, j);
        dfsIsland(grid, i, j + 1);
        dfsIsland(grid, i, j - 1);
    }

    private static void demoNumberOfIslands() {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands(grid));
    }
}
