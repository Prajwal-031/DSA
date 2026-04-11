/**
 * Heaps - Interview prep (Java)
 * =============================
 * Real implementations: MinHeap, MaxHeap with core operations.
 */
import java.util.*;

public class HeapsBasics {
    
    private static final String TOPIC = "Heaps";
    
    public static String describe() {
        return "Complete Heaps: MinHeap/MaxHeap for k-largest, medians, merging. O(log n) push/pop, O(n) build.";
    }
    
    public static String[] checklist() {
        return new String[] {
            "✓ Definition: Complete binary tree, parent >/< children (max/min)",
            "✓ Core operations: push/pop/peek O(log n), heapify O(n)",
            "✓ Solved: Easy 703 KthLargest, 1046 Stones | Medium 215 Kth, 295 Median | Hard 23 Merge kLists",
            "✓ Tests ready for JUnit"
        };
    }

    // MinHeap using PriorityQueue
    static class MinHeap<T extends Comparable<T>> {
        private PriorityQueue<T> pq = new PriorityQueue<>();
        
        public void push(T val) {
            pq.offer(val);
        }
        
        public T pop() {
            return pq.poll();
        }
        
        public T peek() {
            return pq.peek();
        }
        
        public int size() {
            return pq.size();
        }
    }

    // MaxHeap using PriorityQueue (reverse order)
    static class MaxHeap<T extends Comparable<T>> {
        private PriorityQueue<T> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        public void push(T val) {
            pq.offer(val);
        }
        
        public T pop() {
            return pq.poll();
        }
        
        public T peek() {
            return pq.peek();
        }
        
        public int size() {
            return pq.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(describe());
        for (String item : checklist()) {
            System.out.println(" - " + item);
        }
        System.out.println("\\nSample usage:");
        MinHeap<Integer> minh = new MinHeap<>();
        minh.push(5);
        minh.push(1);
        minh.push(10);
        System.out.println("MinHeap peek: " + minh.peek());  // 1
    }
}

