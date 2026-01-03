# 1411. Number of Ways to Paint N × 3 Grid

## Problem Statement

You have a grid of size `n x 3` and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).

Given `n` the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo `10^9 + 7`.

### Example 1:

**Input:** n = 1  
**Output:** 12  
**Explanation:** There are 12 possible ways to paint the grid as shown.

### Example 2:

**Input:** n = 5000  
**Output:** 30228214  

### Constraints:

- `n == grid.length`
- `1 <= n <= 5000`

## Solution

```java
class Solution {
    public int numOfWays(int n) {
        long MOD = 1000000007L;
        long a = 6;
        long b = 6;
        for (int i = 2; i <= n; i++) {
            long newA = (3 * a + 2 * b) % MOD;
            long newB = (2 * a + 2 * b) % MOD;
            a = newA;
            b = newB;
        }
        return (int) ((a + b) % MOD);
    }
}
```

### Approach

This solution uses dynamic programming to efficiently compute the number of ways to paint the grid. It tracks two states: `a` representing the number of ways for rows with certain color patterns, and `b` for others. The recurrence relations are derived from the constraints of adjacent cells not sharing the same color. Time complexity is O(n), and space complexity is O(1), making it suitable for large n up to 5000.
