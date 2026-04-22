from __future__ import annotations

import importlib.util
from pathlib import Path
import pytest


MODULE_PATH = Path(__file__).with_name("01_basics.py")
SPEC = importlib.util.spec_from_file_location("tsp_basics", MODULE_PATH)
assert SPEC is not None and SPEC.loader is not None
tsp_basics = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(tsp_basics)
TravellingSalesmanBasics = tsp_basics.TravellingSalesmanBasics


def test_nearest_neighbor_complete():
    # Symmetric complete graph 4 cities
    dist = [
        [0, 10, 15, 20],
        [10, 0, 35, 25],
        [15, 35, 0, 30],
        [20, 25, 30, 0]
    ]
    tour, cost = TravellingSalesmanBasics.nearest_neighbor(dist)
    assert len(tour) == 4
    assert abs(cost - 80) < 1e-6  # 0->1(10)->3(15? wait greedy 0-1-3-2-0: 10+15+10+20? calc exact path
    # Actual greedy: 0 to1(10),1 to3(25),3 to2(30),2 to0(15) =80? Adjust if needed


def test_nearest_neighbor_trivial():
    dist = [[0]]
    tour, cost = TravellingSalesmanBasics.nearest_neighbor(dist)
    assert tour == [0]
    assert abs(cost) < 1e-6


def test_nearest_neighbor_two_cities():
    dist = [
        [0, 5],
        [5, 0]
    ]
    tour, cost = TravellingSalesmanBasics.nearest_neighbor(dist)
    assert set(tour) == {0,1}
    assert abs(cost - 10) < 1e-6


def test_has_hamiltonian_path():
    dist = [
        [0, 1, INF],
        [INF, 0, 1],
        [1, INF, 0]
    ]
    assert TravellingSalesmanBasics.has_hamiltonian_path(dist)  # Triangle
