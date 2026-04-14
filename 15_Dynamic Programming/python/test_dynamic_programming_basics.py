import importlib.util
import pathlib

""" 
Dynamic Programming - Interview prep (Python)
Reference implementations for common DP interview patterns.
"""

spec = importlib.util.spec_from_file_location(
    "dynamic_programming_basics", pathlib.Path(__file__).parent / "01_basics.py"
)
dp_module = importlib.util.module_from_spec(spec)
assert spec and spec.loader
spec.loader.exec_module(dp_module)

fibonacci = dp_module.fibonacci
climb_stairs = dp_module.climb_stairs
house_robber = dp_module.house_robber
coin_change = dp_module.coin_change
word_break = dp_module.word_break


def test_fibonacci_values():
    assert fibonacci(0) == 0
    assert fibonacci(1) == 1
    assert fibonacci(7) == 13


def test_climb_stairs_values():
    assert climb_stairs(1) == 1
    assert climb_stairs(2) == 2
    assert climb_stairs(5) == 8


def test_house_robber_examples():
    assert house_robber([1, 2, 3, 1]) == 4
    assert house_robber([2, 7, 9, 3, 1]) == 12
    assert house_robber([]) == 0


def test_coin_change_examples():
    assert coin_change([1, 2, 5], 11) == 3
    assert coin_change([2], 3) == -1
    assert coin_change([1], 0) == 0


def test_coin_change_unreachable():
    assert coin_change([4, 6], 5) == -1


def test_word_break():
    assert word_break("leetcode", ["leet", "code"]) is True
    assert word_break("applepenapple", ["apple", "pen"]) is True
    assert word_break("catsandog", ["cats", "dog", "sand", "and", "cat"]) is False
