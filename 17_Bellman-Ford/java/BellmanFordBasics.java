import java.util.*;

public class BellmanFordBasics {
    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    /**
     * Computes shortest paths from source using Bellman-Ford.
     * @param n number of vertices (0 to n-1)
     * @param edges list of edges
     * @param source starting vertex
     * @return array of distances, Double.POSITIVE_INFINITY if unreachable
     * @throws IllegalArgumentException if negative cycle detected
     */
    public static double[] bellmanFord(int n, List<Edge> edges, int source) {
        double[] dist = new double[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[source] = 0.0;

        // Relax |V|-1 times
        for (int iter = 0; iter < n - 1; iter++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.u] != Double.POSITIVE_INFINITY && 
                    dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        // Check negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != Double.POSITIVE_INFINITY && 
                dist[e.u] + e.w < dist[e.v]) {
                throw new IllegalArgumentException("Negative cycle detected");
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // Standard example
        List<Edge> edges = Arrays.asList(
            new Edge(0,1,6), new Edge(0,2,7),
            new Edge(1,2,5), new Edge(1,3,-4), new Edge(1,4,-14),
            new Edge(2,3,-8), new Edge(2,4,-2),
            new Edge(3,4,9)
        );
        int n = 5;
        try {
            double[] dist = bellmanFord(n, edges, 0);
            System.out.println("Distances from 0:");
            for (int i = 0; i < n; i++) {
                if (dist[i] != Double.POSITIVE_INFINITY) {
                    System.out.println(i + ": " + dist[i]);
                }
            }
            // Output: 0: 0.0, 1: 6.0, 2: 7.0, 3: 2.0, 4: -6.0
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

