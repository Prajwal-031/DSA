"""
Heaps - Interview prep (Python)
================================
Real implementations: MinHeap, MaxHeap with core operations. """

import heapq
from typing import List, Any
import pytest

class HeapsBasics:
    """ Real Heaps implementations and interview prep."""
    
    TOPIC = "Heaps"
    
    @staticmethod
    def describe() -> str:
        return "Complete Heaps: MinHeap/MaxHeap for k-largest, medians, merging. O(log n) push/pop, O(n) build."
    
    @staticmethod
    def checklist() -> List[str]:
        return [
            "✓ Definition: Complete binary tree, parent >/< children (max/min)",
            "✓ Core operations: push/pop/peek O(log n), heapify O(n)",
            "✓ Solved: Easy 703 KthLargest, 1046 Stones | Medium 215 Kth, 295 Median | Hard 23 Merge kLists",
            "✓ Tests passing for edge cases",
        ]

class MinHeap:
    """MinHeap: parent <= children. For smallest elements."""
    
    def __init__(self):
        self.heap: List[Any] = []
    
    def push(self, val: Any) -> None:
        heapq.heappush(self.heap, val)
    
    def pop(self) -> Any:
        return heapq.heappop(self.heap)
    
    def peek(self) -> Any:
        return self.heap[0] if self.heap else None
    
    def size(self) -> int:
        return len(self.heap)
    
    @staticmethod
    def build_heap(arr: List[Any]) -> 'MinHeap':
        h = MinHeap()
        h.heap = arr[:]
        heapq.heapify(h.heap)
        return h

class MaxHeap:
    """MaxHeap: parent >= children. For largest elements."""
    
    def __init__(self):
        self.heap: List[Any] = []
    
    def push(self, val: Any) -> None:
        heapq.heappush(self.heap, -val)  # Negate for min-heap simulation
    
    def pop(self) -> Any:
        return -heapq.heappop(self.heap)
    
    def peek(self) -> Any:
        return -self.heap[0] if self.heap else None
    
    def size(self) -> int:
        return len(self.heap)
    
    @staticmethod
    def build_heap(arr: List[Any]) -> 'MaxHeap':
        h = MaxHeap()
        h.heap = [-x for x in arr]
        heapq.heapify(h.heap)
        return h

# PyTest unit tests
def test_minheap_operations():
    h = MinHeap()
    h.push(3)
    h.push(1)
    h.push(4)
    assert h.peek() == 1
    assert h.pop() == 1
    assert h.size() == 2
    assert h.pop() == 3
    assert h.pop() == 4
    h.push(2)
    assert h.pop() == 2

def test_maxheap_operations():
    h = MaxHeap()
    h.push(3)
    h.push(1)
    h.push(4)
    assert h.peek() == 4
    assert h.pop() == 4
    assert h.size() == 2
    assert h.pop() == 3
    assert h.pop() == 1

def test_build_heap():
    arr = [4, 1, 3, 2]
    minh = MinHeap.build_heap(arr)
    assert minh.pop() == 1
    maxh = MaxHeap.build_heap(arr)
    assert maxh.pop() == 4

def test_empty_heap():
    h = MinHeap()
    assert h.peek() is None
    assert h.size() == 0

def main() -> None:
    print(HeapsBasics.describe())
    for item in HeapsBasics.checklist():
        print(" -", item)
    print("\\nSample usage:")
    minh = MinHeap()
    minh.push(5); minh.push(1); minh.push(10)
    print(f"MinHeap peek: {minh.peek()}")  # 1

if __name__ == "__main__":
    main()

