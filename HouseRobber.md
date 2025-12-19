
# 198. House Robber

## Problem Statement
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. Adjacent houses have connected security systems, so you cannot rob two adjacent houses on the same night.

Given an integer array `nums` representing the amount of money in each house, return the maximum amount of money you can rob without alerting the police.

## Constraints
- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 400`

## Examples

### Example 1
```
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and house 3 (money = 3). Total = 4.
```

### Example 2
```
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob houses 1, 3, and 5 (money = 2 + 9 + 1). Total = 12.
```

## Solution - Dynamic Programming with Space Optimization

### Approach
At each house, decide whether to rob it or skip it:
- **Rob**: Current money + max from houses up to i-2
- **Skip**: Max money from houses up to i-1

Use two variables to track the last two states instead of an array.

### Code
```java
class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;  // Max money up to i-2
        int prev1 = 0;  // Max money up to i-1
        
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)
