class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length ;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()) ;
        for(int x : gifts) {
            pq.offer(x);
        }
        while(k-->0) {
            int x = pq.poll() ;
            long root = (long) Math.sqrt(x);
            pq.offer((int)root);
        }
        long ans = 0 ;
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans ;
    }
}