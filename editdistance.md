# 72. Edit Distance

## Problem Statement
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

## Constraints
- 0 <= word1.length, word2.length <= 500
- word1 and word2 consist of lowercase English letters.

## Examples

### Example 1
```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

### Example 2
```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

## Solution - Dynamic Programming

### Approach
Use a 2D DP table where dp[i][j] represents the minimum operations to convert word1[0..i-1] to word2[0..j-1].

Base cases: dp[i][0] = i (deletions), dp[0][j] = j (insertions)

For each cell, if characters match, dp[i][j] = dp[i-1][j-1]

Else, dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

### Code
```java
class Solution {
    public int minDistance(String word1, String word2 ) {
        int n = word1.length() ;
        int m = word2.length();
        int dp[][] = new int[n+1][m+1] ;
        for(int i=0 ; i<=n ; i++) {
            dp[i][0] = i;
        }
        for(int j=0 ; j<=m ; j++) {
            dp[0][j] = j;
        }
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=m ; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] ;
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1])) + 1 ;
                }
            }
        }
        return dp[n][m] ;
        
    }
}
```

### Complexity
- **Time**: O(n*m)
- **Space**: O(n*m)
