# 🟢 Jump Game (LeetCode – Medium)

## 📌 Problem Statement
You are given an integer array `nums`.

- You start at the **first index (0)**.
- Each element represents the **maximum jump length** at that position.

Return **true** if you can reach the **last index**, otherwise return **false**.

---

## 🧪 Examples

### Example 1
```
Input:  nums = [2,3,1,1,4]
Output: true
```
**Explanation:**  
Jump from index `0 → 1`, then jump `3` steps to reach the last index.

---

### Example 2
```
Input:  nums = [3,2,1,0,4]
Output: false
```
**Explanation:**  
You will always land on index `3`, which has jump length `0`, making it impossible to move forward.

---

## 🧠 Approach — Greedy (Backward Traversal)

- Treat the **last index** as the goal.
- Traverse the array **from right to left**.
- If from index `i` you can reach or pass the current goal  
  (`i + nums[i] ≥ goal`), update the goal to `i`.
- If the goal becomes `0`, the last index is reachable.

---

## 🔍 Algorithm
1. Initialize `goal = nums.length - 1`
2. Traverse the array from right to left
3. Update the goal when a position can reach it
4. Return whether `goal == 0`

---

## 💻 Java Solution

```java
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        return goal == 0;
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
