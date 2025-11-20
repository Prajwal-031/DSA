"""
Strings - Basic Operations in Python
====================================
This file covers fundamental Strings operations
"""

# ============================================
# 1. Basic Operations
# ============================================

# String creation
s1 = "Hello"
s2 = 'World'
s3 = """Multi-line
string"""

print("String creation:", s1, s2)

# String concatenation
result = s1 + " " + s2
print("Concatenation:", result)

# String repetition
repeated = s1 * 3
print("Repetition:", repeated)

# String length
print("Length:", len(s1))

# String indexing and slicing
s = "Python"
print("First char:", s[0])      # P
print("Last char:", s[-1])      # n
print("Slice:", s[1:4])         # yth
print("Reverse:", s[::-1])      # nohtyP

if __name__ == "__main__":
    print("Strings Basics")

