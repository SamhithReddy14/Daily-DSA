# 974. Subarray Sums Divisible by K

## Problem Statement
Given an integer array `nums` and an integer `k`, return the number of non-empty subarrays that have a sum divisible by `k`.

A subarray is a contiguous part of an array.

## Constraints
- `1 <= nums.length <= 3 * 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `2 <= k <= 10^4`

## Examples

### Example 1
```
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
```

### Example 2
```
Input: nums = [5], k = 9
Output: 0
```

## Solution - Prefix Sum with HashMap

### Approach
Use prefix sums and a hashmap to count subarrays where the sum is divisible by k. Track the remainder of the prefix sum when divided by k. For each prefix sum, if the remainder has been seen before, add the count of previous occurrences to the result, as the subarray between those points has sum divisible by k. Handle negative remainders by adding k to make them positive.

### Code
```java
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixsum = 0;
        int count = 0;
        for (int n : nums) {
            prefixsum += n;
            int rem = prefixsum % k;
            if (rem < 0) rem += k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(k)
