class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length ;
        int curr = 0 ;
        int count = 0 ;
        List<Integer> list = new ArrayList<>() ;
        for(int i=0 ; i<n ; i++) {
            if(curr != nums[i]) {
                curr = nums[i] ;
                count = 0 ;
            }
            if(curr == nums[i]) {
                count++;
            }
            if(count <= k && count!=0) {
                list.add(curr);
            }
        }
        int arr[] = new int[list.size()] ;
        for(int i=0 ; i<list.size() ; i++) {
            arr[i] = list.get(i);
        }
        return arr ;
    }
}