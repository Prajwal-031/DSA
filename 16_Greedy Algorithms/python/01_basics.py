"""
Greedy Algorithms - Interview prep (Python)
==========================================

Greedy solutions make the locally best safe choice at each step. The trick is
not the code; it is proving that the local choice cannot hurt the final answer.
"""

from __future__ import annotations


class GreedyAlgorithmsBasics:
    """Common greedy interview patterns and reference implementations."""

    TOPIC = "Greedy Algorithms"

    @staticmethod
    def describe() -> str:
        return (
            "Greedy algorithms build an answer one safe local choice at a time. "
            "Use them when a local optimum can be proven to produce a global optimum."
        )

    @staticmethod
    def checklist() -> list[str]:
        return [
            "Identify the local greedy choice",
            "Choose a useful ordering, often by sorting",
            "Prove the greedy choice with an exchange argument or invariant",
            "Test small counterexamples before coding",
            "Compare against DP when the local choice is not safe",
        ]

    @staticmethod
    def max_profit_unlimited_transactions(prices: list[int]) -> int:
        """
        LeetCode 122: Best Time to Buy and Sell Stock II.

        Every positive day-to-day increase can be captured as profit.
        Time: O(n), Space: O(1)
        """
        profit = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                profit += prices[i] - prices[i - 1]
        return profit

    @staticmethod
    def assign_cookies(greed: list[int], cookies: list[int]) -> int:
        """
        LeetCode 455: Assign Cookies.

        Give each child the smallest cookie that satisfies them.
        Time: O(n log n + m log m), Space: O(1) excluding sort internals
        """
        greed.sort()
        cookies.sort()

        child = 0
        cookie = 0
        satisfied = 0

        while child < len(greed) and cookie < len(cookies):
            if cookies[cookie] >= greed[child]:
                satisfied += 1
                child += 1
            cookie += 1

        return satisfied

    @staticmethod
    def can_jump(nums: list[int]) -> bool:
        """
        LeetCode 55: Jump Game.

        Track the farthest index reachable so far.
        Time: O(n), Space: O(1)
        """
        farthest = 0
        for index, jump in enumerate(nums):
            if index > farthest:
                return False
            farthest = max(farthest, index + jump)
        return True

    @staticmethod
    def minimum_jumps(nums: list[int]) -> int:
        """
        LeetCode 45: Jump Game II.

        Each jump covers the current range; while scanning it, compute the next range.
        Time: O(n), Space: O(1)
        """
        if len(nums) <= 1:
            return 0

        jumps = 0
        current_end = 0
        farthest = 0

        for index in range(len(nums) - 1):
            farthest = max(farthest, index + nums[index])
            if index == current_end:
                jumps += 1
                current_end = farthest

        return jumps

    @staticmethod
    def erase_overlap_intervals(intervals: list[list[int]]) -> int:
        """
        LeetCode 435: Non-overlapping Intervals.

        Keep the interval that ends earliest because it leaves maximum room later.
        Time: O(n log n), Space: O(1) excluding sort internals
        """
        if not intervals:
            return 0

        intervals.sort(key=lambda interval: interval[1])
        removals = 0
        last_end = intervals[0][1]

        for start, end in intervals[1:]:
            if start < last_end:
                removals += 1
            else:
                last_end = end

        return removals

    @staticmethod
    def partition_labels(text: str) -> list[int]:
        """
        LeetCode 763: Partition Labels.

        A partition closes when the scan reaches the farthest last occurrence of
        every character seen in that partition.
        Time: O(n), Space: O(1) because the alphabet is bounded for lowercase input
        """
        last_position = {char: index for index, char in enumerate(text)}
        result: list[int] = []
        start = 0
        end = 0

        for index, char in enumerate(text):
            end = max(end, last_position[char])
            if index == end:
                result.append(end - start + 1)
                start = index + 1

        return result


def main() -> None:
    print(GreedyAlgorithmsBasics.describe())
    print("Checklist:")
    for item in GreedyAlgorithmsBasics.checklist():
        print(" -", item)

    print("\nExamples:")
    print(
        "Stock II:",
        GreedyAlgorithmsBasics.max_profit_unlimited_transactions([7, 1, 5, 3, 6, 4]),
    )
    print("Assign Cookies:", GreedyAlgorithmsBasics.assign_cookies([1, 2, 3], [1, 1]))
    print("Can Jump:", GreedyAlgorithmsBasics.can_jump([2, 3, 1, 1, 4]))
    print("Minimum Jumps:", GreedyAlgorithmsBasics.minimum_jumps([2, 3, 1, 1, 4]))
    print(
        "Erase Overlaps:",
        GreedyAlgorithmsBasics.erase_overlap_intervals([[1, 2], [2, 3], [3, 4], [1, 3]]),
    )
    print("Partition Labels:", GreedyAlgorithmsBasics.partition_labels("ababcbacadefegdehijhklij"))


if __name__ == "__main__":
    main()
