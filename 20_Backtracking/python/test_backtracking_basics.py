from __future__ import annotations
import importlib.util
from pathlib import Path


MODULE_PATH = Path(__file__).with_name("01_basics.py")
SPEC = importlib.util.spec_from_file_location("backtracking_basics", MODULE_PATH)
assert SPEC is not None and SPEC.loader is not None
backtracking_basics = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(backtracking_basics)
BacktrackingBasics = backtracking_basics.BacktrackingBasics
subsets = backtracking_basics.subsets
permutations = backtracking_basics.permutations
combination_sum = backtracking_basics.combination_sum
generate_parentheses = backtracking_basics.generate_parentheses
n_queens = backtracking_basics.n_queens


def test_subsets() -> None:
    result = subsets([1, 2, 3])
    expected = [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    assert sorted([tuple(s) for s in result]) == sorted([tuple(e) for e in expected])


def test_subsets_empty() -> None:
    assert subsets([]) == [[]]


def test_permutations() -> None:
    result = permutations([1, 2, 3])
    expected = [
        [1, 2, 3], [1, 3, 2], [2, 1, 3],
        [2, 3, 1], [3, 1, 2], [3, 2, 1]
    ]
    assert sorted([tuple(p) for p in result]) == sorted([tuple(e) for e in expected])


def test_permutations_single() -> None:
    assert permutations([7]) == [[7]]


def test_combination_sum() -> None:
    result = combination_sum([2, 3, 6, 7], 7)
    expected = [[7], [2, 2, 3]]
    assert sorted([tuple(sorted(c)) for c in result]) == sorted([tuple(sorted(e)) for e in expected])


def test_combination_sum_no_solution() -> None:
    assert combination_sum([2, 4], 7) == []


def test_generate_parentheses() -> None:
    result = generate_parentheses(3)
    expected = [
        "((()))", "(()())", "(())()", "()(())", "()()()"
    ]
    assert sorted(result) == sorted(expected)


def test_generate_parentheses_n1() -> None:
    assert generate_parentheses(1) == ["()"]


def test_n_queens() -> None:
    result = n_queens(4)
    assert len(result) == 2
    expected = [
        [".Q..", "...Q", "Q...", "..Q."],
        ["..Q.", "Q...", "...Q", ".Q.."]
    ]
    assert sorted([tuple(r) for r in result]) == sorted([tuple(e) for e in expected])


def test_n_queens_n1() -> None:
    assert n_queens(1) == [["Q"]]
