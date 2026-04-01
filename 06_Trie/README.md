# Trie - Complete Guide for Interviews

## What is a Trie?

A **Trie** (prefix tree) is a tree-like data structure used to store strings so that common prefixes are shared. Each edge represents a character, and each node represents a prefix.

### Key characteristics

- **Prefix-based lookup** - efficient for dictionary/prefix queries
- **Character-by-character traversal** - follows the word from root to leaf
- **Space for speed tradeoff** - can use more memory than hash sets, but supports prefix operations naturally

---

## Core concepts

### 1. Basic operations

| Operation | Meaning |
|-----------|---------|
| `insert(word)` | Add a word into the trie |
| `search(word)` | Return true if exact word exists |
| `starts_with(prefix)` | Return true if any word has this prefix |
| `delete(word)` | Remove word (optional in interviews) |

### 2. Time complexities

Let `L` = length of word/prefix.

| Operation | Time | Space (per op) |
|-----------|------|----------------|
| insert | O(L) | O(L) new nodes in worst case |
| search | O(L) | O(1) |
| starts_with | O(L) | O(1) |
| delete | O(L) | O(1) (can free nodes depending on implementation) |

### 3. Common patterns

1. **Prefix dictionary** - autocomplete and prefix existence checks
2. **Word search/backtracking** - trie + DFS on board (`Word Search II`)
3. **Bitwise trie** - maximum XOR style numeric problems

---

## Interview problems (easy -> hard)

### Easy

1. **Implement Trie (Prefix Tree)** - build `insert/search/startsWith`
2. **Longest Common Prefix** - trie approach (even if sorting is simpler)

### Medium

1. **Design Add and Search Words Data Structure** - trie + wildcard DFS
2. **Replace Words** - use trie for root-word replacement
3. **Map Sum Pairs** - prefix sum queries over inserted words

### Hard

1. **Word Search II** - trie + board DFS + pruning
2. **Maximum XOR of Two Numbers in an Array** - bitwise trie

---

## Learning path

1. Implement trie node + `insert/search/starts_with`
2. Solve Implement Trie and one wildcard/prefix problem
3. Combine trie with DFS (Word Search II)
4. Practice bitwise trie for XOR problems

See `python/01_basics.py` and `java/TrieBasics.java` for minimal working examples.
