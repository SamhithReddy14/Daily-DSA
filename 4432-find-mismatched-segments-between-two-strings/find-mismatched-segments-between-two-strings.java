class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        int n = s1.length();
        List<List<String>> list = new ArrayList<>();
        int i = 0;
        while (i < n) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
                continue;
            }
            int start = i;
            while (i < n && s1.charAt(i) != s2.charAt(i)) {
                i++;
            }
            String sub1 = s1.substring(start, i);
            String sub2 = s2.substring(start, i); 
            list.add(Arrays.asList(sub1, sub2));
        }
        
        return list;
    }
}