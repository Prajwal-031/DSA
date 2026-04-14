"""
Dynamic Programming - Interview prep (Python)
Reference implementations for common DP interview patterns.

"""

from __future__ import annotations


class DynamicProgrammingBasics:
    """Small DP guide plus sample implementations."""

    TOPIC = "Dynamic Programming"

    @staticmethod
    def describe() -> str:
        return (
            "Dynamic Programming stores overlapping subproblems to optimize "
            "counting, decision, and min/max problems."
        )

    @staticmethod
    def checklist() -> list[str]:
        return [
            "Define the state before coding",
            "Write the recurrence relation",
            "Handle base cases and impossible states",
            "Check whether the table can be space-optimized",
        ]


def fibonacci(n: int) -> int:
    """Return the nth Fibonacci number using O(1) space."""
    if n < 0:
        raise ValueError("n must be non-negative")
    if n < 2:
        return n

    prev2, prev1 = 0, 1
    for _ in range(2, n + 1):
        prev2, prev1 = prev1, prev1 + prev2
    return prev1

def climb_stairs(n: int) -> int:
    """LeetCode 70: number of ways to reach step n."""
    if n <= 0:
        return 0
    if n <= 2:
        return n

    one_step_before, two_steps_before = 2, 1
    for _ in range(3, n + 1):
        one_step_before, two_steps_before = one_step_before + two_steps_before, one_step_before
    return one_step_before


def house_robber(nums: list[int]) -> int:
    """LeetCode 198: choose non-adjacent houses for maximum profit."""
    rob_prev, skip_prev = 0, 0
    for value in nums:
        rob_prev, skip_prev = skip_prev + value, max(skip_prev, rob_prev)
    return max(rob_prev, skip_prev)


def coin_change(coins: list[int], amount: int) -> int:
    """LeetCode 322: minimum coins needed, or -1 if impossible."""
    if amount < 0:
        return -1

    dp = [amount + 1] * (amount + 1)
    dp[0] = 0

    for target in range(1, amount + 1):
        for coin in coins:
            if coin <= target:
                dp[target] = min(dp[target], dp[target - coin] + 1)

    return dp[amount] if dp[amount] <= amount else -1


def word_break(s: str, word_dict: list[str]) -> bool:
    """LeetCode 139: whether the string can be segmented."""
    words = set(word_dict)
    dp = [False] * (len(s) + 1)
    dp[0] = True

    for end in range(1, len(s) + 1):
        for start in range(end):
            if dp[start] and s[start:end] in words:
                dp[end] = True
                break

    return dp[-1]


def main() -> None:
    print(DynamicProgrammingBasics.describe())
    for item in DynamicProgrammingBasics.checklist():
        print(" -", item)

    print("\nSample results:")
    print(" fibonacci(8) =", fibonacci(8))
    print(" climb_stairs(5) =", climb_stairs(5))
    print(" house_robber([2, 7, 9, 3, 1]) =", house_robber([2, 7, 9, 3, 1]))
    print(" coin_change([1, 2, 5], 11) =", coin_change([1, 2, 5], 11))
    print(
        " word_break('leetcode', ['leet', 'code']) =",
        word_break("leetcode", ["leet", "code"]),
    )


if __name__ == "__main__":
    main()
