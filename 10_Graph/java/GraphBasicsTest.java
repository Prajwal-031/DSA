public class GraphBasicsTest {

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + " - expected: " + expected + ", got: " + actual);
        }
    }

    public static void testGraphDFS() {
        GraphBasics.Graph g = new GraphBasics.Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        java.util.Set<Integer> visited = new java.util.HashSet<>();
        GraphBasics.dfs(0, g, visited);
        assertEquals(4, visited.size(), "DFS should visit all 4 nodes");
    }

    public static void testGraphBFS() {
        GraphBasics.Graph g = new GraphBasics.Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);

        java.util.Set<Integer> visited = new java.util.HashSet<>();
        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        q.add(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : g.adj.getOrDefault(node, new java.util.ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        assertEquals(3, visited.size(), "BFS should visit all 3 nodes");
    }

    public static void testNumberOfIslands() {
        char[][] grid = {
            {'1', '1', '0', '0'},
            {'1', '0', '0', '1'},
            {'0', '0', '1', '1'}
        };
        assertEquals(3, GraphBasics.numIslands(grid), "Should find 3 islands");
    }

    public static void testNumberOfIslandsNoIslands() {
        char[][] grid = {
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assertEquals(0, GraphBasics.numIslands(grid), "Should find 0 islands");
    }

    public static void main(String[] args) {
        testGraphDFS();
        testGraphBFS();
        testNumberOfIslands();
        testNumberOfIslandsNoIslands();
        System.out.println("GraphBasicsTest passed");
    }
}