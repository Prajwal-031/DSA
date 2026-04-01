"""
Stack - Basic operations in Python
==================================
Uses a list as a stack (LIFO): append = push, pop = pop.
collections.deque is also fine for O(1) ends; list is standard for interviews.
"""

from typing import Any, List


class Stack:
    """Minimal stack API: push, pop, peek, is_empty, size."""

    def __init__(self) -> None:
        self._data: List[Any] = []

    def push(self, x: Any) -> None:
        self._data.append(x)

    def pop(self) -> Any:
        if self.is_empty():
            raise IndexError("pop from empty stack")
        return self._data.pop()

    def peek(self) -> Any:
        if self.is_empty():
            raise IndexError("peek from empty stack")
        return self._data[-1]

    def is_empty(self) -> bool:
        return len(self._data) == 0

    def size(self) -> int:
        return len(self._data)

    def __repr__(self) -> str:
        return f"Stack({self._data})"


def is_valid_parentheses(s: str) -> bool:
    """LeetCode-style: valid if every bracket closes in LIFO order."""
    pairs = {")": "(", "]": "[", "}": "{"}
    st: List[str] = []
    for ch in s:
        if ch in "([{":
            st.append(ch)
        elif ch in pairs:
            if not st or st.pop() != pairs[ch]:
                return False
        else:
            return False
    return len(st) == 0


if __name__ == "__main__":
    st = Stack()
    for x in (1, 2, 3):
        st.push(x)
    print("Stack after pushes:", st)
    print("peek:", st.peek())
    while not st.is_empty():
        print("pop:", st.pop())
    print("empty?", st.is_empty())

    print("() valid?", is_valid_parentheses("()[]{}"))
    print("(] valid?", is_valid_parentheses("(]"))
