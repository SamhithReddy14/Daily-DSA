# 260. Single Number III

## Problem Statement

Given an integer array `nums`, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

### Examples

**Example 1:**

```
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation: [5, 3] is also a valid answer.
```

**Example 2:**

```
Input: nums = [-1,0]
Output: [-1,0]
```

**Example 3:**

```
Input: nums = [0,1]
Output: [1,0]
```

### Constraints

- `2 <= nums.length <= 3 * 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
- Each integer in `nums` will appear twice, only two integers will appear once.

## Solution

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int diffbit = xor & -xor;
        int a = 0, b = 0;
        for (int n : nums) {
            if ((n & diffbit) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
```

### Explanation

- First, XOR all elements to get the XOR of the two unique numbers.
- Find the rightmost set bit in the XOR result, which differentiates the two unique numbers.
- Divide the array into two groups based on that bit and XOR within each group to find the unique numbers.
