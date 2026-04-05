"""
Tree - Interview prep (Python)
================================
Real tree functionality and problem patterns.
"""

from __future__ import annotations


class TreeNode:
    def __init__(self, val: int = 0, left: TreeNode | None = None, right: TreeNode | None = None) -> None:
        self.val = val
        self.left = left
        self.right = right


def inorder_traversal(root: TreeNode | None) -> list[int]:
    result = []
    if root:
        result.extend(inorder_traversal(root.left))
        result.append(root.val)
        result.extend(inorder_traversal(root.right))
    return result


def max_depth(root: TreeNode | None) -> int:
    if not root:
        return 0
    left_depth = max_depth(root.left)
    right_depth = max_depth(root.right)
    return max(left_depth, right_depth) + 1


def main() -> None:
    # Demo
    root = TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3))
    print("Inorder traversal:", inorder_traversal(root))
    print("Max depth:", max_depth(root))


if __name__ == "__main__":
    main()
