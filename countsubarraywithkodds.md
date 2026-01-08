# Count Subarray with k Odds

## Problem Statement

You are given an array arr[] of positive integers and an integer k. You have to count the number of subarrays that contain exactly k odd numbers.

## Examples

### Example 1:

**Input:** arr[] = [2, 5, 6, 9], k = 2  
**Output:** 2  
**Explanation:** There are 2 subarrays with 2 odds: [2, 5, 6, 9] and [5, 6, 9].

### Example 2:

**Input:** arr[] = [2, 2, 5, 6, 9, 2, 11], k = 2  
**Output:** 8  
**Explanation:** There are 8 subarrays with 2 odds: [2, 2, 5, 6, 9], [2, 5, 6, 9], [5, 6, 9], [2, 2, 5, 6, 9, 2], [2, 5, 6, 9, 2], [5, 6, 9, 2], [6, 9, 2, 11] and [9, 2, 11].

## Constraints

- 1 ≤ k ≤ arr.size() ≤ 10^5
- 1 ≤ arr[i] ≤ 10^9

## Solution

```java
class Solution {
    public int countSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    private int atMost(int[] arr, int k) {
        int left = 0, count = 0, odd = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] % 2 != 0) odd++;

            while (odd > k) {
                if (arr[left] % 2 != 0) odd--;
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}
```

## Explanation

- The problem requires counting subarrays with exactly k odd numbers.
- Use the sliding window technique to count subarrays with at most k odd numbers, then subtract the count for at most (k-1) to get exactly k.
- In the `atMost` function, maintain a window where the number of odd numbers is at most k.
- Expand the right pointer, increment odd count if the number is odd.
- If odd count exceeds k, move the left pointer until the condition is satisfied.
- Add the number of valid subarrays ending at right (right - left + 1) to the count.
- This approach ensures O(n) time complexity.
