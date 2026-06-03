class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>() ;
        List<Integer> list = new ArrayList<>() ;
        for(int x : nums) {
            if(set.contains(x)){
                list.add(x);
            }
            set.add(x);
        }
        return list ;
    }
}