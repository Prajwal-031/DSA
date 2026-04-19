import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import BellmanFordBasics.*;

public class BellmanFordBasicsTest {
    
    List<BellmanFordBasics.Edge> edges;
    int n = 5;
    
    @BeforeEach
    void setUp() {
        edges = Arrays.asList(
            new BellmanFordBasics.Edge(0,1,6), new BellmanFordBasics.Edge(0,2,7),
            new BellmanFordBasics.Edge(1,2,5), new BellmanFordBasics.Edge(1,3,-4), new BellmanFordBasics.Edge(1,4,-14),
            new BellmanFordBasics.Edge(2,3,-8), new BellmanFordBasics.Edge(2,4,-2),
            new BellmanFordBasics.Edge(3,4,9)
        );
    }

    @Test
    void testStandardGraph() {
        double[] dist = BellmanFordBasics.bellmanFord(n, edges, 0);
        assertEquals(0.0, dist[0]);
        assertEquals(6.0, dist[1]);
        assertEquals(7.0, dist[2]);
        assertEquals(2.0, dist[3]);
        assertEquals(-6.0, dist[4]);
    }

    @Test
    void testNegativeCycle() {
        List<BellmanFordBasics.Edge> negEdges = Arrays.asList(
            new BellmanFordBasics.Edge(0,1,-1),
            new BellmanFordBasics.Edge(1,0,-1)
        );
        assertThrows(IllegalArgumentException.class, () -> {
            BellmanFordBasics.bellmanFord(2, negEdges, 0);
        });
    }

    @Test
    void testUnreachable() {
        List<BellmanFordBasics.Edge> edgesUn = Arrays.asList(new BellmanFordBasics.Edge(0,1,5));
        double[] dist = BellmanFordBasics.bellmanFord(3, edgesUn, 0);
        assertEquals(Double.POSITIVE_INFINITY, dist[2]);
    }

    @Test
    void testSingleNode() {
        double[] dist = BellmanFordBasics.bellmanFord(1, new ArrayList<>(), 0);
        assertEquals(0.0, dist[0]);
    }
}

