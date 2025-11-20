# Arrays - Complete Guide for Interviews

## 📖 What is an Array?

An **array** is a collection of elements stored at contiguous memory locations. All elements are of the same data type.

### Key Characteristics:
- **Fixed size** (in most languages) or **dynamic** (Python lists, Java ArrayList)
- **Indexed access**: O(1) time complexity
- **Contiguous memory**: Elements stored next to each other
- **Zero-based indexing**: First element at index 0

---

## 🎯 Core Concepts

### 1. **Declaration & Initialization**

**Python:**
```python
# Fixed size (using list)
arr = [1, 2, 3, 4, 5]

# Empty array
arr = []

# Array with size
arr = [0] * 10  # [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
```

**Java:**
```java
// Fixed size array
int[] arr = {1, 2, 3, 4, 5};
int[] arr = new int[10];  // All zeros

// Dynamic (ArrayList)
ArrayList<Integer> list = new ArrayList<>();
```

### 2. **Time Complexities**

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Access by index | O(1) | O(1) |
| Search | O(n) | O(1) |
| Insert at end | O(1) amortized | O(1) |
| Insert at position | O(n) | O(1) |
| Delete | O(n) | O(1) |

### 3. **Common Patterns**

1. **Two Pointers** - Left and right pointers
2. **Sliding Window** - Fixed/variable size window
3. **Prefix Sum** - Cumulative sum array
4. **Two Sum** - Hash map for complement
5. **Kadane's Algorithm** - Maximum subarray sum

---

## 📝 Interview Problems (Easy → Hard)

### **Easy Problems:**
1. Two Sum
2. Best Time to Buy and Sell Stock
3. Contains Duplicate
4. Maximum Subarray
5. Rotate Array

### **Medium Problems:**
1. 3Sum
2. Container With Most Water
3. Product of Array Except Self
4. Longest Consecutive Sequence
5. Merge Intervals

### **Hard Problems:**
1. Trapping Rain Water
2. Maximum Product Subarray
3. Sliding Window Maximum
4. First Missing Positive
5. Merge Sorted Arrays

---

## 🎓 Learning Path

1. Start with basic operations
2. Solve easy problems (build confidence)
3. Learn common patterns
4. Practice medium problems
5. Master hard problems

**Navigate to `python/` or `java/` folders for code examples!**

