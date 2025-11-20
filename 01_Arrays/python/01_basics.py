"""
Arrays - Basic Operations in Python
====================================
This file covers fundamental array operations
"""

# ============================================
# 1. Array Declaration & Initialization
# ============================================

# Fixed elements
arr1 = [1, 2, 3, 4, 5]
print("Array 1:", arr1)

# Empty array
arr2 = []
print("Empty array:", arr2)

# Array with default values
arr3 = [0] * 10  # [0, 0, 0, ..., 0]
print("Array with 10 zeros:", arr3)

# Array with range
arr4 = list(range(1, 6))  # [1, 2, 3, 4, 5]
print("Array with range:", arr4)

# ============================================
# 2. Accessing Elements
# ============================================

arr = [10, 20, 30, 40, 50]

# Access by index (O(1))
print("\nFirst element:", arr[0])      # 10
print("Last element:", arr[-1])       # 50
print("Second element:", arr[1])      # 20

# Slicing
print("First 3 elements:", arr[:3])    # [10, 20, 30]
print("Last 2 elements:", arr[-2:])   # [40, 50]
print("Middle elements:", arr[1:4])   # [20, 30, 40]

# ============================================
# 3. Modifying Elements
# ============================================

arr = [1, 2, 3, 4, 5]

# Update element (O(1))
arr[0] = 100
print("\nAfter update:", arr)  # [100, 2, 3, 4, 5]

# ============================================
# 4. Adding Elements
# ============================================

arr = [1, 2, 3]

# Append at end (O(1) amortized)
arr.append(4)
print("\nAfter append:", arr)  # [1, 2, 3, 4]

# Insert at position (O(n))
arr.insert(1, 99)
print("After insert at index 1:", arr)  # [1, 99, 2, 3, 4]

# Extend with another array (O(k) where k is length of new array)
arr.extend([5, 6])
print("After extend:", arr)  # [1, 99, 2, 3, 4, 5, 6]

# ============================================
# 5. Removing Elements
# ============================================

arr = [1, 2, 3, 4, 5, 3]

# Remove by value (O(n))
arr.remove(3)  # Removes first occurrence
print("\nAfter remove(3):", arr)  # [1, 2, 4, 5, 3]

# Remove by index (O(n))
arr.pop(0)  # Remove at index 0
print("After pop(0):", arr)  # [2, 4, 5, 3]

# Pop last element (O(1))
last = arr.pop()
print("Popped element:", last)  # 3
print("After pop():", arr)  # [2, 4, 5]

# ============================================
# 6. Searching Elements
# ============================================

arr = [10, 20, 30, 40, 50]

# Check if element exists (O(n))
print("\n30 in array:", 30 in arr)  # True
print("100 in array:", 100 in arr)  # False

# Find index (O(n))
print("Index of 30:", arr.index(30))  # 2

# Count occurrences (O(n))
arr_with_duplicates = [1, 2, 2, 3, 2, 4]
print("Count of 2:", arr_with_duplicates.count(2))  # 3

# ============================================
# 7. Array Length & Iteration
# ============================================

arr = [1, 2, 3, 4, 5]

# Length
print("\nArray length:", len(arr))  # 5

# Iteration methods
print("\nIteration methods:")
print("Method 1 - Direct iteration:")
for element in arr:
    print(element, end=" ")
print()

print("Method 2 - With index:")
for i in range(len(arr)):
    print(f"arr[{i}] = {arr[i]}", end=", ")
print()

print("Method 3 - Enumerate:")
for index, value in enumerate(arr):
    print(f"Index {index}: {value}", end=", ")
print()

# ============================================
# 8. Common Array Operations
# ============================================

arr = [3, 1, 4, 1, 5, 9, 2, 6]

# Sort (O(n log n))
arr_sorted = sorted(arr)  # Returns new sorted array
print("\nOriginal:", arr)
print("Sorted (new):", arr_sorted)

arr.sort()  # In-place sort
print("Sorted (in-place):", arr)

# Reverse
arr.reverse()
print("Reversed:", arr)

# Maximum and Minimum
print("Max:", max(arr))
print("Min:", min(arr))
print("Sum:", sum(arr))

# ============================================
# 9. Multi-dimensional Arrays
# ============================================

# 2D Array (Matrix)
matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print("\n2D Array:")
for row in matrix:
    print(row)

# Access element
print("Element at [1][2]:", matrix[1][2])  # 6

# ============================================
# 10. Array Copying
# ============================================

original = [1, 2, 3, 4, 5]

# Shallow copy (reference)
copy1 = original
copy1[0] = 100
print("\nOriginal after shallow copy:", original)  # [100, 2, 3, 4, 5]

# Deep copy (independent)
original = [1, 2, 3, 4, 5]
copy2 = original.copy()  # or list(original) or original[:]
copy2[0] = 200
print("Original after deep copy:", original)  # [1, 2, 3, 4, 5]
print("Copy:", copy2)  # [200, 2, 3, 4, 5]

