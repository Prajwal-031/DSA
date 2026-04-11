import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import HeapsBasics.*;


public class HeapsBasicsTest {
    
    @Test
    public void testMinHeapOperations() {
        HeapsBasics.MinHeap<Integer> h = new HeapsBasics.MinHeap<>();
        h.push(3);
        h.push(1);
        h.push(4);
        assertEquals(Integer.valueOf(1), h.peek());
        assertEquals(Integer.valueOf(1), h.pop());
        assertEquals(2, h.size());
        assertEquals(Integer.valueOf(3), h.pop());
        assertEquals(Integer.valueOf(4), h.pop());
        h.push(2);
        assertEquals(Integer.valueOf(2), h.pop());
    }
    
    @Test
    public void testMaxHeapOperations() {
        HeapsBasics.MaxHeap<Integer> h = new HeapsBasics.MaxHeap<>();
        h.push(3);
        h.push(1);
        h.push(4);
        assertEquals(Integer.valueOf(4), h.peek());
        assertEquals(Integer.valueOf(4), h.pop());
        assertEquals(2, h.size());
        assertEquals(Integer.valueOf(3), h.pop());
        assertEquals(Integer.valueOf(1), h.pop());
    }
    
    @Test
    public void testEmptyHeap() {
        HeapsBasics.MinHeap<Integer> h = new HeapsBasics.MinHeap<>();
        assertNull(h.peek());
        assertEquals(0, h.size());
    }
}

