

## 🚀 Greedy Construction with Locked Positions | 461 ms | Beats 100% Time & Memory

---

## Intuition

We must build the **lexicographically smallest string** `word` of length `n + m − 1` such that every index `i` in `str1` imposes a rule on the substring `word[i … i+m−1]`.

* If `str1[i] == 'T'` → the substring must **exactly match `str2`**.
* If `str1[i] == 'F'` → the substring must **not match `str2`**.

Since substrings **overlap**, blindly generating strings is impossible.
Instead, we **construct the smallest possible string and enforce constraints carefully**.

Key ideas:

* Start with all `'a'` to guarantee **lexicographic minimality**.
* Characters forced by `'T'` constraints become **locked**.
* If an `'F'` window accidentally equals `str2`, we modify **one unlocked character** to break the match.

---

## Approach

### 1️⃣ Initialize the smallest string

Create a string of length:

```
n + m − 1
```

Fill it with `'a'`.

Also maintain a **locked array** to mark positions forced by `'T'`.

---

### 2️⃣ Apply all `T` constraints

For every `i` where `str1[i] == 'T'`:

```
word[i + j] = str2[j]
```

If a locked character conflicts → **return ""**.

These positions become **immutable**.

---

### 3️⃣ Fix `F` constraints

For every `i` where `str1[i] == 'F'`:

Check if:

```
word[i ... i+m-1] == str2
```

If it matches, break it by changing **one unlocked character**.

Prefer the **rightmost position** to keep the string lexicographically small.

If no change is possible → **return ""**.

---

### 4️⃣ Final verification

Because substrings overlap, verify again:

* `T` windows must equal `str2`
* `F` windows must not equal `str2`

If any rule fails → return `""`.

---

## Complexity

### Time Complexity

[
O(n \times m)
]

### Space Complexity
O(n)

---

If you want, I can also show you a **much stronger LeetCode post format (with diagrams + example walkthrough)** that usually gets **50–200 upvotes**.
