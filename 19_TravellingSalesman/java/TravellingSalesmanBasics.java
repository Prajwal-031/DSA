import java.util.Arrays;

/**
 * Travelling Salesman Problem - Interview prep (Java)
 * Greedy nearest neighbor: O(n^2) approx.
 */
public class TravellingSalesmanBasics {

    private static final double INF = 1e9;
    private static final String TOPIC = "Travelling Salesman Problem";

    public static String describe() {
        return "TSP: shortest tour visiting all cities once. Greedy nearest neighbor approx O(n^2).";
    }

    public static String[] checklist() {
        return new String[] {
            "Model dist[][] nxn matrix",
            "Handle INF disconnected",
            "Start node 0, visited[]",
            "Pick min dist unvisited",
            "Close: +dist[last][0]"
        };
    }

    /**
     * Greedy nearest neighbor TSP.
     * dist[i][j] from i to j.
     * Returns {tour path ints, total cost}.
     * Throws if disconnected.
     */
    public static double[] nearestNeighbor(double[][] dist) {
        int n = dist.length;
        if (n == 0) return new double[]{};
        
        boolean[] visited = new boolean[n];
        int[] tour = new int[n];
        tour[0] = 0;
        visited[0] = true;
        double totalCost = 0.0;
        int current = 0;
        
        for (int step = 1; step < n; step++) {
            int nextCity = -1;
            double minDist = INF;
            
            for (int city = 0; city < n; city++) {
                if (!visited[city] &amp;&amp; dist[current][city] < minDist) {
                    minDist = dist[current][city];
                    nextCity = city;
                }
            }
            
            if (nextCity == -1 || minDist == INF) {
                throw new IllegalArgumentException("Disconnected graph");
            }
            
            tour[step] = nextCity;
            visited[nextCity] = true;
            totalCost += minDist;
            current = nextCity;
        }
        
        // Close tour
        double closeDist = dist[current][0];
        if (closeDist == INF) {
            throw new IllegalArgumentException("Cannot close tour");
        }
        totalCost += closeDist;
        
        double[] result = new double[n + 1];
        for (int i = 0; i < n; i++) {
            result[i] = tour[i];
        }
        result[n] = totalCost;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(TOPIC);
        System.out.println(describe());
        System.out.println("\\nChecklist:");
        for (String item : checklist()) {
            System.out.println(" - " + item);
        }

        // Example 4 cities
        double[][] dist = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        
        try {
            double[] result = nearestNeighbor(dist);
            System.out.println("\\nTSP Example:");
            System.out.print("Tour: [");
            for (int i = 0; i < result.length - 1; i++) {
                System.out.print((int)result[i]);
                if (i < result.length - 2) System.out.print(", ");
            }
            System.out.println("] cost: " + String.format("%.1f", result[result.length - 1]));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
