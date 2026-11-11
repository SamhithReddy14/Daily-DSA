class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int minneed = Math.min(need1,need2);
        long cost = 0 ;
        cost += (long)minneed*Math.min(costBoth,cost1+cost2);
        int diff = need1-need2;
        if(diff > 0) {
            cost += (long)diff*Math.min(costBoth,cost1) ;
        }
        else if(diff < 0) {
            cost += (long)Math.abs(diff)*Math.min(costBoth,cost2);
        }
        return cost ;
    }
}