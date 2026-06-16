class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high = 0;
        for(int w : weights) {
            low = Math.max(low, w);  
            high += w;               
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(canShip(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean canShip(int[] weights, int capacity, int days) {
        int dayCount = 1;
        int currentLoad = 0;
        for(int w : weights) {
            if(currentLoad + w > capacity) {
                dayCount++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return dayCount <= days;
    }
}