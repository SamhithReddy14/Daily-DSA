# 🟢 Jump Game II (LeetCode – Medium)

## 📌 Problem Statement
You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at index 0.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at index `i`, you can jump to any index `(i + j)` where:

- `0 <= j <= nums[i]` and
- `i + j < n`

Return the **minimum number of jumps** to reach index `n - 1`. The test cases are generated such that you can reach index `n - 1`.

---

## 🧪 Examples

### Example 1
```
Input: nums = [2,3,1,1,4]
Output: 2
```
**Explanation:**  
The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

---

### Example 2
```
Input: nums = [2,3,0,1,4]
Output: 2
```

---

## 🧠 Approach — Greedy (Forward Traversal)

- Use a greedy strategy to always jump to the farthest possible position.
- Maintain the current end of the range and the farthest reachable index.
- Increment jump count when reaching the current end.

---

## 🔍 Algorithm
1. Initialize `jump = 0`, `farthest = 0`, `end = 0`
2. Iterate from `i = 0` to `n-2`
3. Update `farthest` with `max(farthest, i + nums[i])`
4. If `i == end`, increment `jump` and set `end = farthest`
5. Return `jump`

---

## 💻 Java Solution

```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jump = 0;
        int farthest = 0;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jump++;
                end = farthest;
            }
        }
        return jump;
    }
}
```

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## 🏷️ Tags
- Greedy
- Array
- Dynamic Programming (Optimized)

---

## ✅ Status
✔️ Solved  
✔️ Accepted on LeetCode  
✔️ Optimal Solution
