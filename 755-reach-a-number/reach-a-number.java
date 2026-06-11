class Solution {
    public int reachNumber(int target) {
        //int i=0 ;
        if(target == 0) return 0 ;
        if(target == 1 || target == -1) return 1 ;
        target = Math.abs(target) ;
        int count = 0 ;
        int dist = 0 ;
        int currentstep = 0 ;
        while(dist < target  || (dist - target) % 2 != 0) {

            currentstep++ ;
            dist += currentstep ;
        }
        return currentstep ;
    }
}