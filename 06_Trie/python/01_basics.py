"""
Trie - Basic operations in Python
=================================
Implements insert/search/starts_with for lowercase words.
"""

from typing import Dict


class TrieNode:
    def __init__(self) -> None:
        self.children: Dict[str, "TrieNode"] = {}
        self.is_end: bool = False


class Trie:
    def __init__(self) -> None:
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
        node.is_end = True

    def search(self, word: str) -> bool:
        node = self._traverse(word)
        return bool(node and node.is_end)

    def starts_with(self, prefix: str) -> bool:
        return self._traverse(prefix) is not None

    def _traverse(self, text: str) -> TrieNode | None:
        node = self.root
        for ch in text:
            if ch not in node.children:
                return None
            node = node.children[ch]
        return node


if __name__ == "__main__":
    trie = Trie()
    words = ["apple", "app", "apt", "bat"]
    for w in words:
        trie.insert(w)

    print("search('app'):", trie.search("app"))
    print("search('ap'):", trie.search("ap"))
    print("starts_with('ap'):", trie.starts_with("ap"))
    print("starts_with('cat'):", trie.starts_with("cat"))
