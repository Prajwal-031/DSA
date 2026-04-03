import importlib.util
import pathlib

spec = importlib.util.spec_from_file_location(
    "linklist_basics", pathlib.Path(__file__).parent / "01_basics.py"
)
linklist_module = importlib.util.module_from_spec(spec)
assert spec and spec.loader
spec.loader.exec_module(linklist_module)

ListNode = linklist_module.ListNode
reverse_list = linklist_module.reverse_list


def test_reverse_list():
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
    reversed_head = reverse_list(head)
    assert reversed_head.val == 4
    assert reversed_head.next.val == 3
    assert reversed_head.next.next.val == 2
    assert reversed_head.next.next.next.val == 1
    assert reversed_head.next.next.next.next is None


def test_reverse_empty_list():
    assert reverse_list(None) is None


def test_reverse_single_node():
    head = ListNode(5)
    reversed_head = reverse_list(head)
    assert reversed_head.val == 5
    assert reversed_head.next is None