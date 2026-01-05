# 1975. Maximum Matrix Sum

## Problem Statement

You are given an n x n integer matrix. You can do the following operation any number of times:

Choose any two adjacent elements of matrix and multiply each of them by -1.
Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

### Example 1:

Input: matrix = [[1,-1],[-1,1]]  
Output: 4  
Explanation: We can follow the following steps to reach sum equals 4:  
- Multiply the 2 elements in the first row by -1.  
- Multiply the 2 elements in the first column by -1.

### Example 2:

Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]  
Output: 16  
Explanation: We can follow the following step to reach sum equals 16:  
- Multiply the 2 last elements in the second row by -1.

### Constraints:

- n == matrix.length == matrix[i].length
- 2 <= n <= 250
- -10^5 <= matrix[i][j] <= 10^5

## Solution Approach

This problem can be solved using a greedy approach. The key insight is that flipping two adjacent elements changes their signs, but since we can do this any number of times, it's equivalent to being able to flip the sign of any even number of elements or all elements except one.

To maximize the sum, we want all elements to be positive. The absolute sum is the maximum possible, but if there's an odd number of negative elements, we can't make all positive because each flip affects two elements.

Each operation flips two adjacent elements, which is like changing the parity of negative elements in a connected component, but since the matrix is fully connected via adjacency, it's global.

The number of negative elements modulo 2 determines if we can make all positive.

If even number of negatives, sum of absolutes.

If odd, we have to leave one negative, so subtract twice the smallest absolute value.

## Code

```java
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int negative = 0;
        long sum = 0;
        int minabs = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) negative++;
                int abs = Math.abs(matrix[i][j]);
                sum += abs;
                minabs = Math.min(minabs, abs);
            }
        }
        if (negative % 2 != 0) {
            sum -= 2L * minabs;
        }
        return sum;
    }
}
```

## Complexity

- Time: O(n^2)
- Space: O(1)
