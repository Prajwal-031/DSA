from __future__ import annotations

import importlib.util
from pathlib import Path


MODULE_PATH = Path(__file__).with_name("01_basics.py")
SPEC = importlib.util.spec_from_file_location("greedy_basics", MODULE_PATH)
assert SPEC is not None and SPEC.loader is not None
greedy_basics = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(greedy_basics)
GreedyAlgorithmsBasics = greedy_basics.GreedyAlgorithmsBasics


def test_max_profit_unlimited_transactions() -> None:
    assert GreedyAlgorithmsBasics.max_profit_unlimited_transactions([7, 1, 5, 3, 6, 4]) == 7
    assert GreedyAlgorithmsBasics.max_profit_unlimited_transactions([1, 2, 3, 4, 5]) == 4
    assert GreedyAlgorithmsBasics.max_profit_unlimited_transactions([7, 6, 4, 3, 1]) == 0


def test_assign_cookies() -> None:
    assert GreedyAlgorithmsBasics.assign_cookies([1, 2, 3], [1, 1]) == 1
    assert GreedyAlgorithmsBasics.assign_cookies([1, 2], [1, 2, 3]) == 2


def test_can_jump() -> None:
    assert GreedyAlgorithmsBasics.can_jump([2, 3, 1, 1, 4]) is True
    assert GreedyAlgorithmsBasics.can_jump([3, 2, 1, 0, 4]) is False
    assert GreedyAlgorithmsBasics.can_jump([0]) is True


def test_minimum_jumps() -> None:
    assert GreedyAlgorithmsBasics.minimum_jumps([2, 3, 1, 1, 4]) == 2
    assert GreedyAlgorithmsBasics.minimum_jumps([2, 3, 0, 1, 4]) == 2
    assert GreedyAlgorithmsBasics.minimum_jumps([0]) == 0


def test_erase_overlap_intervals() -> None:
    assert GreedyAlgorithmsBasics.erase_overlap_intervals([[1, 2], [2, 3], [3, 4], [1, 3]]) == 1
    assert GreedyAlgorithmsBasics.erase_overlap_intervals([[1, 2], [1, 2], [1, 2]]) == 2
    assert GreedyAlgorithmsBasics.erase_overlap_intervals([]) == 0


def test_partition_labels() -> None:
    assert GreedyAlgorithmsBasics.partition_labels("ababcbacadefegdehijhklij") == [9, 7, 8]
    assert GreedyAlgorithmsBasics.partition_labels("eccbbbbdec") == [10]
