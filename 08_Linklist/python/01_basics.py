"""
Linklist - Interview prep (Python)
================================
Real linked list functionality and problem patterns.
"""

from __future__ import annotations


class ListNode:
    def __init__(self, val: int = 0, next: ListNode | None = None) -> None:
        self.val = val
        self.next = next


def reverse_list(head: ListNode | None) -> ListNode | None:
    prev = None
    curr = head
    while curr:
        next_temp = curr.next
        curr.next = prev
        prev = curr
        curr = next_temp
    return prev


def print_list(head: ListNode | None) -> None:
    curr = head
    while curr:
        print(curr.val, end=" -> ")
        curr = curr.next
    print("None")


def main() -> None:
    # Demo operations
    head = ListNode(1, ListNode(2, ListNode(3)))
    print("Original list:")
    print_list(head)

    # Reverse
    reversed_head = reverse_list(head)
    print("Reversed list:")
    print_list(reversed_head)


if __name__ == "__main__":
    main()
