class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> m=new HashMap<>();
        for(int i:nums){
            m.put(i, m.getOrDefault(i, 0)+1);
        }
        int maxi=0;
        for(int key:m.keySet()){
            if(m.containsKey(key+1)){
                maxi=Math.max(maxi, m.get(key)+m.get(key+1));
            }
        }
        return maxi;
    }
}