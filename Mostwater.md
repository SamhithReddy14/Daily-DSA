# 🪣 Container With Most Water

**LeetCode #11 — Medium**

---

## 📌 Problem Statement

You are given an integer array `height` of length `n`.

There are `n` vertical lines drawn such that the two endpoints of the `i-th` line are  
`(i, 0)` and `(i, height[i])`.

Find two lines that together with the **x-axis** form a container, such that the container
contains the **maximum amount of water**.

> You may **not slant** the container.

---

## 🧪 Examples

### Example 1
**Input**
```
height = [1,8,6,2,5,4,8,3,7]
```

**Output**
```
49
```

**Explanation**

The maximum area is formed between heights `8` and `7`:
```
min(8, 7) × (8 - 1) = 7 × 7 = 49
```

---

### Example 2
**Input**
```
height = [1,1]
```

**Output**
```
1
```

---

## 🧠 Approach — Two Pointer Technique

The area of water between two lines depends on:
```
Area = min(height[left], height[right]) × (right - left)
```

- Start with two pointers:
  - `left = 0`
  - `right = n - 1`
- Move the pointer with the **smaller height**, since the height limits the area.
- Keep track of the maximum area found.

---

## 🚀 Algorithm Steps

1. Initialize two pointers `i = 0`, `j = n - 1`
2. Initialize `ans = 0`
3. While `i < j`:
   - Compute the area using the smaller height
   - Update `ans` if the area is larger
   - Move the pointer pointing to the smaller height
4. Return `ans`

---

## 💻 Java Solution

```java
class Solution {
    public int maxArea(int[] H) {
        int ans = 0;
        int i = 0, j = H.length - 1;

        while (i < j) {
            int width = j - i;
            int height = Math.min(H[i], H[j]);
            int area = height * width;

            ans = Math.max(ans, area);

            if (H[i] <= H[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
```

---

## ⏱️ Complexity Analysis

| Type  | Complexity |
|------|------------|
| Time | **O(n)**   |
| Space | **O(1)** |

---

## ✅ Summary

- Uses **Two Pointer Greedy Strategy**
- Optimal solution compared to brute force `O(n²)`
- Efficient and clean implementation
- Common interview & DSA problem
