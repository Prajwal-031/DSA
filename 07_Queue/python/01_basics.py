"""
Queue - Interview prep (Python)
================================
Real queue functionality and problem patterns.
"""

from __future__ import annotations

from collections import deque


class SimpleQueue:
    """Basic queue implementation backed by deque."""

    def __init__(self) -> None:
        self._dq: deque[int] = deque()

    def enqueue(self, x: int) -> None:
        self._dq.append(x)

    def dequeue(self) -> int | None:
        return self._dq.popleft() if self._dq else None

    def peek(self) -> int | None:
        return self._dq[0] if self._dq else None

    def is_empty(self) -> bool:
        return not self._dq

    def __len__(self) -> int:
        return len(self._dq)


def sliding_window_maximum(nums: list[int], k: int) -> list[int]:
    if k <= 0 or not nums:
        return []
    dq: deque[int] = deque()
    out: list[int] = []

    for i, n in enumerate(nums):
        while dq and dq[0] < i - k + 1:
            dq.popleft()
        while dq and nums[dq[-1]] < n:
            dq.pop()
        dq.append(i)
        if i >= k - 1:
            out.append(nums[dq[0]])
    return out


def main() -> None:
    q = SimpleQueue()
    q.enqueue(10)
    q.enqueue(20)
    q.enqueue(30)
    print("Queue operations:", [q.dequeue(), q.peek(), len(q)])

    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    print("Sliding window max:", sliding_window_maximum(nums, k))


if __name__ == "__main__":
    main()