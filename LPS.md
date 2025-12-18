
# 5. Longest Palindromic Substring

## Problem
Given a string `s`, return the longest palindromic substring in `s`.

### Examples
**Example 1:**
- Input: `s = "babad"`
- Output: `"bab"` (or `"aba"`)

**Example 2:**
- Input: `s = "cbbd"`
- Output: `"bb"`

### Constraints
- `1 <= s.length <= 1000`
- `s` consists of only digits and English letters

## Solution: Expand Around Center

### Approach
Iterate through each character as a center and expand outward to find palindromes. Check both odd-length (single center) and even-length (two centers) palindromes.

### Complexity
- **Time:** O(n²)
- **Space:** O(1)

### Code
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(odd, even);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
```
