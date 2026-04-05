import importlib.util
import pathlib

spec = importlib.util.spec_from_file_location(
    "tree_basics", pathlib.Path(__file__).parent / "01_basics.py"
)
tree_module = importlib.util.module_from_spec(spec)
assert spec and spec.loader
spec.loader.exec_module(tree_module)

TreeNode = tree_module.TreeNode
inorder_traversal = tree_module.inorder_traversal
max_depth = tree_module.max_depth


def test_inorder_traversal():
    root = TreeNode(1, None, TreeNode(2, TreeNode(3)))
    assert inorder_traversal(root) == [1, 3, 2]


def test_max_depth():
    root = TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3))
    assert max_depth(root) == 3


def test_max_depth_empty():
    assert max_depth(None) == 0


def test_max_depth_single():
    root = TreeNode(5)
    assert max_depth(root) == 1