import importlib.util
import pathlib

spec = importlib.util.spec_from_file_location(
    "graph_basics", pathlib.Path(__file__).parent / "01_basics.py"
)
graph_module = importlib.util.module_from_spec(spec)
assert spec and spec.loader
spec.loader.exec_module(graph_module)

Graph = graph_module.Graph
num_islands = graph_module.num_islands


def test_graph_dfs():
    g = Graph()
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(1, 2)
    g.add_edge(2, 3)
    
    dfs_result = g.dfs(0)
    assert len(dfs_result) == 4
    assert set(dfs_result) == {0, 1, 2, 3}


def test_graph_bfs():
    g = Graph()
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(1, 2)
    
    bfs_result = g.bfs(0)
    assert len(bfs_result) == 3
    assert set(bfs_result) == {0, 1, 2}


def test_number_of_islands():
    grid = [['1', '1', '0', '0'], ['1', '0', '0', '1'], ['0', '0', '1', '1']]
    assert num_islands(grid) == 3


def test_number_of_islands_no_islands():
    grid = [['0', '0', '0'], ['0', '0', '0']]
    assert num_islands(grid) == 0