import importlib.util
import pathlib

spec = importlib.util.spec_from_file_location(
    "queue_basics", pathlib.Path(__file__).parent / "01_basics.py"
)
queue_module = importlib.util.module_from_spec(spec)
assert spec and spec.loader
spec.loader.exec_module(queue_module)

SimpleQueue = queue_module.SimpleQueue
sliding_window_maximum = queue_module.sliding_window_maximum


def test_simple_queue_basic_ops():
    q = SimpleQueue()
    assert q.is_empty()

    q.enqueue(10)
    q.enqueue(20)
    q.enqueue(30)

    assert not q.is_empty()
    assert len(q) == 3
    assert q.peek() == 10
    assert q.dequeue() == 10
    assert q.peek() == 20
    assert len(q) == 2


def test_sliding_window_maximum():
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    expected = [3, 3, 5, 5, 6, 7]
    assert sliding_window_maximum(nums, 3) == expected


def test_sliding_window_edge_cases():
    assert sliding_window_maximum([], 3) == []
    assert sliding_window_maximum([1, 2, 3], 0) == []
