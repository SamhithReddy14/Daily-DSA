class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int k = s1.length();
        if (k > s2.length()) return false;
        for (int i = 0; i <= s2.length() - k; i++) {
            String s = s2.substring(i, i + k);
            if (isPermutation(s, freq)) {
                return true;
            }
        }
        return false;
    }
    public boolean isPermutation(String s, int[] freq) {
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] != freq[i]) {
                return false;
            }
        }
        return true;
    }
}