# Substrings with K Distinct

## Difficulty
Medium

## Accuracy
20.46%

## Submissions
185K+

## Points
4

## Average Time
20m

## Problem Statement
You are given a string s consisting of lowercase characters and an integer k. You have to count all possible substrings that have exactly k distinct characters.

## Examples

### Input: s = "abc", k = 2
### Output: 2
### Explanation: Possible substrings are ["ab", "bc"]

### Input: s = "aba", k = 2
### Output: 3
### Explanation: Possible substrings are ["ab", "ba", "aba"]

### Input: s = "aa", k = 1
### Output: 3
### Explanation: Possible substrings are ["a", "a", "aa"]

## Constraints
- 1 ≤ s.size() ≤ 10^6
- 1 ≤ k ≤ 26

## Solution

```java
import java.util.*;

class Solution {
    public int countSubstr(String s, int k) {
        // Using the sliding window technique to count substrings with exactly k distinct characters
        // by calculating substrings with at most k distinct minus at most (k-1) distinct
        return atMost(s, k) - atMost(s, k - 1);
    }

    private int atMost(String s, int k) {
        int left = 0, count = 0;
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            while (hm.size() > k) {
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                if (hm.get(s.charAt(left)) == 0) {
                    hm.remove(s.charAt(left));
                }
                left++;
            }
            count += i - left + 1;
        }
        return count;
    }
}
```

## Explanation
- The `countSubstr` method uses the inclusion-exclusion principle by computing substrings with at most k distinct characters and subtracting those with at most (k-1) distinct characters.
- The `atMost` helper method employs a sliding window approach:
  - It maintains a window from `left` to `i`.
  - Uses a HashMap to track character frequencies.
  - Expands the window by adding characters at `i`.
  - Shrinks the window from the left if the number of distinct characters exceeds k.
  - Adds the number of valid substrings ending at `i` to the count.
- Time Complexity: O(n), where n is the length of the string, as each character is processed a constant number of times.
- Space Complexity: O(min(n, 26)), since the HashMap stores at most 26 lowercase characters.
