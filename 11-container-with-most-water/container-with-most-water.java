class Solution {
    public int maxArea(int[] height) {
        int n = height.length ;
        int curr = 0 , ans = 0 ;
        int i=0 , j=n-1 ;
        while(i<j) {
            if(height[i] <= height[j]) {
                curr = height[i] * (j-i) ;
                i++;
            }
            else {
                curr = height[j]*(j-i) ;
                j--;
            }
            if(curr > ans) {
                ans = curr ;
            }
        }
        return ans ;
    }
}