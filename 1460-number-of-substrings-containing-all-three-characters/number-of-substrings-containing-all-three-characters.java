class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (map.getOrDefault('a', 0) >= 1 &&
                   map.getOrDefault('b', 0) >= 1 &&
                   map.getOrDefault('c', 0) >= 1) {
                count += n - i;
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    map.remove(s.charAt(j));
                }
                j++;
            }
        }
        return count;
    }
}