class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length ;
        int maxsofar = -1 ;
        int ans[] = new int[n] ;
        //ans[n-1] = -1 ;
        for(int i=n-1 ; i>=0 ; i--) {
            ans[i] = maxsofar ;
            if(arr[i] > maxsofar) {
                maxsofar = arr[i] ;
            }
        }
        return ans ;
    }
}