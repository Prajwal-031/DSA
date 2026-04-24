"""
Backtracking - Interview prep (Python)
Reference implementations for common backtracking interview patterns.
"""

from __future__ import annotations
from typing import List, Set


class BacktrackingBasics:
    """Small backtracking guide plus sample implementations."""

    TOPIC = "Backtracking"

    @staticmethod
    def describe() -> str:
        return (
            "Backtracking systematically explores all candidates by building "
            "solutions incrementally and abandoning partial candidates that "
            "cannot be completed to a valid solution."
        )

    @staticmethod
    def checklist() -> list[str]:
        return [
            "Define state: current path, indices used, constraints",
            "Write the base case: when to add to results",
            "Write the recursive step: loop over valid choices",
            "Add pruning to skip impossible branches early",
            "Backtrack: undo the choice before returning",
        ]


def subsets(nums: list[int]) -> list[list[int]]:
    """LeetCode 78: all subsets of nums."""
    result: list[list[int]] = []

    def backtrack(start: int, current: list[int]) -> None:
        result.append(list(current))
        for i in range(start, len(nums)):
            current.append(nums[i])
            backtrack(i + 1, current)
            current.pop()

    backtrack(0, [])
    return result


def permutations(nums: list[int]) -> list[list[int]]:
    """LeetCode 46: all permutations of nums."""
    result: list[list[int]] = []

    def backtrack(current: list[int], used: set[int]) -> None:
        if len(current) == len(nums):
            result.append(list(current))
            return
        for i in range(len(nums)):
            if i in used:
                continue
            used.add(i)
            current.append(nums[i])
            backtrack(current, used)
            current.pop()
            used.remove(i)

    backtrack([], set())
    return result


def combination_sum(candidates: list[int], target: int) -> list[list[int]]:
    """LeetCode 39: combinations that sum to target, reuse allowed."""
    result: list[list[int]] = []

    def backtrack(start: int, current: list[int], remaining: int) -> None:
        if remaining == 0:
            result.append(list(current))
            return
        if remaining < 0:
            return
        for i in range(start, len(candidates)):
            current.append(candidates[i])
            backtrack(i, current, remaining - candidates[i])
            current.pop()

    backtrack(0, [], target)
    return result


def generate_parentheses(n: int) -> list[str]:
    """LeetCode 22: all valid combinations of n pairs of parentheses."""
    result: list[str] = []

    def backtrack(current: list[str], open_count: int, close_count: int) -> None:
        if len(current) == 2 * n:
            result.append("".join(current))
            return
        if open_count < n:
            current.append("(")
            backtrack(current, open_count + 1, close_count)
            current.pop()
        if close_count < open_count:
            current.append(")")
            backtrack(current, open_count, close_count + 1)
            current.pop()

    backtrack([], 0, 0)
    return result


def n_queens(n: int) -> list[list[str]]:
    """LeetCode 51: all distinct solutions to the n-queens puzzle."""
    result: list[list[str]] = []
    board = [["." for _ in range(n)] for _ in range(n)]

    def is_safe(row: int, col: int) -> bool:
        # Check column
        for i in range(row):
            if board[i][col] == "Q":
                return False
        # Check upper-left diagonal
        i, j = row - 1, col - 1
        while i >= 0 and j >= 0:
            if board[i][j] == "Q":
                return False
            i -= 1
            j -= 1
        # Check upper-right diagonal
        i, j = row - 1, col + 1
        while i >= 0 and j < n:
            if board[i][j] == "Q":
                return False
            i -= 1
            j += 1
        return True

    def backtrack(row: int) -> None:
        if row == n:
            result.append(["".join(r) for r in board])
            return
        for col in range(n):
            if is_safe(row, col):
                board[row][col] = "Q"
                backtrack(row + 1)
                board[row][col] = "."

    backtrack(0)
    return result


def main() -> None:
    print(BacktrackingBasics.describe())
    for item in BacktrackingBasics.checklist():
        print(" -", item)

    print("\nSample results:")
    print(" subsets([1, 2, 3]) =", subsets([1, 2, 3]))
    print(" permutations([1, 2, 3]) =", permutations([1, 2, 3]))
    print(" combination_sum([2, 3, 6, 7], 7) =", combination_sum([2, 3, 6, 7], 7))
    print(" generate_parentheses(3) =", generate_parentheses(3))
    print(" n_queens(4) solutions =", len(n_queens(4)))


if __name__ == "__main__":
    main()
