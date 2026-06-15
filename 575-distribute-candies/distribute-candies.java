class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length ;
        int caneat = n/2 ;
        HashSet<Integer> set = new HashSet<>() ;
        for(int x : candyType) {
            set.add(x);
        }
        if(set.size() < caneat) return set.size() ;
        return caneat ;
    }
}