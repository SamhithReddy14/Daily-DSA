class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> map = new HashMap<>();

        for(String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq =
            new PriorityQueue<>((a,b) -> {
                if(a.getValue().equals(b.getValue()))
                    return a.getKey().compareTo(b.getKey());
                return b.getValue() - a.getValue();
            });
        pq.addAll(map.entrySet());
        List<String> ans = new ArrayList<>();
        while(k-- > 0) {
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}